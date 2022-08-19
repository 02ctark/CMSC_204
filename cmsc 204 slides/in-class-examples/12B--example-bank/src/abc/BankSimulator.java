package abc;
import java.io.IOException;
import java.util.Scanner;

/**
   This program demonstrates random access. You can access 
   existing accounts and deposit money, or create new accounts.
   The accounts are saved in a random access file.
*/
public class BankSimulator
{  
   public static void main(String[] args) throws IOException
   {  
      try (Scanner in = new Scanner(System.in);
         BankData data = new BankData())
      {  
         data.open("bank.dat");

         boolean done = false;
         while (!done)
         {  
            System.out.print("Account number: ");
            int accountNumber = in.nextInt();
            System.out.print("Amount to deposit: ");
            double amount = in.nextDouble();

            int position = data.find(accountNumber);
            BankAccount account;
            if (position >= 0)
            {
               account = data.read(position);
               account.deposit(amount);
               System.out.println("New balance: " + account.getBalance());
            }
            else // Add account
            {  
               account = new BankAccount(accountNumber, amount);
               position = data.size();
               System.out.println("New account added.");
            }
            data.write(position, account);

            System.out.print("More Transaction? (Y/N) ");
            String input = in.next();
            if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) { 
            	done = true;
            	System.out.print("Good bye.  Have a great day!");
            	}
         }      
      }
   }
}













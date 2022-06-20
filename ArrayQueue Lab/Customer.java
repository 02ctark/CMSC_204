
public class Customer {

	//fields
	private int clock, transactionTime, numberOfArrivals;
	
	//constructor
	Customer(int clock, int transactionTime, int numberOfArrivals){
		
		this.clock = clock;
		this.transactionTime = transactionTime;
		this.numberOfArrivals = numberOfArrivals;
		
	}
	
	
	//methods
	
	public int getTransactionTime() {
		
		return transactionTime;
	}
	
	public int getArrivalTime() {
		
		return numberOfArrivals;
	}
	
	public String getCustomerNumber() {
		
		return Integer.toString(numberOfArrivals);
	}
	
}

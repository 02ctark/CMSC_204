package abc;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class driver {

	public static void main(String[] args) {
		
		//create_txt_file();
		
		write_binary_file();
		
		// read_binary_file();
		read_allBytes();

	}
	
	static void read_binary_file() {
		String in_bin_file = "abcd.dat";
		boolean done = false;
		int count = 0;
		
		try (InputStream in_bin = new FileInputStream(in_bin_file)) {
			while(!done) {
				int next = in_bin.read();
				if(next == -1){
					done =  true;
				} else {
					System.out.println("next: " + next);
					count++;
				}
				
			}
			System.out.println("processed [" + count + "] records");

		} catch (IOException e) {
			System.out.println("Cannot read binary file: " + e);
		}
		System.out.println("Done - Reading Binary File");
	}
	
	
	static void read_allBytes() {
		String in_bin_file = "abcd.dat";
		
		int value;
		
		try (InputStream in_bin = new FileInputStream(in_bin_file)) {
			long fileSize = new File(in_bin_file).length();
			 
            byte[] allBytes = new byte[(int) fileSize];
 
            in_bin.read(allBytes);
 
            for (int i = 0; i < allBytes.length; i++) {
            	//System.out.println(i);
            	value = allBytes[i];
            	if (allBytes[i] < 0) {
            		value += 256;
            	} 
            	if(i >0 && i % 4 == 0) {
            		System.out.print("4 bytes: " + 
            		allBytes[i-1] + " " +
            		allBytes[i-2]+ " " +
            		allBytes[i-3]+ " " +
            		value + "\n");
            	}
            	
            	
            }
            

		} catch (IOException e) {
			System.out.println("Cannot read binary file: " + e);
		}
		System.out.println("Done - Reading Binary File");
	}
	
	
	static void create_txt_file() {
		String out_file = "abc.txt";

		try (PrintWriter out_txt = new PrintWriter(out_file)) {
			
			for(int i = 1; i <= 10000; i += 1) {
				out_txt.println(i);
			}

		} catch (IOException e) {
			System.out.println("Error processing file: " + e);
		}
		System.out.println("Text File created");
	}
	
	
	static void write_binary_file() {
		String out_bin_file = "abcd.dat";
		byte[] bytes = new byte[4];

		try (OutputStream out_bin = new FileOutputStream(out_bin_file)) {
			for(int i = 1; i <= 20000; i += 1) {
				
				for(int j =0; j<4; j++) {
					bytes[j] = (byte) (i >>> (j * 8));
				}
				out_bin.write(bytes);
				
			}
			out_bin.close();

		} catch (IOException e) {
			System.out.println("Error processing file: " + e);
		}
		
		System.out.println("Binary File created");
	}

}

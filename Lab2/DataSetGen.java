
public class DataSetGen<T extends Measurable>{

	
	private double sum;
	private T maximum;
	private int count;

	
	/**
	 *  Assigning all the constructors to 0
	 */
	public DataSetGen() {
		
		sum = 0;
		maximum = null;
		count = 0;
		
		
	}
	
	
	
	/**
	 * retrieve the average of that data type
	 * 
	 * @return sum/count
	 */

	public double getAverage() {
		// TODO Auto-generated method stub
		
		
		if (count ==0) {
			return 0;
		}else {
			
			return (sum/count);
		}
	
	}
	
	/**
	 * retrieve max value
	 * 
	 * @return maximum
	 */

	public T getMaximum() {
		// TODO Auto-generated method stub\
		
		return maximum;
	}

	
	/**
	 * adds data value to data set
	 * 
	 * @param m
	 */
	public void add(T t) {
		// TODO Auto-generated method stub
		
		sum += t.getMeasure();
		
		if(count == 0 || maximum.getMeasure() < t.getMeasure()) {
			
			maximum = t;
			
			
			
		}
		
		
		count++;
	}

}


/**
   A baseball player
*/
public class DataSetGen<T>{
	
	private double sum;
	private Measurable max;
	private int count;
	
	
	   /**
    	Constructs an empty data set.
	    */
	DataSetGen(){
		
		sum = 0;
		max = null;
		count = 0;
		
		
	}
	
	 /**
    Adds a data value to the data set.
    @param m a data value
	  */
	//to take in place holder need measurable as type 
	public void add(Measurable m) {
		
		sum += m.getMeasure();
		
		if (count == 0 || max.getMeasure() < m.getMeasure()) {
			
			max = m;
		}
		
		count++;
	}
	
	   /**
    Gets the average of the added data.
    @return the average or 0 if no data has been added
	    */
	
	public double getAverage() {
		
		
		if(count == 0) {
			return 0;
		}else {
			
			return sum/count;
		}
		
		
	}
	
	
	   /**
    Gets the largest of the added data.
    @return the maximum or 0 if no data has been added
	    */
	
	
	// to return the max of any data type the method needs to have T as type
	public T getMaximum() {
		
		// make sure to have the place holder T so keep the type consistent
		return (T) max;
		
		
	}
	
}
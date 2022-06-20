
public class main {

	public static void main(String[] args) {
		
		WaitLine wl = new WaitLine();
		
		wl.simulate(10, .75, 6);
		wl.displayResults();
		wl.reset();
		
	
	}
}

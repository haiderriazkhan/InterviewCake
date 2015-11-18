public class FunWithBits {
	
	// To add 1 to a number x we flip the rightmost 0 bit and all numbers after it (if there are any).
	public int increment(int x) {
		
		int m = 1;
		
		while ((x & m) != 0) {
			
			x = x^m;
			m <<= 1;
			
		}
		
		x = x^m;
		return x;
		
	}
	
	
	
	
}

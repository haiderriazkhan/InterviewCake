public class FunWithBits {
	
	// To add 1 to a number x we flip the rightmost 0 bit and all numbers after it (if there are any).
	public int increment(int x) {
		
		// Initialize our bit comparer to 1.
		int c = 1;
		
		// Until we hit a bit that is set to zero.
		while ((x & c) != 0) {
			
			// flip the current bit (a 1)
			x = x^c;
			// left shift by one position.
			c <<= 1;
			
		}
		
		// flip the current bit (a 0)
		x = x^c;
		return x;
		
	}
	
	public int increment_shortcut(int x) {
		
		return -(~x);
		
	}
	
	public int addition (int x , int y) {
		
		while (y != 0) {
			
			int carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}
		
		return x;
		
	}
	
	// return x - y
	// We use subtractor logic : A - B = A + (-B) = A + (~B) + 1 because ~B = -B - 1
	public int subtract (int x, int y) {
		
		while (y != 0) {
			
			int borrow = (~x) & y;
			x = x ^ y;
			y = borrow << 1;
			
		}
		
		return x;
	}
	
	
	// Compute 2^(ceil(log2(x))). Which is equivalent to finding the lowest power of two that's greater than or equal to x.
	// x will be > 0
	public int lowest_power_of_two_greater_than_or_equal_to_x (int x) {
		
		// Invalid input. Return 0.
		if (x <= 0) return 0;
		
		int result = 1;
		
		while (result < x && result != 0) {
			
			result <<= 1;
			
		}
		
		return result;
	}
	
	// Given an array, which contains integers, each number occurs exactly twice except for one, which doesn't repeat. 
	// Write a function that finds the number that doesn't repeat.
	
	public int find_single (int[] A) {
		
		int result = 0;
		
		for (int x : A) {
			
			result ^= x;
		}
		
		return result;
	}
	
}

public class Cashier {
	
	
	// Recursive solution. Exponential time complexity.
	public int count_number_of_ways(int amount, int acc, int index,  int[] denominations) {
		
		if (acc > amount) return 0;
		
		if (amount == acc) return 1;
		
		
		int len = denominations.length;
		int count = 0;
		
		while (acc < amount) {
			
		
			for (int i = index + 1; i < len; i++) {
			
				
				count += count_number_of_ways(amount, acc + denominations[i], i, denominations);
				
			
			}
			
			acc += denominations[index];
			
			if (acc > amount) return count + 0;
			
			if (acc == amount) return count + 1;
				
		}
		
		return count + 0;
		
		
	}
	
	
	// Dynamic programming solution. O(m*n)
	public int count_number_of_ways_dp(int amount, int[] denominations) {
		
		int[] number_of_ways = new int[amount+1];
		number_of_ways[0] = 1;
		
		for (int x : denominations) {
			
			for (int i = x; i <= amount;  i++ ) {
				int prev_amount = i - x;
				number_of_ways[i] += number_of_ways[prev_amount];
			}	
			
		}
		
		return number_of_ways[amount];
	}
	
	
}

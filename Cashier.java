public class cashier {
	
	
	// Recursive solution
	public int count_number_of_ways(int amount, int acc, int index,  int[] denominations) {
		
		if (acc > amount) return 0;
		
		if (amount == acc) {
			
			return 1;
			
		}
		
		
		int len = denominations.length;
		int count = 0;
		
		while (acc < amount) {
			
		
			for (int i = index + 1; i < len; i++) {
			
				
				count += count_number_of_ways(amount, acc + denominations[i], index + i, denominations);
				
			
			}
			
			acc += denominations[index];
			
			if (acc > amount) return count + 0;
			
			if (acc == amount) return count + 1;
				
		}
		
		return count + 0;
		
		
	}
	
	
}

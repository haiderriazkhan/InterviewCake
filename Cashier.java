public class cashier {
	
	private int counter;
	public final int number_of_ways_to_pay;
	
	public Cashier(int amount, int[] denominations) {
		
		counter = 0;
		
		count_number_of_ways(amount , 0 , 0,  denominations);
		
		number_of_ways_to_pay = counter;
		
	}
	
	private void count_number_of_ways(int amount, int acc, int index, int[] denominations) {
		
		if (acc > amount) return;
		
		if (amount == acc) {
			
			counter++;
			return;
			
		}
		
		
		int len = denominations.length;
		
		while (acc < amount) {
			
			
		
			for (int i = index + 1; i < len; i++) {
			
				
				count_number_of_ways(amount, acc + denominations[i], index + i, denominations);
				
			
			}
			
			acc += denominations[index];
			
			if (acc > amount) return;
			
			if (acc == amount) {
				
				counter++;	
				return;
			}
		
			
		}
		
		
	}
	
	
}

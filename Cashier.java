public class cashier {
	
	private int counter;
	public final int number_of_ways_to_pay;
	
	public cashier(int amount, int[] denominations) {
		
		counter = 0;
		
		count_number_of_ways(amount , 0 ,  denominations);
		
		number_of_ways_to_pay = counter;
		
	}
	
	private void count_number_of_ways(int amount, int acc, int[] denominations) {
		
		if (acc > amount) return;
		
		if (amount == acc) {
			
			counter++;
			return;
			
		}
		
		for (int x : denominations) {
			
			count_number_of_ways(amount, acc + x, denominations);
			
		}
		
		
	}
	
	
}

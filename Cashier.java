// Given a desired amount (integer) and a list of non zero positive denominations (integer array of non zero positive numbers).
// Determine the total number of ways to obtain the amount using only the integers in the array.
// For example:

// amount = 4 and denominations = [1,2,3,4]

// 1. 1 + 1 + 1 + 1 = 4
// 2. 1 + 1 + 2 = 4
// 3. 2 + 2 = 4
// 4. 3 + 1 = 4
// 5. 4 = 4


// This should return 5



public class Cashier {


	// Optimal Recursive Solution. O(n*m) time and O(n*m) space
	public int countNumberOfWaysRecursively (int amount, List<Integer> denominations) {

		// This variable stores the solution to subproblems of the recursive call
		Map<Map.Entry<Integer,Integer>, Integer> memory = new HashMap<>();

		// The recursive helper method returns the final solution
		return countNumberOfWaysRecursivelyHelper(amount, 0, denominations, memory);

	}

	// Private recursive helper method
	private int countNumberOfWaysRecursivelyHelper(int amountLeft, int index, List<Integer> denominations, Map<Map.Entry<Integer,Integer>, Integer> memory) {

		if (amountLeft < 0) {
			return 0;
		}

		if (amountLeft == 0) {
			return 1;
		}

		if (denominations.size() == index) {
			return 0;
		}

		Map.Entry<Integer,Integer> subProblem = new AbstractMap.SimpleEntry<Integer,Integer>(amountLeft, index);

		if (memory.containsKey(subProblem)) {

			return memory.get(subProblem);
		}


		int currentCoin = denominations.get(index);


		if (currentCoin <= 0) {
			throw new IllegalArgumentException("Coin value should be positive");
		}

		int numberOfWays = 0;

		while (amountLeft >= 0) {

			numberOfWays += countNumberOfWaysRecursivelyHelper(amountLeft, index + 1, denominations, memory);

			amountLeft -= currentCoin;

		}

		memory.put(subProblem , numberOfWays);
		return numberOfWays;

	}


	// Dynamic programming solution. O(m*n) time and O(n) space
	public int countNumberOfWaysDp(int amount, int[] denominations) {

		int[] numberOfWays = new int[amount+1];
		numberOfWays[0] = 1;

		for (int x : denominations) {

			if (x <= 0) {
				throw new IllegalArgumentException("Coin value should be positive");
			}

			for (int i = x; i <= amount;  i++ ) {
				int prevAmount = i - x;
				numberOfWays[i] += numberOfWays[prevAmount];
			}

		}

		return numberOfWays[amount];
	}


}

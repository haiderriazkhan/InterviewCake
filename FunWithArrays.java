public class FunWithArrays {

	private static final int[] EMPTY_INTEGER_ARRAY = new int[0];

	// Suppose we are given an array of n integers where the value at the ith index represents the price of a certain
	// stock on the ith day.

	// Write an efficient algorithm to determine the maximum profit a person could make with one purchase and one sale.
	// Note : You can not sell before you buy (we don't have a time machine).
	public Double maxProfit(double[] A){

		if (A == null || A.length < 2) {
			return 0;
		}
		int len = A.length;

		double min = A[0];
		double maxProfit = A[1] - min;

		if (len == 2) return maxProfit;

		for (int i=2; i < len ; i++) {

			if (A[i-1] < min) min = A[i-1];

			double potential_max_profit = A[i] - min ;

			if (potential_max_profit > maxProfit) maxProfit = potential_max_profit ;

		}

		return maxProfit;

	}

	// Product of every integer except the integer at that index. Using division is not permitted.
	public int[] prodOfAllIntsExceptAtIndex(int[] A){

		if (A == null || A.length == 0) {
			return EMPTY_INTEGER_ARRAY;
		}

		int len = A.length;

		// An empty product is by convention equal to the multiplicative identity 1
		if (len == 1) return  new int[]{1};


		int[] rightCumProdArr = new int[len-1];

		int prev = 1;

		for (int i = len-2; i >= 0; i--) {

			rightCumProdArr[i] = A[i+1]*prev;
			prev = rightCumProdArr[i];

		}

		int leftCumProd = 1;

		for(int j=0; j < len -1; j++ ) {

			int currInt = A[j];
			A[j] = leftCumProd * rightCumProdArr[j];
			leftCumProd = currInt * leftCumProd;

		}

		A[len-1] = leftCumProd;

		return A;
	}

	// Product of every integer except the integer at that index. Use Division
	public int[] prodOfAllIntsExceptAtIndexDiv(int[] A){

		if (A == null || A.length == 0) {
			return EMPTY_INTEGER_ARRAY;
		}

		int len = A.length;
		if (len == 1) return  new int[]{1};

		int tot_prod = 1;
		int num_zeros = 0;

		for (int x : A) {

			if (x == 0) {

				num_zeros ++;
				continue;
			}
			tot_prod *= x;
		}

		// For an array of type int, the default value is zero.
		if (num_zeros > 1) return new int[len];

		for (int i = 0; i < len; i++) {

			if (num_zeros == 1) {

				A[i] = (A[i] == 0) ? tot_prod : 0;
				continue;

			}

			A[i] = tot_prod/A[i];

		}

		return A;

	}


	// Equilibrium index of an array
	// Equilibrium index of an array is an index such that the sum of elements at lower indices is equal to the sum of elements at higher indices.
	public List<Integer> findEquilibrium(int[] A){

		if (A == null || A.length == 0) {
			 return Collections.<Integer>emptyList();
		}

		int len = A.length;
		// Returns a fixed-size list containing only one element : 0
		if (len == 1) return  Arrays.asList(0);

		int right_sum = 0;

		for (int x : A) right_sum += x;

		int left_sum = 0;

		List<Integer> equil_indices = new ArrayList<>();

		for (int i = 0; i < len; i++) {

			right_sum -= A[i];

			if (left_sum == right_sum) equil_indices.add(i) ;

			left_sum += A[i];

		}

		return equil_indices;

	}


	// Search text for a pattern. Rabin–Karp algorithm.
	public Integer stringMatch(String text , String pattern){

		// Base case 1
		if (text == null || pattern == null ) return -1;

		int len = text.length();
		int sublen = pattern.length();

		// Base case 2
		if (sublen > len) return -1;

		double subhash = 0 , hash = 0;
		//pre-processing
		for (int i=0; i<sublen; i++) {
			subhash = subhash*10 + pattern.charAt(i);
			hash = hash*10 +  text.charAt(i);
		}

		// Base case 3
		if (hash == subhash) return 0;

		for (int j = 0; j < len - sublen; j++ ) {

			hash = hashing(hash, sublen, text.charAt(j) , text.charAt(j + sublen));

			if(hash == subhash) return j+1;

		}

		// Pattern not found
		return -1;

	}

	// Helper method for StringMatch
	public double hashing (double value, int len, char old, char neww  ) {

		value -=  Math.pow(10, len-1) *  old  ;
		value  = value*10 +   neww ;
		return value;

	}


	// Given an array of ints A, and an int k, return two indices i and j such that A[i] + A[j] = k.
	public int[] sumIndices(int[] A, int k){

		if (A == null || A.length == 0) return new int[0];

		int len = A.length , j;

		HashMap<Integer, Integer> corrVal = new HashMap<>(len);

		for (int i = 0; i < len; i++) {

			if (A[i] > k) continue;

			if (corrVal.containsKey(A[i])) return new int[]{i , corrVal.get(A[i])};

			j = k - A[i];

			corrVal.put(j, i);

		}

		return new int[0];

	}

	// Given an array of integers, find the highest product you can get from three of the integers.
	// Input array will be at least of length 3.
	public int maxProdThree(int[] A){

		int len = A.length;

		// Base case
		if (len == 3) return A[0]*A[1]*A[2];

		int max = A[0], min = A[0], max_index = 0, min_index = 0;

		for (int i = 0; i < len; i++) {

			if (A[i] > max) {

				max = A[i];
				max_index = i;
			}
			else if (A[i] < min) {

				min = A[i];
				min_index = i;
			}
		}

		int max_sec = min, max_third = min , min_sec = max;

		for (int i = 0; i < len; i++) {

			if (i == max_index || i == min_index) continue;

			if (A[i] > max_sec) {

				max_third = max_sec;
				max_sec = A[i];
			}
			else if (A[i] > max_third) {
				max_third = A[i];
			}

			if (A[i] < min_sec) min_sec = A[i];

		}

		int prod_one = max * max_sec * max_third ;
		int prod_two = min * min_sec * max ;

		return Math.max(prod_one , prod_two) ;

	}

}

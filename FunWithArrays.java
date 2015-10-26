public class FunWithArrays{
  
  
  // Maximum profit by buying and selling a stock 
  public Double MaxProfit(double[] A){
    
    int len = A.length;
    
    if (A == null || len < 2) return null;
    
    double min = A[0];
    double max_profit = A[1] - min;
    
    if (len == 2) return max_profit;
    
    double potential_max_profit = 0;
    
    for(int i=2; i < len ; i++){
      
      if (A[i-1] < min) min = A[i-1];
      
      potential_max_profit = A[i] - min ;
      
      if (potential_max_profit > max_profit) max_profit = potential_max_profit ;
      
    }
    
    return max_profit;
    
  }
  
  // Product of every integer except the integer at that index. Using division is not permitted. 
  public int[] prod_of_all_ints_except_at_index(int[] A){
    
    int len = A.length;
    
    if (A == null || len == 0) return null;
    if (len == 1)return  new int[]{1};
  
    
    int[] right_cum_prod = new int[len-1];
    
    int prev = 1;
    
    for (int i = len-2; i >= 0; i--){
      
      intermediate[i] = A[i+1]*prev;
      prev = intermediate[i];
      
    }
    
    int left_cum_prod = 1;
    Integer curr_int = null; 
    
    for(int j=0; j < len -1; j++ ){
    
      curr_int = A[j];
      A[j] = left_cum_prod * right_cum_prod[j];
      left_cum_prod = curr_int * left_cum_prod;
      
    }
    
    A[len-1] = left_cum_prod;
    
    return A;
  }
  
  // Product of every integer except the integer at that index. Use Division
  public int[] prod_of_all_ints_except_at_index_div(int[] A){
    
    int len = A.length;
    
    if (A == null || len == 0) return null;
    if (len == 1) return  new int[]{1};
    
    int tot_prod = 1;
    int num_zeros = 0;
    
    for (int x : A){
      
      if (x == 0) {
        
        num_zero ++;
        continue;
      }
      tot_prod *= x;
    }
    
    if (num_zero > 1) return new int[len];
    
    for (int i = 0; i < len; i++){
      
      if (num_zero == 1){
        
        A[i] = (A[i] == 0) ? tot_prod : 0;
        continue;
        
      }
      
      A[i] = tot_prod/A[i];
      
    }
    
    return A;
    
  }
  
  
  // Equilibrium index of an array
  
  
}

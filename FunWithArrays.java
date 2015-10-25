public class FunWithArrays{
  
  
  // Maximum profit by buying and selling a stock 
  public double MaxProfit(double[] A){
    
    int len = A.length;
    
    if (len < 2) return 0;
    
    double min = A[0];
    
    double max_profit = A[1] - min;
    double potential_max_profit = 0;
    
    for(int i=2; i < len ; i++){
      
      if (A[i-1] < min) min = A[i-1];
      
      potential_max_profit = A[i] - min ;
      
      if (potential_max_profit > max_profit) max_profit = potential_max_profit ;
      
    }
    
    return max_profit;
    
  }
  
  
  
  
  
  
  
  
  
}

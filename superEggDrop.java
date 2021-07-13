// DP WITH EGGS AND FLOORS AS ROWS AND COLUMNS RESPECTIVELY 
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int [k+1][n+1];
        
        for(int j = 1; j < dp[0].length; j++){
            dp[1][j] = j;
        }
        
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int min = Integer.MAX_VALUE;
                for(int f = 1; f <= j; f++){
                    min = Math.min(min, 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]));
                }
                dp[i][j] = min;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
//TIME COMPLEXITY = O(n^2 * k)
//SPACE COMPLEXITY = O(kn)

---------------------------------------------------------------------------------------------------------------
// DP WITH ATTEMPTS AND EGGS AS ROWS AND COLUMNS RESPECTIVELY 
  
  class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int [n+1][k+1];
        int attempts = 0;
        
        while(dp[attempts][k] < n){
            attempts++;
            for(int j = 1; j < dp[0].length; j++){
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}

//TIME COMPLEXITY = O(nk)
//SPACE COMPLEXITY = O(nk)

package lzhang.leetcode;

public class SeventyTwo {
  public int minDistance(String word1, String word2) {
    int[][] dp=new int[word1.length()+1][word2.length()+1];
    for (int i=0; i<=word1.length(); i++){
      dp[i][0]=i;
    }
    for (int i=0; i<=word2.length(); i++){
      dp[0][i]=i;
    }
    char[] word1Spilted=word1.toCharArray();
    char[] word2Spilted=word2.toCharArray();
    for (int i=1; i<word1Spilted.length+1; i++){
      for (int j=1; j<word2Spilted.length+1; j++){
        if (word1Spilted[i-1]==word2Spilted[j-1]){
          dp[i][j]=dp[i-1][j-1];
        } else {
          dp[i][j]=1+Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
        }
      }
    }
    
    return dp[word1Spilted.length][word2Spilted.length];
  }
}

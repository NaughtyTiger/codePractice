package lzhang.leetcode;

public class SixtyFour {
  public int minPathSum(int[][] grid) {
    int colLength=grid.length;
    if (colLength==0){
      return 0;
    }
    int rowLength=grid[0].length;
    if (rowLength==0){
      return 0;
    }
    
    for (int i=0; i<colLength; i++){
      for (int j=0; j<rowLength; j++){
        if (i==0 && j==0){
          
        } else if (i==0){
          grid[0][j]+=grid[0][j-1];
        } else if (j==0){
          grid[i][0]+=grid[i-1][0];
        } else {
          grid[i][j]+=Math.min(grid[i][j-1], grid[i-1][j]);
        }
      }
    }
    return grid[colLength-1][rowLength-1];
  }
}

package lzhang.leetcode;

public class SeventyFour {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length==0 || matrix[0].length==0){
      return false;
    }
    if (matrix[0][0]>target){
      return false;
    }
    int i=1;
    for (; i<matrix.length; i++){
      if (matrix[i][0]>target){
        break;
      }
    }
    i--;
    for (int j=0; j<matrix[i].length; j++){
      if (matrix[i][j]==target){
        return true;
      }
    }
    return false;
  }
}

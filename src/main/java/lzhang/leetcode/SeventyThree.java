package lzhang.leetcode;

public class SeventyThree {
  public void setZeroes(int[][] matrix) {
    boolean clear=false;
    boolean preClear=false;
    for (int i=0; i<matrix.length; i++){
      preClear=clear;
      clear=false;
      for (int j=0; j<matrix[i].length; j++){
        if (matrix[i][j]==0){
          clear=true;
          for (int k=0; k<i; k++){
            matrix[k][j]=0;
          }
        } else if (i!=0 && matrix[i-1][j]==0){
          matrix[i][j]=0;
        }
      }
      if (preClear){
        for (int j=0; j<matrix[i-1].length; j++){
          matrix[i-1][j]=0;
        }
      }
    }
    if (clear){
      for (int j=0; j<matrix[matrix.length-1].length; j++){
        matrix[matrix.length-1][j]=0;
      }
    }
  }
}

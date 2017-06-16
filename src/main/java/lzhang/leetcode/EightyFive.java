package lzhang.leetcode;

import java.util.Stack;

public class EightyFive {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length==0 || matrix[0].length==0){
      return 0;
    }
    int[][] count=new int[matrix.length][matrix[0].length];
    for (int i=0; i<matrix.length; i++){
      for (int j=matrix[0].length-1; j>=0;j--){
        if (matrix[i][j]=='1'){
          count[i][j]=(j==matrix[0].length-1)?1:count[i][j+1]+1;
        } else {
          count[i][j]=0;
        }
      }
    }
    // O(n^2)
    int max=0;
    for (int j=0; j<matrix[0].length; j++){
      // O(n)
      Stack<Integer> s=new Stack<>();
      for (int i=0; i<=matrix.length; i++){
        int h=(i==matrix.length?0:count[i][j]); // don't know what's this
        if (s.isEmpty() || h>=count[s.peek()][j]){
          s.push(i);
        } else {
          int top=s.pop();
          max=Math.max(max, count[top][j]*(s.isEmpty()?i:i-1-s.peek()));
          i--;
        }
      }
    }
    //O(n^2)
    return max;
  }
}

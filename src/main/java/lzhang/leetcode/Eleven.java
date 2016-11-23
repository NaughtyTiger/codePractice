package lzhang.leetcode;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a 
 * point at coordinate (i, ai). n vertical lines are drawn such that the two 
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, 
 * such that the container contains the most water.
 */

public class Eleven {
  public int maxArea(int[] height) {
    boolean ifForward=false;
    int max=Math.min(height[0], height[height.length-1])*(height.length-1);
    for (int i=0, j=height.length-1;i<j;){
      ifForward=height[i]<height[j];
      if (ifForward){
        i++;
      } else {
        j--;
      }
      int newValue=Math.min(height[i], height[j])*(j-i);
      if (newValue>max){
        max=newValue;
      }
    }
    return max;
  }
}

package lzhang.leetcode;

import java.util.Stack;

public class EightyFour {
  public int largestRectangleArea(int[] heights) {
//    return method1(heights);
    return method2(heights);
  }
  
  /**
   * 遇到小的就要求先结算，时间复杂度o（n），很棒
   * @param height
   * @return
   */
  public int method2(int[] height){
    int len = height.length;
    Stack<Integer> s = new Stack<Integer>();
    int maxArea = 0;
    for(int i = 0; i <= len; i++){
      int h = (i == len ? 0 : height[i]);
      if(s.isEmpty() || h >= height[s.peek()]){
        s.push(i);
      }else{
        int tp = s.pop();
        maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
        i--;
      }
    }
    return maxArea;
  }

  /**
   * @param heights
   * @return 
   */
  public int method1(int[] heights) {
    if (heights.length==0){
      return 0;
    } else if (heights.length==1){
      return heights[0];
    }
    int startIndex=0;
    int nextStartIndex=0;
    int max=0;
    for(startIndex=0; startIndex<heights.length;){
      int height=heights[startIndex];
      for (int endIndex=startIndex+1; endIndex<=heights.length; endIndex++){
        if (endIndex==heights.length){
          int sum=(endIndex-startIndex)*height;
          if (sum>max){
            max=sum;
          }
          if (nextStartIndex==startIndex){
            return max;
          } 
        } else if (heights[endIndex]<height){
          int sum=(endIndex-startIndex)*height;
          if (sum>max){
            max=sum;
          }
          height=heights[endIndex];
        } else if (heights[endIndex]>height){
          if (nextStartIndex==startIndex){
            nextStartIndex=endIndex;
          }
        }
      }
      startIndex=nextStartIndex;
    }
    return max;
  }
}

package lzhang.leetcode;

public class FiftyThree {
  public int maxSubArray(int[] nums) {
    int count=Integer.MIN_VALUE;
    int max=Integer.MIN_VALUE;
    for (int i=0; i<nums.length; i++){
      if (count<0){
        max=Math.max(max, nums[i]);
        count=nums[i];
      } else {
        count+=nums[i];
        max=Math.max(max, count);
      }
    }
    return max;
  }
}

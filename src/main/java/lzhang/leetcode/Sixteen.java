package lzhang.leetcode;

import java.util.Arrays;

public class Sixteen {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result=0;
    int distance=Integer.MAX_VALUE;

    for (int i=0;i<nums.length-2;i++){
      if (i!=0 && nums[i-1]==nums[i]) continue;
      int low=i+1;
      int high=nums.length-1;
      while (high>low){
        int sum=nums[i]+nums[low]+nums[high];
        if (sum==target){
          return target;
        }
        if (Math.abs(target-sum)<distance){
          distance=Math.abs(target-sum);
          result=sum;
        }
        
        if (target < sum){
          while (high>0 && nums[high-1]==nums[high]){ 
            high--;
          }
          high--;
        } else {
          while (low<nums.length-1 && nums[low]==nums[low+1]){ 
            low++;
          }
          low++;
        }
      }
    }
    
    return result;
  }
}

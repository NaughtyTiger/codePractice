package lzhang.leetcode;

public class ThirtyFour {
  public int[] searchRange(int[] nums, int target) {
    int start=firstInt(nums, target);
    if (start==nums.length || nums[start]!=target){
      return new int[]{-1, -1};
    }
    return new int[]{start, firstInt(nums, target+1)-1};
  }
  private int firstInt(int[] nums, int target){
    int lo=0;
    int hi=nums.length;
    while (lo<hi){
      int mid=(lo+hi)/2;
      if (nums[mid]<target){
        lo=mid+1;
      } else {
        hi=mid;
      }
    }
    return lo;
  }
}

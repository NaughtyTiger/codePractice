package lzhang.leetcode;

public class ThirtyThree {
  public int search(int[] nums, int target) {
    int start=0;
    int end=nums.length-1;
    while (end>=start){
      int middle=(end+start)/2;
      if (nums[middle]==target){
        return middle;
      }
      if (nums[middle]>=nums[start]){
        if (nums[start]<=target && nums[middle]>target){
          end=middle-1;
        } else {
          start=middle+1;
        }
      } else {
        if (nums[middle]<target && nums[end]>=target){
          start=middle+1;
        } else {
          end=middle-1;
        }
      }
    }
    return -1;
  }
}

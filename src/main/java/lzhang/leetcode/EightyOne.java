package lzhang.leetcode;

public class EightyOne {
  public boolean search(int[] nums, int target) {
    return (search(nums, target, 0, nums.length-1));
  }
  
  private boolean search(int[] nums, int target, int begin, int end){
    if (end>=nums.length || begin<0 || end<0 || begin>=nums.length){
      return false;
    }
    while (begin<=end){
      int middle=(begin+end)/2;
      if (nums[middle]==target){
        return true;
      }
      if (nums[end]<nums[middle]){
        if (target<nums[middle] && target>=nums[begin]){
          end=middle-1;
        } else {
          begin=middle+1;
        }
      } else if (nums[end]>nums[middle]) {
        if (target>nums[middle] && target<=nums[end]){
          begin=middle+1;
        } else {
          end=middle-1;
        }
      } else {
        if (nums[begin]<nums[middle]){
          end=middle-1;
        } else {
          return search(nums, target, begin, middle-1) ||
              search(nums, target, middle+1, end);
        }
      }
    }
    return false;
  }
}

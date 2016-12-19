package lzhang.leetcode;

public class TwentySeven {
  public int removeElement(int[] nums, int val) {
    int i=0;
    int j=0;
    while (i<nums.length){
      if (nums[i++]!=val){
        nums[j++]=nums[i-1];
      }
    }
    return j;
  }
}

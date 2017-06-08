package lzhang.leetcode;

public class SeventyFive {
  public void sortColors(int[] nums) {
    int firstNonZero=-1;
    int lastNonTwo=nums.length-1;
    for (int i=0; i<nums.length;){
      if (nums[i]==0){
        if (firstNonZero==-1){
          i++;
          continue;
        }
        nums[i]=nums[firstNonZero];
        nums[firstNonZero++]=0;
        if (i<firstNonZero){
          break;
        }
      } else if (nums[i]==1){
        if (firstNonZero==-1){
          firstNonZero=i;
        }
        i++;
      } else if (nums[i]==2){
        if (i>=lastNonTwo){
          break;
        }
        nums[i]=nums[lastNonTwo];
        nums[lastNonTwo--]=2;
      }
    }
  }
}

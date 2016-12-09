package lzhang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Eighteen {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result=new LinkedList<>();
    int end=nums.length-1;
    while (end>=3){
      for (int i=0;i<end-2;i++){
        int low=i+1;
        int high=end-1;
        while (high>low){
          int sum=nums[i]+nums[low]+nums[high]+nums[end];
          if (target==sum){
            List<Integer> tmp=new LinkedList<>();
            tmp.add(nums[i]);
            tmp.add(nums[low]);
            tmp.add(nums[high]);
            tmp.add(nums[end]);
            result.add(tmp);
            while (low!=end-1 && nums[low+1]==nums[low]){
              low++;
            }
            low++;
            
            while (high>i+1 && nums[high-1]==nums[high]){
              high--;
            }
            high--;
          } else if (sum>target){
            while (high>i+1 && nums[high-1]==nums[high]){
              high--;
            }
            high--;
          } else {
            while (low!=end-1 && nums[low+1]==nums[low]){
              low++;
            }
            low++;
          }
          while (i<end-3 && nums[i+1]==nums[i]){
            i++;
          }
        }
      }
      while (end>3 && nums[end-1]==nums[end]){
        end--;
      }
      end--;
    }
    return result; //TODO
  }
}

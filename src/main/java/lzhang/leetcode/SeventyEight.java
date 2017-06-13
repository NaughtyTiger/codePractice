package lzhang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SeventyEight {
  public List<List<Integer>> subsets(int[] nums) {
    return method1(nums);
  }
  
  private List<List<Integer>> method1(int[] nums){
    if (nums.length==0){
      List<List<Integer>> result=new LinkedList<>();

      List<Integer> tmp=new LinkedList<>();
      result.add(tmp);
      return result;
    } else if (nums.length==1){
      List<List<Integer>> result=new LinkedList<>();

      List<Integer> tmp=new LinkedList<>();
      result.add(tmp);
      List<Integer> tmp1=new LinkedList<>();
      tmp1.add(nums[0]);
      result.add(tmp1);
      return result;
    } else {
      List<List<Integer>> result=new LinkedList<>();
      int lastOne=nums[nums.length-1];
      int[] newNums=Arrays.copyOfRange(nums, 0, nums.length-1);
      for (List<Integer> tmp:method1(newNums)){
        result.add(tmp);
        List<Integer> newTmp=new LinkedList<>();
        newTmp.addAll(tmp);
        newTmp.add(lastOne);
        result.add(newTmp);
      }
      return result;
    }
  }
}

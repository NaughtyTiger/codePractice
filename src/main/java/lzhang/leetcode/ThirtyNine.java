package lzhang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThirtyNine {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    return getCombinationSum(candidates, 0, target);
  }
  
  private List<List<Integer>> getCombinationSum(int[] candidates, int index, int target){
    List<List<Integer>> result=new LinkedList<>();
    if (index==candidates.length){
      return result;
    }

    if (target%candidates[index]==0){
      List<Integer> tmp=new LinkedList<>();
      for (int i=0; i<target/candidates[index]; i++){
        tmp.add(candidates[index]);
      }
      result.add(tmp);
    }

    for (int i=0; i<target/candidates[index]; i++){
      for (List<Integer> tmp:getCombinationSum(candidates, index+1, 
          target-i*candidates[index])){
        for (int j=0; j<i; j++){ 
          tmp.add(candidates[index]);
        }
        result.add(tmp);
      }
    }
    return result;
  }
}

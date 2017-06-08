package lzhang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SeventySeven {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result=new LinkedList<>();
    if (k==1){
      for (int i=1; i<=n; i++){
        List<Integer> tmp=new LinkedList<>();
        tmp.add(i);
        result.add(tmp);
      }
      return result;
    } else if (n==k){
      List<Integer> tmp=new LinkedList<>();
      for (int i=1; i<=n; i++){
        tmp.add(i);
      }
      result.add(tmp);
      return result;
    } else {
      for (List<Integer> tmp:combine(n-1,k-1)){
        tmp.add(n);
        result.add(tmp);
      }
      result.addAll(combine(n-1, k));
      return result;
    }
  }
}

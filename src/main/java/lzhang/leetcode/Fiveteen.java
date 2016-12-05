package lzhang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Fiveteen {
  public List<List<Integer>> threeSum(int[] num) {
//    return method1(num);
    
    Arrays.sort(num);
    
    List<List<Integer>> found = new ArrayList<>();
    
    int pneg = 0 , ppos = num.length - 1;
    
    while(ppos > 0 && num[ppos] >= 0){
        
        while(pneg < ppos && num[pneg] <= 0){
            
            int sum = num[pneg] + num[ppos];

            for(int i  = pneg + 1; i < ppos; i++){
                if(num[i] + sum == 0){
                    found.add(Arrays.asList(new Integer[]{num[pneg], num[i] ,num[ppos]}));
                    
                    break;
                }
            }
            
            int old = num[pneg];
            while(pneg < ppos && num[pneg] == old) pneg++;                
        }
        
        pneg = 0;
        
        int old = num[ppos];
        while(ppos > 0 && num[ppos] == old) ppos--;
    }
    
    return found;
  }

  /**
   * @param nums
   * @return 
   */
  List<List<Integer>> method1(int[] nums) {
    List<List<Integer>> result=new LinkedList<>(); 
    HashMap<Integer, List<Integer>> map=new HashMap<>();
    for (int i=0; i<nums.length; i++){
      if (!map.containsKey(nums[i])){
        LinkedList<Integer> tmp=new LinkedList<>();
        tmp.add(i);
        map.put(nums[i], tmp);
      } else {
        map.get(nums[i]).add(i);
      }
    }
    
    /*
     * three nums are zero
     */
    if (map.containsKey(0) && map.get(0).size()>=3){
      result.add(Arrays.asList(0, 0, 0));
    }
    
    ArrayList<Integer> keys=new ArrayList<>(new TreeSet<Integer>(map.keySet()));

    /*
     * two nums are equals
     */
    
    for (int i=0; i<keys.size(); i++){
      if (keys.get(i)!=0 && map.containsKey(-2*keys.get(i)) 
          && map.get(keys.get(i)).size()>=2){
        if (keys.get(i)>0){
          result.add(Arrays.asList(-2*keys.get(i), keys.get(i), keys.get(i)));
        } else {
          result.add(Arrays.asList(keys.get(i), keys.get(i), -2*keys.get(i)));
        }
      }
    }
    
    for (int i=0; i<keys.size(); i++){
      for (int j=i+1; j<keys.size(); j++){
        int target=-(keys.get(i)+keys.get(j));
        if (target<=keys.get(j)){
          break;
        } else if (map.containsKey(target)){
          result.add(Arrays.asList(keys.get(i), keys.get(j), target));
        }
      }
    }
    
    return result;
  }
}

package lzhang.leetcode;

import java.util.HashMap;

public class SeventySix {
  public String minWindow(String s, String t) {
    if (t.length()==0 || s.length()==0){
      return "";
    }
    HashMap<Character, Integer> required=new HashMap<>();
    int count=t.length();
    for (int i=0; i<count; i++){
      char cha=t.charAt(i);
      if (required.containsKey(cha)){
        required.put(cha, required.get(cha)+1);
      } else {
        required.put(cha, 1);
      }
    }
    
    int minLen=Integer.MAX_VALUE;
    int minIndex=-1;
    int i=0;
    int j=-1;
    
    while (i<s.length() && j<s.length()){
      if (count>0){
        j++;
        if (j==s.length()){
          break;
        }
        char cha=s.charAt(j);
        if (required.containsKey(cha)){
          required.put(cha, required.get(cha)-1);
          if (required.get(cha)>=0){
            count--;
          }
        }
      } else {
        if (j-i+1<minLen){
          minLen=j-i+1;
          minIndex=i;
        }
        char cha=s.charAt(i);
        if (required.containsKey(cha)){
          required.put(cha, required.get(cha)+1);
          if (required.get(cha)>0){
            count++;
          }
        }
        i++;
      }
    }
    if (minLen==Integer.MAX_VALUE){
      return "";
    }
    return s.substring(minIndex, minIndex+minLen);
  }
}

package lzhang.leetcode;

public class Fourteen {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length==0){
      return "";
    } else if (strs.length==1){
      return strs[0];
    }
    int i=0;
    for (;i<strs[0].length();i++){
      for (int j=1; j<strs.length; j++){
        if (strs[j].length()==i || strs[j].charAt(i)!=strs[0].charAt(i)){
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }
}

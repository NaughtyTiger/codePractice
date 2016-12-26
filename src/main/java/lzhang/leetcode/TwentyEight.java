package lzhang.leetcode;

public class TwentyEight {
  public int strStr(String haystack, String needle){
	char original[]=haystack.toCharArray();
    char target[]=needle.toCharArray();
    
    if (original.length==0 || target.length==0){
      if (target.length==0 ){
        return 0;
      }
      return -1;
    }
    
    int next[]=new int[target.length];
    int i=0;
    next[0]=-1;
    int j=-1;
    while (i<target.length-1){
      if(j==-1 || target[i]==target[j]){
        i++;
        j++;
        if (target[i]!=target[j]){
          next[i]=j;
        } else {
          next[i]=next[j];
        }
      } else {
        j=next[j];
      }
    }
    
    int nowAt=0;
    int targetAt=0;
    while (nowAt<original.length && targetAt<target.length){
      if (targetAt==-1 || original[nowAt]==target[targetAt]){
        nowAt++;
        targetAt++;
      } else {
        targetAt=next[targetAt];
      }
    }
    if (targetAt<target.length){
      return -1;
    } else {
      return nowAt-target.length;
    }
  }
}

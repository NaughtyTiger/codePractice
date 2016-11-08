package lzhang.leetcode;

import java.util.HashMap;

/*
 * Given a string, find the length of the longest substring without repeating characters.

  Examples:

  Given "abcabcbb", the answer is "abc", which the length is 3.

  Given "bbbbb", the answer is "b", with the length of 1.

  Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

  Subscribe to see which companies asked this question

 */
public class Three {
  public int lengthOfLongestSubstring(String s) {
    byte[] chars=s.getBytes();
    HashMap<Byte,Integer> map=new HashMap<>();
    int i=0,j=i;
    int max=0;
    while (j<chars.length){
      if (!map.containsKey(chars[j])){
        map.put(chars[j], j);
      } else {
        if (map.size()>max){
          max=map.size();
        }
        int newI=map.get(chars[j])+1;
        for (int ii=i;ii<newI;ii++){
          map.remove(chars[ii]);
        }
        i=newI;
        map.put(chars[j], j);
      }
      j++;
    }
    if (map.size()>max){
      max=map.size();
    }
    return max;//TODO
  }
}

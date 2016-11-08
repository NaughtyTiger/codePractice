package lzhang.leetcode;
/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

public class Five {
  public String longestPalindrome(String s) {
    return mySecondWay(s);
  }
  
  private String findPalindrome(String s, int left, int right){
    int n=s.length();
    while (left>=0 && right<=n-1 && s.charAt(left)==s.charAt(right)){
      left--;
      right++;
    }
    return s.substring(left+1,right);
  }
  
  private String cppWayOne(String s){
    int n=s.length();
    if (n<=1) return s;
    String longest="";
    String tmp;
    for (int i=0;i<n-1;i++){
      tmp=findPalindrome(s,i,i);
      if (tmp.length()>longest.length()){
        longest=tmp;
      }
      tmp=findPalindrome(s,i,i+1);
      if (tmp.length()>longest.length()){
        longest=tmp;
      }
    }
    return longest;
  }

  public String myFirstWay(String s) {
    int start=0;
    int end=0;
    int max=end-start+1;
    int length=s.length();
    for (int i=0;i<length-1;i++){
      for (int j=1;;j++){
        try {
          if (s.charAt(i-j)==s.charAt(i+j)){
            continue;
          } else {
            if (2*j-1>max){
              start=i-j+1;
              end=i+j-1;
              max=2*j-1;
            }
            break;
          }
        } catch (StringIndexOutOfBoundsException e){
          if (2*j-1>max){
            start=i-j+1;
            end=i+j-1;
            max=2*j-1;
          }
          break;
        }
      }

      if (s.charAt(i)==s.charAt(i+1)){
        for (int j=1;;j++){
          try {
            if (s.charAt(i-j)==s.charAt(i+j+1)){
              continue;
            } else {
              if (2*j>max){
                start=i-j+1;
                end=i+j;
                max=2*j;
              }
              break;
            }
          } catch (StringIndexOutOfBoundsException e){
            if (2*j>max){
              start=i-j+1;
              end=i+j;
              max=2*j;
            }
            break;
          }
        }
      }
    }
    return s.substring(start, end+1);
  }
  
  public String mySecondWay(String s){
    int start=0;
    int end=0;
    int max=end-start+1;
    int length=s.length();
    for (int i=0;i<length-1;i++){
      for (int j=1;;j++){
          if (i-j>=0 && i+j<length && s.charAt(i-j)==s.charAt(i+j)){
            continue;
          } else {
            if (2*j-1>max){
              start=i-j+1;
              end=i+j-1;
              max=2*j-1;
            }
            break;
          }
      }

      if (s.charAt(i)==s.charAt(i+1)){
        for (int j=1;;j++){
          if (i-j>=0 && i+j+1<length && s.charAt(i-j)==s.charAt(i+j+1)){
            continue;
          } else {
            if (2*j>max){
              start=i-j+1;
              end=i+j;
              max=2*j;
            }
            break;
          }
        }
      }
    }
    return s.substring(start, end+1);
  }
}

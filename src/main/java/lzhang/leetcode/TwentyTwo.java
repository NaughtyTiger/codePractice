package lzhang.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
   Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

   For example, given n = 3, a solution set is:

  [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
  ]

 */
public class TwentyTwo {
  List<String> result=new LinkedList<>();
  public List<String> generateParenthesis(int n) {
    StringBuffer tmp=new StringBuffer();
    generateTmpString(n,n,tmp);
    return result;
  }
  
  private void generateTmpString(int left, int right, StringBuffer tmpResult){
    if (left==0 && right==0){
      result.add(tmpResult.toString());
    }
    if (left>0){
      generateTmpString(left-1, right, new StringBuffer(tmpResult).append("("));
    } 
    if (right>0 && right>left){
      generateTmpString(left, right-1, new StringBuffer(tmpResult).append(")"));
    }
    return;
  }

  /**
   * @param n
   * @return 
   */
  List<String> method1(int n) {
    if (n==0)return new LinkedList<String>();
    if (n==1)return Arrays.asList(new String[]{"()"});
    
    HashSet<String> tmp=new HashSet<String>();
    
    for (String s: generateParenthesis(n-1)){
      tmp.add("("+s+")");
      tmp.add("()"+s);
      tmp.add(s+"()");
    }
    
    for (int i=2;i<n-1;i++){
      for (String s:generateParenthesis(n-i)){
        for (String ss:generateParenthesis(i)){
          tmp.add(ss+s);
          tmp.add(s+ss);
        }
      }
    }
    return new LinkedList<String>(tmp);
  }
}

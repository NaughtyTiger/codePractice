package lzhang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FortyNine {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result=new LinkedList<>();
    if (strs.length==0){
      return result;
    }
    
    LetterTree head=new LetterTree();
    
    for (String str: strs){
      char charInStr[]=str.toCharArray();
      Arrays.sort(charInStr);
      LetterTree p=head;
      for (int i=0; i<charInStr.length; i++){
        if (p.children[charInStr[i]-'a']==null){
          p.children[charInStr[i]-'a']=new LetterTree();
          p.chars.add(charInStr[i]-'a');
        } 
        p=p.children[charInStr[i]-'a'];
      }
      if (p.strs==null){
        p.strs=new LinkedList<>();
      }
      p.strs.add(str);
    }
    
    addStrings(head,result);
    
    return result;
  }
  
  private void addStrings(LetterTree src, List<List<String>> result){
    if (src.strs!=null){
      result.add(src.strs);
    }
    for (Integer index:src.chars){
      addStrings(src.children[index], result);
    }
  }
  
  private class LetterTree{
    public LetterTree[] children=new LetterTree[26];
    public List<Integer> chars=new LinkedList<>();
    public List<String> strs;
    
    @Override
    public String toString(){
      StringBuilder result=new StringBuilder();
      result.append("[\n");
      for (Integer index:chars){
        result.append(('a'+index)+":"+children[index].toString());
      }
      result.append("]\n");
      return result.toString();
    }
  }
}

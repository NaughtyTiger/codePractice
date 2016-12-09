package lzhang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Seventeen {
  public List<String> letterCombinations(String digits) {
    List<String> preResult=new LinkedList<>();
    if (digits.length()==0){
      return preResult;
    }
    preResult.add("");
    for (int i=0;i<digits.length();i++){
      switch(digits.charAt(i)){
      case '2':preResult=addChar(preResult, new char[]{'a', 'b', 'c'});
      break;
      case '3':preResult=addChar(preResult, new char[]{'d', 'e', 'f'});
      break;
      case '4':preResult=addChar(preResult, new char[]{'g', 'h', 'i'});
      break;
      case '5':preResult=addChar(preResult, new char[]{'j', 'k', 'l'});
      break;
      case '6':preResult=addChar(preResult, new char[]{'m', 'n', 'o'});
      break;
      case '7':preResult=addChar(preResult, new char[]{'p', 'q', 'r', 's'});
      break;
      case '8':preResult=addChar(preResult, new char[]{'t', 'u', 'v'});
      break;
      case '9':preResult=addChar(preResult, new char[]{'w', 'x', 'y', 'z'});
      break;
      }
    }
    return preResult;
  }
  
  private List<String> addChar(List<String> oldList, char[] newChars){
    List<String> newList=new LinkedList<>();
    for (char newChar:newChars){
      for (String line: oldList){
        newList.add(line+newChar);
      }
    }
    return newList;
  }
}

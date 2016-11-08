package lzhang.leetcode;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
 * rows like this: (you may want to display this pattern in a fixed font 
 * for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 *And then read line by line: "PAHNAPLSIIGYIR"
 */
public class Six {
  @SuppressWarnings("unchecked")
  public String convert(String s, int numRows) {
    if (numRows>=s.length() || numRows==1){
      return s;
    }
    Queue<Character> tmp=new LinkedList<>();
    Queue<Character>[] data=
        (Queue<Character>[]) Array.newInstance(tmp.getClass(), numRows);
//    for (Queue<Character> init:data){
//      init=new LinkedList<>();
//    }
    for (int i=0;i<numRows;i++){
      data[i]=new LinkedList<Character>();
    }
    boolean down=true;
    int row=0;
    for (int i=0;i<s.length();i++){
      data[row].add(s.charAt(i));
      if (down){
        if (row==numRows-1){
          down=false;
          row--;
        } else {
          row++;
        }
      } else {
        if (row==0){
          down=true;
          row++;
        } else { 
          row--;
        }
      }
    }
    String result="";
    for (int i=0;i<numRows;i++){
      while (!data[i].isEmpty()){
        result+=data[i].poll();
      }
    }
    return result;
  }
}

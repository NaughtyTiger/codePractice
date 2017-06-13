package lzhang.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class SeventyNine {
  /* The method with average time 
   * (my method share the same time complexity and bigger time constant
   * public class Solution {
public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y=0; y<board.length; y++) {
        for (int x=0; x<board[y].length; x++) {
            if (exist(board, y, x, w, 0)) return true;
        }
    }
    return false;
}

private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    if (i == word.length) return true;
    if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    if (board[y][x] != word[i]) return false;
    board[y][x] ^= 255;
    boolean exist = exist(board, y, x+1, word, i+1)
        || exist(board, y, x-1, word, i+1)
        || exist(board, y+1, x, word, i+1)
        || exist(board, y-1, x, word, i+1);
    board[y][x] ^= 255;
    return exist;
}
}
   */
  
  
  private class LinkedMap {
    LinkedList<LinkedMap> neighbor;
    char content;
    boolean used;
    
    @Override
    public String toString(){
      return new Character(content).toString();
    }
    
    LinkedList<LinkedMap> hasNext(char nextContext){
      LinkedList<LinkedMap> result=new LinkedList<>();
      for (LinkedMap tmp:neighbor){
        if (tmp.content==nextContext && tmp.used==false){
          result.add(tmp);
        }
      }
      return result;
    }
  }
  
  public boolean exist(char[][] board, String word) {
    if (word.length()==0){
      return true;
    }
    if (board.length==0 || board[0].length==0){
      return false;
    }
    HashMap<Character, LinkedList<LinkedMap>> charMapping=new HashMap<>();
    LinkedMap[][] linkedMapTable=new LinkedMap[board.length][board[0].length];
    for (int i=0; i<board.length; i++){
      for (int j=0; j<board[0].length; j++){
        LinkedMap tmp=new LinkedMap();
        tmp.content=board[i][j];
        tmp.used=false;
        tmp.neighbor=new LinkedList<>();
        if (i!=0){
          tmp.neighbor.add(linkedMapTable[i-1][j]);
          linkedMapTable[i-1][j].neighbor.add(tmp);
        }
        if (j!=0){
          tmp.neighbor.add(linkedMapTable[i][j-1]);
          linkedMapTable[i][j-1].neighbor.add(tmp);
        }
        linkedMapTable[i][j]=tmp;
        if (charMapping.containsKey(board[i][j])){
          charMapping.get(board[i][j]).add(tmp);
        } else {
          LinkedList<LinkedMap> tmpLindedList=new LinkedList<>();
          tmpLindedList.add(tmp);
          charMapping.put(board[i][j], tmpLindedList);
        }
      }
    }
//    System.out.println(charMapping);
    
    LinkedList<LinkedMap> options;
    if (charMapping.containsKey(word.charAt(0))){
      options=charMapping.get(word.charAt(0));
    } else {
      return false;
    }
    return traverse(options, word, 1);
  }
  
  private boolean traverse(LinkedList<LinkedMap> options, String word, int nextIndex){
    if (nextIndex==word.length()){
      return options.size()!=0;
    }
    for (LinkedMap option:options){
      option.used=true;
      if (traverse(option.hasNext(word.charAt(nextIndex)), word, nextIndex+1)){
        return true;
      }
      option.used=false;
    }
    return false;
  }
}

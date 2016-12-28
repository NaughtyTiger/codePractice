package lzhang.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 */
public class Thirty {
  public List<Integer> findSubstring(String s, String[] words) {
    return method2(s, words);
  }
  
  private List<Integer> method2(String s, String[] words){
    if (words.length==0){
      return new LinkedList<Integer>();
    }
    List<Integer> result=new LinkedList<Integer>();
    int wordLength=words[0].length();
    
    HashMap<String, Integer> wordsNeeded=new HashMap<>();
    for (String word:words){
      if (wordsNeeded.containsKey(word)){
        wordsNeeded.put(word, wordsNeeded.get(word)+1);
      } else {
        wordsNeeded.put(word, 1);
      }
    }
    
    for (int index=0; index<wordLength; index++){
      HashMap<String, Integer>wordGot=new HashMap<>();
      int leftI=0;
      int count=0;
      for (int i=0; (i+1)*wordLength+index<=s.length(); i++){
        String currentWord=s.substring(i*wordLength+index, 
            (i+1)*wordLength+index);
        if (!wordsNeeded.containsKey(currentWord)){
          wordGot.clear();
          count=0;
          leftI=i+1;
        } else {
          if (wordGot.containsKey(currentWord)){
            wordGot.put(currentWord, wordGot.get(currentWord)+1);
          } else {
            wordGot.put(currentWord, 1);
          }
          count++;

          if (wordGot.get(currentWord)>wordsNeeded.get(currentWord)){
//            System.out.println("too many: "+currentWord);
            for (int j=leftI;;j++){
              String tmpString=s.substring(j*wordLength+index, 
                  (j+1)*wordLength+index);
              if (tmpString.equals(currentWord)){
                wordGot.put(currentWord, wordGot.get(currentWord)-1);
                leftI=j+1;
                count--;
                break;
              } else {
//                System.out.println("remove: "+tmpString);
                wordGot.put(tmpString, wordGot.get(tmpString)-1);
                count--;
              }
            }
          }
          
          if (count==words.length){
            result.add(leftI*wordLength+index);
          }
        }
      }
    }
    
    return result;
  }

  /*
   * time over, i think this is close enough
   */
  @SuppressWarnings("unused")
  private List<Integer> method1(String s, String[] words) {
    if (words.length==0){
      return new LinkedList<Integer>();
    }
    List<Integer> result=new LinkedList<Integer>();
    int wordLength=words[0].length();
    if (wordLength==0){
      for (int i=0; i<s.length(); i++){
        result.add(i);
      }
      return result;
    }
    HashMap<String, Integer> wordsNeeded=new HashMap<>();
    for (String word:words){
      if (wordsNeeded.containsKey(word)){
        wordsNeeded.put(word, wordsNeeded.get(word)+1);
      } else {
        wordsNeeded.put(word, 1);
      }
    }
    
    for (int index=0;index<wordLength;index++){
      HashMap<String, Queue<Integer>>wordToLocate=new HashMap<>();
      HashMap<Integer, String>locateToWord=new HashMap<>();
      for (int i=0;(i+1)*wordLength+index<=s.length();i++){
        String tmpString=s.substring(i*wordLength+index, (i+1)*wordLength+index);
        if (wordsNeeded.containsKey(tmpString)){
          // get word that we need
          if (wordsNeeded.get(tmpString)==1){
            wordsNeeded.remove(tmpString);
            if (wordsNeeded.size()==0){
              result.add((i-words.length+1)*wordLength+index);
            }
            if (!wordToLocate.containsKey(tmpString)){
              Queue<Integer> tmp=new LinkedList<Integer>();
              tmp.add(i);
              wordToLocate.put(tmpString, tmp);
              locateToWord.put(i, tmpString);
            } else {
              Queue<Integer> tmp=wordToLocate.get(tmpString);
              tmp.add(i);
              wordToLocate.put(tmpString, tmp);
              locateToWord.put(i, tmpString);
            }
          } else {
            wordsNeeded.put(tmpString, wordsNeeded.get(tmpString)-1);
            if (!wordToLocate.containsKey(tmpString)){
              Queue<Integer> tmp=new LinkedList<Integer>();
              tmp.add(i);
              wordToLocate.put(tmpString, tmp);
              locateToWord.put(i, tmpString);
            } else {
              Queue<Integer> tmp=wordToLocate.get(tmpString);
              tmp.add(i);
              wordToLocate.put(tmpString, tmp);
              locateToWord.put(i, tmpString);
            }
          }
        } else {
          // get word that we don't need
          if (!wordToLocate.containsKey(tmpString)){
            // word we don't need at all
            wordsNeeded.clear();
            for (String word:words){
              if (wordsNeeded.containsKey(word)){
                wordsNeeded.put(word, wordsNeeded.get(word)+1);
              } else {
                wordsNeeded.put(word, 1);
              }
            }
            
            wordToLocate.clear();
            locateToWord.clear();
          } else {
            // roll back!
//            int removeIndex=wordToLocate.get(tmpString).poll();
//            if (wordToLocate.get(tmpString).size()==0){
//              wordToLocate.remove(tmpString);
//            }
            for (int j=wordToLocate.get(tmpString).peek();;j--){
              if (!locateToWord.containsKey(j)){
                break;
              }
              String removeWord=locateToWord.get(j);
              locateToWord.remove(j);
              if (wordsNeeded.containsKey(removeWord)){
                wordsNeeded.put(removeWord, wordsNeeded.get(removeWord)+1);
              } else {
                wordsNeeded.put(removeWord, 1);
              }
              if (wordToLocate.get(removeWord).size()==1){
                wordToLocate.remove(removeWord);
              } else {
                wordToLocate.get(removeWord).poll();
              }
            }
            if (wordsNeeded.get(tmpString)==1){
              wordsNeeded.remove(tmpString);
              if (wordsNeeded.size()==0){
                result.add((i-words.length+1)*wordLength+index);
              }
              if (!wordToLocate.containsKey(tmpString)){
                Queue<Integer> tmp=new LinkedList<Integer>();
                tmp.add(i);
                wordToLocate.put(tmpString, tmp);
                locateToWord.put(i, tmpString);
              } else {
                Queue<Integer> tmp=wordToLocate.get(tmpString);
                tmp.add(i);
                wordToLocate.put(tmpString, tmp);
                locateToWord.put(i, tmpString);
              }
            } else {
              wordsNeeded.put(tmpString, wordsNeeded.get(tmpString)-1);
              if (!wordToLocate.containsKey(tmpString)){
                Queue<Integer> tmp=new LinkedList<Integer>();
                tmp.add(i);
                wordToLocate.put(tmpString, tmp);
                locateToWord.put(i, tmpString);
              } else {
                Queue<Integer> tmp=wordToLocate.get(tmpString);
                tmp.add(i);
                wordToLocate.put(tmpString, tmp);
                locateToWord.put(i, tmpString);
              }
            }
          }
        }
      }
      wordsNeeded.clear();
      for (String word:words){
        if (wordsNeeded.containsKey(word)){
          wordsNeeded.put(word, wordsNeeded.get(word)+1);
        } else {
          wordsNeeded.put(word, 1);
        }
      }
      
      wordToLocate.clear();
      locateToWord.clear();
    }
    
    return result;
  }
}

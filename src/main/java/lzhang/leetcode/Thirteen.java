package lzhang.leetcode;

public class Thirteen {
  public int romanToInt(String s){
    int result=0;
    for (int i=0; i<s.length(); i++){
      switch(s.charAt(i)){
      case 'M':
        result+=1000;
        break;
      case 'C':
        if (i!=s.length()-1){
          if (s.charAt(i+1)=='M'){
            result+=900;
            i++;
            continue;
          } else if (s.charAt(i+1)=='D'){
            result+=400;
            i++;
            continue;
          }
        }
        result+=100;
        break;
      case 'D':
        result+=500;
        break;
      case 'X':
        if (i!=s.length()-1){
          if (s.charAt(i+1)=='C'){
            result+=90;
            i++;
            continue;
          } else if (s.charAt(i+1)=='L'){
            result+=40;
            i++;
            continue;
          }
        }
        result+=10;
        break;
      case 'L':
        result+=50;
        break;
      case 'I':
        if (i<s.length()-1){
          if (s.charAt(i+1)=='X'){
            result+=9;
            i++;
            continue;
          } else if (s.charAt(i+1)=='V'){
            result+=4;
            i++;
            continue;
          }
        }
        result+=1;
        break;
      case 'V':
        result+=5;
        break;
      }
    }
    return result;
  }
}

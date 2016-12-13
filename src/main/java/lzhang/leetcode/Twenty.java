package lzhang.leetcode;

import java.util.Stack;

public class Twenty {
  public boolean isValid(String s) {
    Stack<Character> stack=new Stack<>();
    for (int i=0; i<s.length(); i++){
      switch(s.charAt(i)){
      case '(':
        stack.add('(');
        break;
      case '[':
        stack.add('[');
        break;
      case '{':
        stack.add('{');
        break;
      case ')':
        if (stack.isEmpty() || stack.pop()!='('){
          return false;
        }
        break;
      case ']':
        if (stack.isEmpty() || stack.pop()!='['){
          return false;
        }
        break;
      case '}':
        if (stack.isEmpty() || stack.pop()!='{'){
          return false;
        }
        break;
        default:
          break;
      }
    }
    return stack.isEmpty();
  }
}

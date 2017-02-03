package lzhang.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SeventyOne {
  public String simplifyPath(String path) {
    String[] spilt=path.split("/");
    Deque<String> tmpStack=new LinkedList<>();
    for (int i=1; i<spilt.length; i++){
      if (spilt[i].equals(".") || spilt[i].equals("")){
        // do nothing
      } else if (spilt[i].equals("..")){
        if (!tmpStack.isEmpty()){
          tmpStack.pop();
        }
      } else {
        tmpStack.push(spilt[i]);
      }
    }
    if (tmpStack.isEmpty()){
      return "/";
    }
    StringBuilder result=new StringBuilder();
    for (String tmpItem:tmpStack){
      result.insert(0, "/"+tmpItem);
    }
    return result.toString();
  }
  
  public static void main(String[] args){
    SeventyOne inst=new SeventyOne();
    System.out.println(inst.simplifyPath("/a/./b/../../c/"));
    System.out.println(inst.simplifyPath("///"));
  }
}

package lzhang.leetcode;

import org.junit.Test;

public class FortyNineTest {
  @Test
  public void test(){
    FortyNine inst=new FortyNine();
    System.out.println(inst.groupAnagrams(new String[]{"eat", "tea", "tan", 
        "ate", "nat", "bat"}));
    System.out.println(inst.groupAnagrams(new String[]{"b",""}));
  }
}
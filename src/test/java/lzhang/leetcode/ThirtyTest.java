package lzhang.leetcode;

import org.junit.Test;

public class ThirtyTest {
  @Test
  public void test(){
    Thirty inst=new Thirty();
    System.out.println(inst.findSubstring("barfoothefoobarman",
        new String[]{"foo", "bar", "the"}));
    System.out.println(inst.findSubstring("aba",
        new String[]{"a", "b"}));
    System.out.println(inst.findSubstring("wordgoodgoodgoodbestword" ,
        new String[]{"word","good","best","good"}));
    System.out.println(inst.findSubstring("aaa" ,
        new String[]{"aa","aa"}));
  }
}

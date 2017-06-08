package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SeventySixTest {
  @Test
  public void test(){
    SeventySix inst=new SeventySix(); 
    assertEquals(inst.minWindow("ADOBECODEBANC", "ABC"), "BANC");
    assertEquals(inst.minWindow("ADOBECODEBANC", "ABCD"), "ADOBEC");
    assertEquals(inst.minWindow("ADOBECODEBANC", "ABCDZ"), "");
    assertEquals(inst.minWindow("ADOBECODEBANC", "AA"), "ADOBECODEBA");
    assertEquals(inst.minWindow("ZAAAB", "ZAAB"), "ZAAAB");
    assertEquals(inst.minWindow("ADOBECODEBANC", ""), "");
    assertEquals(inst.minWindow("", "AD"), "");
  }
}

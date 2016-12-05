package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FourteenTest {
  @Test
  public void test(){
    Fourteen inst=new Fourteen();
    assertEquals("abc", inst.longestCommonPrefix(new String[]{
        "abcd","abcde","abced"
    }));
    assertEquals("abc", inst.longestCommonPrefix(new String[]{
        "abcd","abc","abced"
    }));
    assertEquals("abc", inst.longestCommonPrefix(new String[]{
        "abc","abcff","abcff"
    }));
    assertEquals("", inst.longestCommonPrefix(new String[]{
        
    }));
  }
}

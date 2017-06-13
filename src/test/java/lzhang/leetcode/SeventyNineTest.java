package lzhang.leetcode;

import org.junit.Test;

public class SeventyNineTest {
  @Test
  public void test(){
    char[][] data={{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
    System.out.println(new SeventyNine().exist(data, "ABCD"));
    System.out.println(new SeventyNine().exist(data, "ABCCED"));
    System.out.println(new SeventyNine().exist(data, "SEE"));
  }

}

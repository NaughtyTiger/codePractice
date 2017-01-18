package lzhang.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FiftySixTest {
  @Test
  public void test(){
    FiftySix inst=new FiftySix();
    List<Interval> data=new LinkedList<>();
    System.out.println(inst.merge(data));
    data.add(new Interval(1, 4));
    data.add(new Interval(0, 0));
//    data.add(new Interval(8,15));
//    data.add(new Interval(15,18));
    System.out.println(inst.merge(data));
    data.add(new Interval(0, 1));
    System.out.println(inst.merge(data));
    data.add(new Interval(8, 15));
    data.add(new Interval(16, 18));
    data.add(new Interval(5, 7));
    data.add(new Interval(18, 19));
    data.add(new Interval(31, 33));
    data.add(new Interval(20, 23));
    System.out.println(inst.merge(data));
    data=new LinkedList<>();
    data.add(new Interval(2, 3));
    data.add(new Interval(5, 5));
    data.add(new Interval(2, 2));
    data.add(new Interval(3, 4));
    data.add(new Interval(3, 4));
    System.out.println(inst.merge(data));
    data=new LinkedList<>();
    data.add(new Interval(2, 3));
    data.add(new Interval(4, 6));
    data.add(new Interval(5, 7));
    data.add(new Interval(3, 4));
    System.out.println(inst.merge(data));
  }
}

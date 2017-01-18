package lzhang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FiftySix {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result=new LinkedList<>();
    if (intervals.size()==0){
      return result;
    }
    result.add(intervals.get(0));
    for (int i=1; i<intervals.size(); i++){
      Interval tmpInterval=intervals.get(i);
      int startIndex=getIndex(tmpInterval.start, result);
      int endIndex=getIndex(tmpInterval.end, result);
      
      if (startIndex==endIndex){
        if (startIndex==result.size()){
          if (result.get(startIndex-1).end>=tmpInterval.start){
            result.get(startIndex-1).end=
                Math.max(tmpInterval.end, result.get(startIndex-1).end);
          } else { 
            result.add(startIndex, tmpInterval);
          }
        } else if (startIndex==0){
          result.add(0, tmpInterval);
        } else {
          if (result.get(startIndex-1).end<tmpInterval.start){
            if (result.get(startIndex).start>tmpInterval.end){
              result.add(startIndex, tmpInterval);
            } else {
              result.get(startIndex).start=tmpInterval.start;
            }
          } else {
            if (result.get(startIndex).start>tmpInterval.end){
              result.get(startIndex-1).end=
                  Math.max(tmpInterval.end, result.get(startIndex-1).end);
            } else {
              result.get(startIndex-1).end=result.get(startIndex).end;
              result.remove(startIndex);
            }
          }
        }
      } else {
        for (int j=0; j<endIndex-startIndex-1; j++){
          result.remove(startIndex);
        }
        if (startIndex==0){
          result.get(startIndex).start=tmpInterval.start;
          result.get(startIndex).end=
              Math.max(tmpInterval.end, result.get(startIndex).end);
        } else {
          if (result.get(startIndex-1).end<tmpInterval.start){
            tmpInterval.end=Math.max(tmpInterval.end, result.get(startIndex).end);
            result.remove(startIndex);
            result.add(startIndex, tmpInterval);
          } else {
            result.get(startIndex-1).end=
                Math.max(tmpInterval.end, result.get(startIndex).end);
            result.remove(startIndex);
          }
        }
      }
    }
    return result;
  }
  
  /**
   * 
   * @param number
   * @param data size()>0
   * @return 0-data.size()
   */
  private int getIndex(int number, List<Interval> data){
    if (number<data.get(0).start){
      return 0;
    } else if (number>=data.get(data.size()-1).start){
      return data.size();
    } else {
      for (int start=1, end=data.size()-1; start<=end;){
        int middle=(start+end)/2;
        if (number>=data.get(middle-1).start && number<data.get(middle).start){
          return middle;
        } else if (number>=data.get(middle).start){
          start=middle+1;
        } else {
          end=middle-1;
        }
      }
    }
    return -1;
  }
}

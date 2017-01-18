package lzhang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FiftyOne {
  public List<List<String>> solveNQueens(int n) {
    int[][] map=new int[n][n];
    int[] location=new int[n];
    List<List<String>> result=new LinkedList<>();
    placeQueens(0, map, location, result);
    return result;
  }
  
  private void placeQueens(int line, int[][] map, int[] location, 
      List<List<String>> result){
    for (int i=0; i<map.length; i++){
      if(map[line][i]==0){
        if (line==map.length-1){
          location[line]=i;
          List<String> singleResult=new LinkedList<>();
          for (int j=0; j<map.length; j++){
            StringBuffer lineResult=new StringBuffer();
            for (int before=0; before<location[j]; before++){
              lineResult.append('.');
            }
            lineResult.append('Q');
            for (int after=0; after<map.length-location[j]-1; after++){
              lineResult.append('.');
            }
            singleResult.add(lineResult.toString());
          }
          result.add(singleResult);
        } else {
          location[line]=i;
          for (int j=0; j<map.length; j++){
            map[j][i]=map[j][i]+1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine--, tmpCol--){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]+1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine++, tmpCol++){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]+1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine--, tmpCol++){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]+1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine++, tmpCol--){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]+1;
          }

          map[line][i]=1;
          
          placeQueens(line+1, map, location, result);
          for (int j=0; j<map.length; j++){
            map[j][i]=map[j][i]-1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine--, tmpCol--){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]-1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine++, tmpCol++){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]-1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine--, tmpCol++){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]-1;
          }

          for (int tmpLine=line, tmpCol=i;
              tmpLine<map.length && tmpLine>=0 && tmpCol<map.length && tmpCol>=0;
              tmpLine++, tmpCol--){
            map[tmpLine][tmpCol]=map[tmpLine][tmpCol]-1;
          }

          map[line][i]=0;
        }
      }
    }
  }
}

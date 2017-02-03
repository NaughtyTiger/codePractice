package lzhang.leetcode;

public class SixtySeven {
  public String addBinary(String a, String b) {
    if (a==null || a.isEmpty()){
      return b;
    }
    if (b==null || b.isEmpty()){
      return a;
    }
    char[] aArray=a.toCharArray();
    char[] bArray=b.toCharArray();
    StringBuilder stb=new StringBuilder();
    
    int i=aArray.length-1;
    int j=bArray.length-1;
    
    boolean carry=false;
    boolean aByte;
    boolean bByte;

    while (i>-1 || j>-1 || carry){
      aByte=(i>-1)?(aArray[i--]=='1'):false;
      bByte=(j>-1)?(bArray[j--]=='1'):false;
      boolean number=aByte^bByte^carry;
      carry=(aByte && bByte) || (aByte && carry) || (bByte && carry);
      stb.append(number?1:0);
    }
    
    return stb.reverse().toString();
  }
}

package lzhang.leetcode;

public class FortyThree {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")){
      return "0";
    }
    int[] result=new int[num1.length()+num2.length()];
    for (int i=num1.length()-1; i>=0; i--){
      for (int j=num2.length()-1; j>=0; j--){
        int tmp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        result[num1.length()+num2.length()-i-j-2]+=tmp;
      }
    }
    StringBuilder sb=new StringBuilder();
    for (int i=0; i<result.length-1; i++){
      result[i+1]+=result[i]/10;
      result[i]=result[i]%10;
    }
    if (result[result.length-1]!=0){
      sb.append(result[result.length-1]);
    }
    for (int i=result.length-2; i>=0; i--){
      sb.append(result[i]);
    }
    return sb.toString();
  }
}

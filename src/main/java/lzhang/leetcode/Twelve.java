package lzhang.leetcode;

public class Twelve {
  public String intToRoman(int num) {
    return method1(num);
  }
  
  @SuppressWarnings("unused")
  private String method3(int num){
    String symbol[] =   {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
    int value[]     =   {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1}; 
    String result="";

    for(int i=0; num!=0; i++){
        while(num >= value[i]){
            num -= value[i];
            result+=symbol[i];
        }
    }

    return result;
  }
  
  @SuppressWarnings("unused")
  private String method2(int num){
    String result="";
    int single=num%10;
    num=num/10;
    
    switch(single){
    case 0:
      break;
    case 1:
      result="I";
      break;
    case 2:
      result="II";
      break;
    case 3:
      result="III";
      break;
    case 4:
      result="IV";
      break;
    case 5:
      result="V";
      break;
    case 6:
      result="VI";
      break;
    case 7:
      result="VII";
      break;
    case 8:
      result="VIII";
      break;
    case 9:
      result="IX";
      break;
    }
    if(num==0)return result;
    int ten=num%10;
    num=num/10;

    switch(ten){
    case 0:
      break;
    case 1:
      result="X"+result;
      break;
    case 2:
      result="XX"+result;
      break;
    case 3:
      result="XXX"+result;
      break;
    case 4:
      result="XL"+result;
      break;
    case 5:
      result="L"+result;
      break;
    case 6:
      result="LX"+result;
      break;
    case 7:
      result="LXX"+result;
      break;
    case 8:
      result="LXXX"+result;
      break;
    case 9:
      result="XC"+result;
      break;
    }
    if(num==0)return result;
    int hundred=num%10;
    num=num/10;
    switch(hundred){
    case 0:
      break;
    case 1:
      result="C"+result;
      break;
    case 2:
      result="CC"+result;
      break;
    case 3:
      result="CCC"+result;
      break;
    case 4:
      result="CD"+result;
      break;
    case 5:
      result="D"+result;
      break;
    case 6:
      result="DC"+result;
      break;
    case 7:
      result="DCC"+result;
      break;
    case 8:
      result="DCCC"+result;
      break;
    case 9:
      result="CM"+result;
      break;
    } 
    for (int i=0; i<num; i++){
      result="M"+result;
    }
    
    return result;
  }

  private String method1(int num) {
    String result="";
    int thousand=num/1000;
    num=num-thousand*1000;
    for (int i=0; i<thousand; i++){
      result+="M";
    }
    
    int hundred=num/100;
    num=num-hundred*100;
    switch(hundred){
    case 0:
      break;
    case 1:
      result+="C";
      break;
    case 2:
      result+="CC";
      break;
    case 3:
      result+="CCC";
      break;
    case 4:
      result+="CD";
      break;
    case 5:
      result+="D";
      break;
    case 6:
      result+="DC";
      break;
    case 7:
      result+="DCC";
      break;
    case 8:
      result+="DCCC";
      break;
    case 9:
      result+="CM";
      break;
    }
    
    int ten=num/10;
    num=num-ten*10;
    
    switch(ten){
    case 0:
      break;
    case 1:
      result+="X";
      break;
    case 2:
      result+="XX";
      break;
    case 3:
      result+="XXX";
      break;
    case 4:
      result+="XL";
      break;
    case 5:
      result+="L";
      break;
    case 6:
      result+="LX";
      break;
    case 7:
      result+="LXX";
      break;
    case 8:
      result+="LXXX";
      break;
    case 9:
      result+="XC";
      break;
    }
    
    switch(num){
    case 0:
      break;
    case 1:
      result+="I";
      break;
    case 2:
      result+="II";
      break;
    case 3:
      result+="III";
      break;
    case 4:
      result+="IV";
      break;
    case 5:
      result+="V";
      break;
    case 6:
      result+="VI";
      break;
    case 7:
      result+="VII";
      break;
    case 8:
      result+="VIII";
      break;
    case 9:
      result+="IX";
      break;
    }
    
    return result;
  }
}

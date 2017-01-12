package lzhang.leetcode;

public class FortyFour {
  public boolean isMatch(String s, String p) {
    return methodDP(s, p);
  }
  
  private boolean methodDP(String s, String p){
      boolean[][] match=new boolean[s.length()+1][p.length()+1];
      match[s.length()][p.length()]=true;
      for(int i=p.length()-1;i>=0;i--){
          if(p.charAt(i)!='*')
              break;
          else
              match[s.length()][i]=true;
      }
      for(int i=s.length()-1;i>=0;i--){
          for(int j=p.length()-1;j>=0;j--){
              if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                      match[i][j]=match[i+1][j+1];
              else if(p.charAt(j)=='*')
                      match[i][j]=match[i+1][j]||match[i][j+1];
              else
                  match[i][j]=false;
          }
      }
      return match[0][0];
  }

  /**
   * @param s
   * @param p
   * @return 
   */
  @SuppressWarnings("unused")
  private boolean methodGreedy(String s, String p) {
    if (p.equals("*")){
      return true;
    }
    if (s.equals("")){
      if (!p.equals("") && p.charAt(0)!='*'){
        return false;
      } else if (p.equals("")){
        return true;
      }
    }
    if (p.equals("")){
      return false;
    }
    
    char nowAt=p.charAt(0);
    switch(nowAt){
    case '?':
      return isMatch(s.substring(1), p.substring(1));
    case '*':
      for (int i=0; i<=s.length(); i++){
        if (isMatch(s.substring(i), p.substring(1))){
          return true;
        }
      }
      return false;
    default:
      if (nowAt==s.charAt(0)){
        return isMatch(s.substring(1), p.substring(1));
      } else {
        return false;
      }
    }
  }
}

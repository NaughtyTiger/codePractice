package lzhang.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
 * http://blog.csdn.net/yukuninfoaxiom/article/details/6057736
 */
public class Ten {
  private State end;
  public boolean isMatch(String s, String p) {
//    return method1(s, p);
//    return method2(s, p);
    return dpMethod(s,p);
  }
  
  public boolean dpMethod(String s, String p){
    if (s.length()==0 && p.length()==0){
      return true;
    } 
    if (p.startsWith("*")) {
      return false;
    }
    boolean dp[][]=new boolean[s.length()+1][p.length()+1];
    dp[0][0]=true;
    for (int j=2; j<p.length()+1;j+=2){
      dp[0][j]=dp[0][j-2] && p.charAt(j-1)=='*';
    }
    for (int i=1; i<s.length()+1; i++){
      for (int j=1; j<p.length()+1; j++){
        if (p.charAt(j-1)=='*'){
          dp[i][j]= dp[i][j-2] || (((s.charAt(i-1)==p.charAt(j-2)) || p.charAt(j-2)=='.') && dp[i-1][j]);
        } else {
          dp[i][j]=dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
        }
      }
    }
    return dp[s.length()][p.length()];
  }
  
  
  

  private void method2(String s, String p) {
    State startState=new State();
    end=createStates(startState, p);
    checkState(startState, 0, s);
  }
  
  public State createStates(State startState, String p){
    State nowAt=startState;
    for (int i=0; i<p.length(); i++){
      if (i+1<p.length() && p.charAt(i+1)=='*'){
        State loop=new State();
        State none=new State();
        
        nowAt.addNext(null, none);
        nowAt.addNext(null, loop);
        
        loop.addNext(p.charAt(i), loop);
        loop.addNext(p.charAt(i), none);
        nowAt=none;
        i++;
      } else {
        State newOne=new State();
        nowAt.addNext(p.charAt(i), newOne);
        nowAt=newOne;
      }
    }
    return nowAt;
  }
  
  public boolean checkState(State state, int index, String s){
    if (index==s.length()){
      if (state==end){
        return true;
      }
    }
    for (Path path:state.map){
      if (path.trigger==null){
        if (checkState(path.node, index, s)){
          return true;
        }
      } else if (index<s.length() && path.trigger=='.'){
        if (checkState(path.node, index+1, s)){
          return true;
        }
      } else {
        if (index<s.length() && path.trigger==s.charAt(index) && checkState(path.node, index+1, s)){
          return true;
        }
      }
    }
    return false;
  }
  
  class State {
    LinkedList<Path> map=new LinkedList<>();
    
    public void addNext(Character c, State nexState){
      map.add(new Path(c, nexState));
    }
    
  } 
  
  class Path {
    Character trigger;
    State node;
    Path(Character trigger, State node){
      this.trigger=trigger;
      this.node=node;
    }
  }
  
  private boolean method1(String s, String p) {
    if (p.equals("") && s.equals("")){
      return true;
    }
    if (p.equals("") && !s.equals("")){
      return false;
    } 
    if (s.equals("") && !p.equals("")){
      if (p.length() <=1 || p.charAt(1)!='*'){
        return false;
      }
    }
    if (p.startsWith(".")){
      if (p.startsWith(".*")){
        for (int i=0;i<=s.length();i++){
          if(isMatch(s.substring(i), p.substring(2))){
            return true;
          }
        }
        return false;
      } else {
        return isMatch(s.substring(1), p.substring(1));
      }
    } else if (p.length()>=2 && p.charAt(1)=='*'){
      int i=0;
      for (i=0;i<=s.length();i++){
        if (isMatch(s.substring(i), p.substring(2))){
          return true;
        }
        if (i==s.length() || s.charAt(i)!=p.charAt(0)){
          break;
        }
      }
      return false;
    } else if (p.charAt(0)==s.charAt(0)){
      return isMatch(s.substring(1), p.substring(1));
    } else {
      return false;
    }
  }
}


/*
class Solution {
    static final Character EPSILON = 0;

    static class State{

        static Set<Character> allchar = new HashSet<Character>();

        boolean end;

        Map<Character, Set<State>> next = new HashMap<Character, Set<State>>();

        State(){
            this(false);
        }

        State(boolean end){
            this.end = end;
        }

        State match(Character c) {
            Set<State> states = next.get(c);

            if(states == null){
                states = next.get('.');
            }

            if(states != null) {
                for (State s : states) {
                    return s;
                }
            }

            return null;
        }

        Set<State> matchAll(Character c) {
            Set<State> match = next.get(c);

            return match;
        }

        void addNext(Character c, State s){

            if(c != EPSILON)
                allchar.add(c);

            Set<State> l = next.get(c);

            if(l == null){
                l = new HashSet<State>();
                next.put(c, l);
            }

            l.add(s);
        }
    }

    State nfa(char[] pattern){

        final State end = new State(true);

        State last = end;

        for(int i = pattern.length - 1; i >= 0; i--){
            if(pattern[i] == '*'){
                i--;

                State s1 = new State();
                State s2 = new State();
                State s3 = new State();
                State s4 = last;

                s1.addNext(EPSILON, s2);
                s1.addNext(EPSILON, s4);

                s2.addNext(pattern[i], s3);

                s3.addNext(EPSILON, s4);

                s4.addNext(EPSILON, s2);

                last = s1;

            }else{
                State curr = new State();
                curr.addNext(pattern[i], last);
                last = curr;
            }
        }


        return last;
    }

    boolean end(Set<State> states){
        for (State state : states) {
            if(state.end){
                return true;
            }
        }
        return false;
    }

    State dfa(State start){

        Map<Set<State>, HashMap<Character, Set<State>>> table = new HashMap<Set<State>, HashMap<Character, Set<State>>>();
        Map<Set<State>, State> toone = new HashMap<Set<State>, State>();

        final Set<State> enter = allEpslilon(Collections.singleton(start));

        LinkedList<Set<State>> queue = new LinkedList<Set<State>>();
        queue.add(enter);

        while(!queue.isEmpty()){

            Set<State> key = queue.poll();

            if(!toone.containsKey(key)){
                State maps = new State();
                maps.end = end(key);

                toone.put(key, maps);
            }

            HashMap<Character, Set<State>> targets = searchTarget(key);
            table.put(key, targets);

            for (Set<State> states : targets.values()) {
                if(table.get(states) == null){
                    queue.add(states);
                }
            }

        }

        for (Map.Entry<Set<State>, HashMap<Character, Set<State>>> entry : table.entrySet()) {
            State s = toone.get(entry.getKey());

            for (Map.Entry<Character, Set<State>> t : entry.getValue().entrySet()) {
                s.addNext(t.getKey(), toone.get(t.getValue()));
            }

        }

        return toone.get(enter);
    }

    HashMap<Character, Set<State>> searchTarget(Set<State> form) {
        HashMap<Character, Set<State>> targets = new HashMap<Character, Set<State>>();

        for(State s : form) {
            for (Character c : State.allchar) {
                Set<State> ns = s.matchAll(c);

                if (ns == null) continue;

                Set<State> states = allEpslilon(ns);
                
                Set<State> t = targets.get(c);
                if(t == null){
                    t = new HashSet<State>();
                    targets.put(c, t);
                }

                t.addAll(states);           
                
            }
        }

        return targets;
    }

    Set<State> allEpslilon(Set<State> ns) {
        Set<State> states = new HashSet<State>();
        states.addAll(ns);


        int oldsize = 0;


        while (states.size() != oldsize) {

            oldsize = states.size();

            Set<State> temp = new HashSet<State>();

            for (State target : states) {
                Set<State> t = target.matchAll(EPSILON);
                if (t != null) temp.addAll(t);
            }

            states.addAll(temp);

        }
        return states;
    }

    boolean isMatch(char[] s, State state, int p){

        if(state == null){
            return false;
        }

        if(p >= s.length){
            return state.end;
        }

        for (Map.Entry<Character, Set<State>> entry : state.next.entrySet()) {

            Character key = entry.getKey();
            if(key.equals(s[p]) || key.equals('.')){
                if(isMatch(s, entry.getValue().iterator().next(), p + 1)){
                    return true;
                }
            }
        }

        return false;
    }    

    public boolean isMatch(String s, String p) {

        State.allchar = new HashSet<Character>();

        State state = nfa(p.toCharArray());
        state = dfa(state);

        char[] chars = s.toCharArray();

        return isMatch(chars, state, 0);
    }
}
*/
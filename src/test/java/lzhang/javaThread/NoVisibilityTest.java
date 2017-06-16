package lzhang.javaThread;

import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.MethodRule;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class NoVisibilityTest {
  private static boolean ready=false;
  private static int number=0;
  
  
  @Before
  public void start(){
  }
  
  @After
  public void after(){
  }
  
  @Rule
  public MethodRule rule=new RepeatableRule(5,new String[]{"main"});
  
  @Rule
  public TemporaryFolder folder=new TemporaryFolder();
  
//  @Rule
  public ExpectedException exception=ExpectedException.none();
  
  public ErrorCollector collector=new ErrorCollector();

  @Test
  public void main(){
    System.out.println(folder.getRoot().getAbsolutePath());
    try {
      System.out.println(folder.newFile().getAbsolutePath());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    ready=false;
    number=0;
    new ReaderThread().start();
    number=42;
    ready=true;
  }
  
  public static class ReaderThread extends Thread {
    public void run(){
      while (!ready){
        Thread.yield();
      }
//      if (number!=42){ 
        System.out.println(number);
//      }
    }
  }
  
  private class RepeatableRule implements MethodRule {
    int times=1;
    String[] testMethods=null;
    
    RepeatableRule(int times, String[] testMethods){
      this.times=times;
      this.testMethods=testMethods;
    }

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
      return new Statement(){
        @Override
        public void evaluate() throws Throwable {
          System.out.print("Start");
          System.out.print(folder.getRoot().getAbsolutePath());
          int loopTime=1;
          if (Arrays.asList(testMethods).contains(method.getName())){
            loopTime=times;
          }
          for (int i=0; i<loopTime; i++){
            base.evaluate();
          }
        }
      };
    }
    
  }
}

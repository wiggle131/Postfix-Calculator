import java.util.*;
import java.util.StringTokenizer;

public class Post{
  public String op;
  private double ans;
  private boolean cntrl = true;
  private Stack<Double> elements = new Stack<>();

public Post(String op){
    this.op = op;
    this.ans = 0;
  }

public void start(){
  try{
  StringTokenizer st = new StringTokenizer(op);
  double num;
  String temp;
  while(st.hasMoreTokens()){
    temp = st.nextToken();
    if(isNumber(temp)){
      num = Double.parseDouble(temp);
      elements.push(num);
    }
    else if(isOprtr(temp)){
        if(!elements.empty()){
          compute(temp);
        }
    }
    else{
      System.out.println("ERROR INVALID SYMBOL");
        cntrl = false;
    }
    }
      ans = elements.pop();
      if(!elements.isEmpty())
        System.out.println("MISSING OPERATOR");
      else if(cntrl && elements.isEmpty()){
        display();
      }
    }
    catch(EmptyStackException e){System.out.println("MISSING OPERAND");}
}
public void display(){
    System.out.println("Answer = "+ans);
}
public boolean isNumber(String str){
    boolean flag = true;
        try {
            Double num = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
}
private void compute(String temp){
  double ans,op1,op2;
  op2 = elements.pop();
  op1 = elements.pop();
  switch(temp){
    case "+" : ans = op1 + op2; elements.push(ans); break;
    case "-" : ans = op1 - op2; elements.push(ans); break;
    case "/" : ans = op1 / op2; elements.push(ans); break;
    case "*" : ans = op1 * op2; elements.push(ans); break;
    }
}
  public Boolean isOprtr(String oprtr){
    boolean flag = false;
    if(oprtr.equals("+") || oprtr.equals("-")|| oprtr.equals("/")||oprtr.equals("*"))
        flag = true;
    return flag;
  }
}

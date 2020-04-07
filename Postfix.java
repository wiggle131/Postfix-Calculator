import java.util.*;

public class Postfix{
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    String operation;
    System.out.println("Input (with spaces after each operand/operator) :");
        operation = a.nextLine();
    Post op = new Post(operation);
        op.start();
  }
}

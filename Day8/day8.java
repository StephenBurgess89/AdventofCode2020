import java.util.*;
import java.io.*;

class Day8 {
  public static void main(String[] args) throws FileNotFoundException {
    
    String[] bootCode = new String[646];
    readInput(bootCode);

    System.out.println("Answer One = "+answerOne(bootCode));

    System.out.println("\nAnswer Two = "+answerTwo(bootCode));
  }


  public static int answerTwo(String[] bootCode) {
    int acc = 0;
    int loop = 0;
    int count = 0;
    boolean changed = false;
    ArrayList<Integer> visited = new ArrayList<Integer>();

    for(int i = 0; i < bootCode.length;) {
      
      if(visited.contains(i)){
        i = 0;
        acc = 0;
        visited.clear();
        loop++;
        count = 0;
        changed = false;          
      }

      visited.add(i);
      String [] ops = bootCode[i].split(" ");
      String operation = ops[0];
      ops = ops[1].split("",2);

      if (operation.equals("nop")) {
        count++;
        if(loop == count && changed == false) {
          operation = "jmp";
          changed = true;         
        }
        else {
          i++;
          continue;
        }
      }
      if (operation.equals("jmp")) {
        count++;
        if(loop == count && changed == false) {
          changed = true;
          i++;
          continue;  
        }
        else { 
          if(ops[0].equals("+")) {
            i += Integer.parseInt(ops[1]);
          }
          else {
            i -= Integer.parseInt(ops[1]);
          }
        }
      }
      else {
        if(ops[0].equals("+")) {
          acc += Integer.parseInt(ops[1]);
        }
        else {
          acc -= Integer.parseInt(ops[1]);
        }
        i++;
      }
    }
    return acc;
  }

  public static int answerOne(String[] bootCode) {
    int acc = 0;
    ArrayList<Integer> visited = new ArrayList<Integer>();

    for(int i = 0; i < bootCode.length;) {

      if(visited.contains(i)){
        return acc;
      }

      visited.add(i);
      String [] ops = bootCode[i].split(" ");
      String operation = ops[0];
      ops = ops[1].split("",2);

      if (operation.equals("nop")) {
        i++;
        continue;
      }
      else if (operation.equals("jmp")) {
        if(ops[0].equals("+")) {
          i += Integer.parseInt(ops[1]);
        }
        else {
          i -= Integer.parseInt(ops[1]);
        }
      }
      else {
        if(ops[0].equals("+")) {
          acc += Integer.parseInt(ops[1]);
        }
        else {
          acc -= Integer.parseInt(ops[1]);
        }
        i++;
      }
    }
    return acc;
  }

  public static void readInput(String[] bootCode) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("input.txt"));
    int i = 0;
    while(scan.hasNextLine()){
      bootCode[i++] = scan.nextLine();
    }
    scan.close();
  }
}

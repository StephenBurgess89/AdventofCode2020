import java.util.*;
import java.io.*;

class Day7 {

  public static void main(String args[]) throws FileNotFoundException {  
	    String[] instructions = new String[594];
      readInput(instructions);
      ArrayList<String> bagList = new ArrayList<String>(); 
      String myBag = "shiny gold bag";

      //System.out.println(answerOne(instructions, myBag, bagList));

      System.out.println(answerTwo(instructions, myBag));
  }
  
  public static int answerOne(String[] instructions, String myBag, ArrayList<String> bagList) {  
    int count = 0;
    for(String s : instructions) {
      String[] bags = s.split("contain");
      String outerBag = bags[0].substring(0,bags[0].length()-2);
      if(bags[1].contains(myBag) && !bagList.contains(outerBag)) {
       count++;
       count += answerOne(instructions, outerBag, bagList);
      }
      else {
        bagList.add(myBag);
      } 
    }
    return count;
  }

  public static int answerTwo(String[] instructions, String myBag) {
    int count = 0;
    for(String s : instructions) {
      String[] bags = s.split("contain");
      String outerBag = bags[0].substring(0,bags[0].length()-2);
      bags = bags[1].split(",",-1);
      if(outerBag.contains(myBag)){
        for(String bag : bags){
          String[] temp = bag.trim().split(" ",2);
          if(temp[0].equals("no")){
            continue;
          }
          int i =Integer.parseInt(temp[0]);
          String newBag = temp[1].substring(0,temp[1].length()-2); 
          count += (i + i*answerTwo(instructions, newBag));
        }   
      }
    }
    return count;
  }

  public static void readInput(String[] instructions) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("input.txt"));
    int i = 0;
    while(scan.hasNextLine()){
      instructions[i++] = scan.nextLine();
    }
    scan.close();
  }
}
import java.util.*;
import java.io.*;

class Day2 {

  public static void main(String args[]) throws FileNotFoundException {  
	  String [] passwords = new String[1000];

    readInput(passwords);

    System.out.println("Valid passwords (One): "+answerOne(passwords));
    System.out.println("\nValid passwords (Two): "+answerTwo(passwords));    
  }
  
  public static int answerOne(String[] passwords) {
      int count = 0;
      for(String s : passwords) {

        String[] data = s.split(":");

        String key = data[0];
        String password = data[1].trim();
        
        data = key.split(" ");
        int lower = getLower(data[0]);
        int upper = getUpper(data[0]);

        String letter = data[1];

        String[] letters = password.split("");
        int matches = 0;
        for(String l : letters) {
          if(l.equals(letter)){
            matches++;
          }
        }
        if(matches <= upper && matches >= lower){
          count++;
        }
      }
      return count;
  }

  public static int answerTwo(String[] passwords) {
      int count = 0;
      for(String s : passwords) {

        String[] data = s.split(":");

        String key = data[0];
        String password = data[1].trim();
        
        data = key.split(" ");
        int lower = getLower(data[0]);
        int upper = getUpper(data[0]);

        String letter = data[1];

        String[] letters = password.split("");
        if( letters[lower-1].equals(letter) ^ letters[upper-1].equals(letter)){
          count ++;
        }      
      }
      return count;
  }

  public static int getLower(String s) {
    String[] strA = s.split("-");
    return Integer.parseInt(strA[0]);
  }

  public static int getUpper(String s) {
    String[] strA = s.split("-");
    return Integer.parseInt(strA[1]);
  }

  public static void readInput(String[] passwords) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("input.txt"));
    int i = 0;
    while(scan.hasNextLine()){
      passwords[i++] = scan.nextLine();
    }
  }
}
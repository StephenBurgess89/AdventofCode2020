import java.util.*;
import java.io.*;

class Main {

  public static void main(String args[]) throws FileNotFoundException { 
  
	  int [] expenses = new int[200];

    readInput(expenses);

    System.out.println("Answer one = "+answerOne(expenses)+"\n");

    System.out.println("Answer two = "+answerTwo(expenses));
    
  }
  
  public static int answerOne(int[] expenses) {
      int[] nums = expenses.clone();
      Arrays.sort(nums);
      int n1 = 0;
      int n2 = nums.length-1;
      while(true) {
        int sum = nums[n1] + nums[n2]; 
        if(sum > 2020){
          n2--;
        }
        else if (sum < 2020) {
          n1++;
        }
        else {
          System.out.println(nums[n1]+" + "+nums[n2]+" = "+sum);
          return nums[n1]*nums[n2];
        }
      }
  }

  public static int answerTwo(int[] expenses) {
    int[] nums = expenses.clone();
      Arrays.sort(nums);
      int n1 = 0;
      int n2 = 1;
      int n3 = nums.length-1;
      while(true) {
        if(n2 == n3) {
          n1++;
          n2 = n1+1;
          n3 = nums.length-1;    
        } 
        int sum = nums[n1] + nums[n2] + nums[n3];
        if(sum > 2020){
          n3--;
        }
        else if (sum < 2020) {
          n2++;
        }
        else {
          System.out.println(nums[n1]+" + "+nums[n2]+" + "+nums[n3]+" = "+sum);
          return nums[n1]*nums[n2]*nums[n3];
        }
      }
  }

  public static void readInput(int[] expenses) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("input.txt"));
    int i = 0;
    while(scan.hasNextInt()){
      expenses[i++] = scan.nextInt();
    }
  }
}

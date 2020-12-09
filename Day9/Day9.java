import java.util.*;
import java.io.*;

class Day9 {
  public static void main(String[] args) throws FileNotFoundException {
    Long[] numbers = new Long[1000];
    int preLength = 25;
    readInput(numbers);

    long target = (answerOne(numbers, preLength));
    System.out.println("Answer One = "+target);
    
    System.out.println("\nAnswer Two = "+answerTwo(numbers, target)); 
  }

  public static Long answerOne(Long[] numbers, int preLength) {
    ArrayList<Long> preamble = new ArrayList<Long>();
    for(int i = 0; i < preLength; i++) {
      preamble.add(numbers[i]);
    }

    for(int i = preLength; i < numbers.length; i++) { 
      long current = numbers[i];
      if(getValid(preamble, current)) {
       preamble.remove(0);
       preamble.add(current); 
      }
      else {
       return current;
      }   
    }
    return 0L;
  }

  public static Long answerTwo(Long[] numbers, long target) {
    for(int i = 0; i < numbers.length; i++) {
      long sum = numbers[i];
      for(int j = i+1; j < numbers.length; j++) {
        sum += numbers[j];
        if(sum < target){
          continue;
        }
        if(sum > target) {
          break;
        }
        if(sum == target) {
          return getWeakness(i, j, numbers);
        }
      }
    }
    return 0L;
  }

  public static boolean getValid(ArrayList<Long> preamble, long current) {
    for(int i = 0; i < preamble.size()-1; i++) {
      for(int j = i+1; j < preamble.size(); j++) {
        long sum = preamble.get(i) + preamble.get(j);
        if(sum == current) {        
          return true;
        }
      }
    }
    return false;
  }

  public static long getWeakness(int start, int finish, Long[] numbers) {
    long min = numbers[start];
    long max = min;
    for (int i = start; i < finish; i++) {
      if(numbers[i] < min) {
        min = numbers[i];
      }
      if(numbers[i] > max) {
        max = numbers[i];
      }
    }
    return min + max;
  }

  public static void readInput(Long[] numbers) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("input.txt"));
    int i = 0;
    while(scan.hasNextLine()){
      numbers[i++] = Long.parseLong(scan.nextLine());
    }
    scan.close();
  }
}
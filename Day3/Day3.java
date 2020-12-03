import java.util.*;
import java.io.*;
import java.awt.Point;

class Day3 {

  public static void main(String args[]) throws FileNotFoundException {  
	  String [][] treeMap = new String[323][31];
    readInput(treeMap);

    Point p = new Point(3,1);
    int answer1 = answer(treeMap, (p));
    System.out.println("Answer One = "+answer1);  

    Point[] keys = {new Point(1,1),new Point(3,1),new Point(5,1),new Point(7,1),new Point(1,2)};
    int answer2 = 1;
    for(Point key : keys) {
      answer2 = answer2*answer(treeMap, key);   
    }
    System.out.println("\nAnswer Two = "+answer2);   
  }
  
  public static int answer(String[][] treeMap, Point p) {
      int trees = 0;
      int x = p.x;
      for(int y = p.y; y < treeMap.length; y += p.y) {
        if(x > treeMap[y].length-1) {
          x -= treeMap[y].length;    
        }
        String s = treeMap[y][x];
        if(s.equals("#")) {
          trees++;
        }
        x+=p.x;        
      }
      return trees;
  }

  public static void readInput(String[][] treeMap) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("input.txt"));
    for(int i = 0; i < treeMap.length; i++) {
      String[] line = scan.nextLine().split("");
      for(int j = 0; j < treeMap[i].length; j++) {
        treeMap[i][j] = line[j];
      }
    } 
  }
}
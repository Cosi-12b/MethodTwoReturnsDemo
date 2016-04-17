package edu.brandeis.cosi12b.methodtworeturns;

import java.util.Random;
import java.util.function.IntUnaryOperator;

/*
 * The problem is to write a method that will return two random integers. The sum of the integers must be 
 * equal to the parameter. This demo illustrates three possible ways of doing this in java. Approach 3 is the most unusual
 * and clever and therefore the least preferred. Approach 1 and 2 are about equal in desirability, with 
 * in my opinion approach 2 being the best.
 */

class TwoVal {
  int val1;
  int val2;
}

public class MethodTwoReturns {

  public static void main(String[] args) {
    
    // Approach 1
    TwoVal res = new TwoVal();
    approach1(100, res);
    System.out.println("Approach 1: " + res.val1 + ", " + res.val2);
    
    // Approach 2
    int[] results;
    results = approach2(100);
    System.out.println("Approach 2: " + results[0] + ", " + results[1]);
    
    // Approach 3
    IntUnaryOperator func = approach3(100);
    System.out.println("Approach 3: " + func.applyAsInt(0) + ", " + func.applyAsInt(1));
  }

  private static void approach1(int i, TwoVal res) {
    Random r = new Random();
    res.val1 = r.nextInt(i);
    res.val2 = i - res.val1;
  }

  private static int[] approach2(int i) {
    int[] res = new int[2];
    Random r = new Random();
    res[0] = r.nextInt(i);
    res[1] = i - res[0];
    return res;
  }
  
  private static IntUnaryOperator approach3(int i) {
    Random r = new Random();
    int val1 = r.nextInt(i);
    int val2 = i - val1;
    return result -> result == 0 ? val1 : val2;
  }

}

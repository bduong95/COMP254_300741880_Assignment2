/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Random;

/**
 * Demonstration of algorithms for computing the prefix averages of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class PrefixAverage {

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    for (int j=0; j < n; j++) {
      double total = 0;            // begin computing x[0] + ... + x[j]
      for (int i=0; i <= j; i++)
        total += x[i];
      a[j] = total / (j+1);        // record the average
    }
    return a;
  }

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
    for (int j=0; j < n; j++) {
      total += x[j];               // update prefix sum to include x[j]
      a[j] = total / (j+1);        // compute average based on current sum
    }
    return a;
  }
  
  // Main here
  public static void main(String[] args) {
      Random random = new Random();
      
      // Use different input sizes
      int size = 1000;
      
      double[] myArray = new double[size];
      
      // Populate the empty array with random numbers
      for (int i = 0; i < size; i++)
      {
    	  myArray[i] = random.nextDouble();
      }
      
      long startTime, endTime;
      double run1 = 0;
      double run2 = 0;
      
      // Number of repetitions for each input size (milliseconds run too fast to see!)
      int repetitions = 100; 
      
      for (int i = 0; i < repetitions; i++) {
          startTime = System.currentTimeMillis();
          prefixAverage1(myArray);
          endTime = System.currentTimeMillis();
          run1 += (endTime - startTime) ; // Convert to milliseconds
          
          startTime = System.currentTimeMillis();
          prefixAverage2(myArray);
          endTime = System.currentTimeMillis();
          run2 += (endTime - startTime) ; // Convert to milliseconds
      }

      // Calculate average duration for each algorithm
      run1 /= repetitions;
      run2 /= repetitions;

      // Display results
      System.out.println(String.format("Array: %d", size));
      System.out.println(String.format("Average runtime for prefixAverage1: %f milliseconds", run1));
      System.out.println(String.format("Average runtime for prefixAverage2: %f milliseconds", run2));
      System.out.println();
  }
  //
}

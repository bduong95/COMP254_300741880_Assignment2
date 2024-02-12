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

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }
  
  // Main method
  public static void main(String[] args) {

	  int n = 100000000;
	  long startTime = 0L;
	  long endTime = 0L;
	  long duration = 0L;
	  boolean keepGoing = true;
	  Random random = new Random();
	  
	  while (keepGoing) {
		  // Populate array with random numbers (size based off whatever wasn't over 1 min)
	      int[] array = new int[n];      
	      for (int i = 0; i < n; i++) {
	          array[i] = random.nextInt(); 
	      }
	      
		  // Record start time
	      startTime = System.currentTimeMillis();      
	      // Call the algorithm (test unqiue1 and unique2) <==
	      boolean result = unique1(array); 	      
	      // Record end time
	      endTime = System.currentTimeMillis();	      
	      // Calculate the duration
	      duration = endTime - startTime;
	      
	      // Check if the duration exceeds one minute
	      // 60 seconds x 1000 milliseconds = 60,000 milliseconds)
	      if (duration < 60 * 1000) {
	          // If the duration exceeds one minute, break the loop
	    	  n++; 
	      }
	      else {
	    	  // Takes too long to run
	    	  System.out.println("n: " + n + ", Time taken: " + duration + " milliseconds");
	    	  keepGoing = false;
	      }      								
	  }  
	  
  }
  ////
}

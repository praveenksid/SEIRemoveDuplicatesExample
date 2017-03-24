package com.sei.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class removes duplicates in a given array by multiple ways
 *
 */
public class RemoveDuplicatesApp {

	public static void main(String[] args) {
		int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18,
				4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
				19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

		// int[] randomIntegers = randomArray(100000, 1000);

		if (randomIntegers == null || randomIntegers.length <= 0) {
			System.err.println("Please specify array of integers");
			return;
		}

		System.out.println();
		System.out.println("Array With Duplicates:");
		printInfo(randomIntegers);

		removeDuplicatesWithoutCollection(randomIntegers);
		removeDuplicatesWithCollection(randomIntegers);
		removeDuplicatesJava8(randomIntegers);
	}

	/**
	 * This method removes duplicate elements without using Collections
	 * Framework. It loops through array two times to eliminate duplicates. This
	 * maintains original order.
	 * 
	 * Positive: less time taken with smaller array. 
	 * Negative: More lines of code, hard to debug, performance decreases as size of array increases O(n).
	 * 
	 * @param arrayWithDuplicates
	 */
	public static void removeDuplicatesWithoutCollection(int[] arrayWithDuplicates) {

		long start = System.nanoTime();
		System.out.println("========================================");
		System.out.println("Inside removeDuplicatesWithoutCollection");
		int noOfUniqueElements = arrayWithDuplicates.length;

		for (int i = 0; i < noOfUniqueElements; i++) {
			for (int j = i + 1; j < noOfUniqueElements; j++) {

				// If any two elements are found equal
				if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
					// Replace duplicate element with last unique element
					arrayWithDuplicates[j] = arrayWithDuplicates[noOfUniqueElements - 1];

					noOfUniqueElements--;
					j--;
				}
			}
		}

		// Copying only unique elements of arrayWithDuplicates into
		// arrayWithoutDuplicates

		int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, noOfUniqueElements);

		System.out.println("Array Without Duplicates:");
		printInfo(arrayWithoutDuplicates);

		long end = System.nanoTime();
		System.out.println("Time taken (in nanoseconds): " + (end - start));
		System.out.println("Time taken (in ms): " + (end - start) / 1000000);

	}

	/**
	 * This method uses TreeSet to remove duplicates and sort the elements in
	 * ascending order.
	 * 
	 * Positive: less code. Performance is best with larger arrays.
	 * Negative: for smaller arrays this method takes more time comparatively when compared with removeDuplicatesWithoutCollection method.
	 * 
	 * @param randomIntegers
	 */
	private static void removeDuplicatesWithCollection(int[] randomIntegers) {

		long start = System.nanoTime();

		System.out.println("========================================");
		System.out.println("Inside removeDuplicatesWithCollection");
		Set<Integer> noDuplicates = new TreeSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			noDuplicates.add(Integer.valueOf(randomIntegers[i]));
		}
		System.out.println("Array Without Duplicates:");
		System.out.println(noDuplicates);
		System.out.println("Array Size: " + noDuplicates.size());

		long end = System.nanoTime();
		System.out.println("Time taken (in nanoseconds): " + (end - start));
		System.out.println("Time taken (in ms): " + (end - start) / 1000000);
	}

	/**
	 * This method uses java 8 API to remove duplicate elements. 
	 * 
	 * Positive: even lesser code. Performance better with larger array size.
	 * Negative: more time taken for lesser array size when compared with removeDuplicatesWithoutCollection method, Java 8 dependency
	 * 
	 * @param arr
	 */
	private static void removeDuplicatesJava8(int[] arr) {

		long start = System.nanoTime();

		System.out.println("========================================");
		System.out.println("Inside removeDuplicatesJava8");
		int[] noDuplicates = Arrays.stream(arr).distinct().toArray();
		System.out.println("Array Without Duplicates : ");
		printInfo(noDuplicates);

		long end = System.nanoTime();
		System.out.println("Time taken (in nanoseconds): " + (end - start));
		System.out.println("Time taken (in ms): " + (end - start) / 1000000);
	}

	/**
	 * This method prints array contents and size to console.
	 * 
	 * @param integers
	 */
	private static void printInfo(int[] integers) {
		System.out.println("Array Size: " + integers.length);
		System.out.println(Arrays.toString(integers));
	}

	/**
	 * This method generates random integers and returns in an array
	 * 
	 * @param size
	 * @return
	 */
	public static int[] randomArray(int size, int maxNumber) {

		Random random = new Random();
		int[] numbers = new int[size];
		// Generates Random Numbers in the range 1 -10000
		// for (int i = 0; i < numbers.length; i++) {
		// numbers[i] = (int) (Math.random() * 10000 + 1);
		// } // end for loop

		for (int i = 0; i < size; i++) {
			numbers[i] = random.nextInt(maxNumber) + 1;
		}

		return numbers;
	}

}

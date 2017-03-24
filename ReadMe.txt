Submitted by: Praveen Siddaramappa

1. Given the following class, write 3 methods that can be used to return an array that has no duplicates.
2. You should define a method signature that you feel is appropriate to the problem.
3. We would prefer to see three implementations (one that should take into consideration #4 below) and an explanation of what use-cases are suitable to each implementation 
4. What if we need to retain the original order?
5. What are the positives and negatives of your solution?
6. Can you implement it another way so as to avoid the negatives?
7. Your solution should be testable and “production ready.”
8. Your solution should be posted to a public github repo that SEI can clone.


Main Class: RemoveDuplicatesApp

It contains three methods for removing duplicates in an array:

1. removeDuplicatesWithCollection

This method uses TreeSet to remove duplicates and sort the elements in ascending order.

Positive: less code. Performance is best with larger arrays.
Negative: for smaller arrays this method takes more time comparatively when compared with removeDuplicatesWithoutCollection method.

2. removeDuplicatesJava8()

This method uses java 8 API to remove duplicate elements. 

Positive: even lesser code. Performance better with larger array size.
Negative: more time taken for lesser array size when compared with removeDuplicatesWithoutCollection method, Java 8 dependency

3. removeDuplicatesWithoutCollection - 

This method removes duplicate elements without using Collections Framework. 
It loops through array two times to eliminate duplicates. This maintains original order.

Positive: less time taken with smaller array. 
Negative: More lines of code, hard to debug, performance decreases as size of array increases O(n).
	  




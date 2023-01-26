# CSE15L Lab Reports
### Shixuan Wu
&nbsp;
&nbsp;
## Part 1
### Here is the link for my code:
[Server.java](/week3/Server.java)

[StringServer.java](/week3/StringServer.java)

#### First, I start the server and type the url with  `/add-message?s=Hello`
![Image](/week3/part1_hello.jpg)

#### Then, I start the server and type the url with  `/add-message?s=How are you`
![Image](/week3/part1_how.jpg)

- Which methods in your code are called?
####  I called the method Handle method of the ServerHttpHandler class in Server file and handleRequest in the StringServer file. 
&nbsp;
- What are the relevant arguments to those methods, and the values of any relevant fields of the class?
####  The relevant argument for the Handle is the URLhandler in the ServerHttpHandler class. As for the handleRequest method, the URL is essential to extract the information. 
&nbsp;
- How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
####  The values of the URL  chanegs during the process. It changes from http://localhost:4001/add-message?s=Hello to http://localhost:4001/add-message?s=How%20are%20you. Moreover, The values of the stringList I defined to store the values extracted from the URL changed, as we input more string to our website. It will append new string as we give it more. 


&nbsp;
&nbsp;
---
## Part 2
#### I choose to illustrate this using the example of Arrary Methods:

### A failure-inducing input for the buggy program, as a JUnit test and any associated code (write it as a code block in Markdown)
```java
import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = {1,3,6};
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{6,3,1}, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = {1,2,4,5};
    assertArrayEquals(new int[]{5,4,2,1}, ArrayExamples.reversed(input1));
  }

  @Test
  public void testAvg() {
    double[] input1 = {3,5,3};
    System.out.println("test3 "+ArrayExamples.averageWithoutLowest(input1)); 
    assertEquals(4,ArrayExamples.averageWithoutLowest(input1),0);

  }
}

```

&nbsp;
### An input that doesn’t induce a failure, as a JUnit test and any associated code (write it as a code block in Markdown)
```java
import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = {1};
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{1}, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = {2};
    assertArrayEquals(new int[]{2}, ArrayExamples.reversed(input1));
  }

  @Test
  public void testAvg() {
    double[] input1 = {3};
    System.out.println("test3 "+ArrayExamples.averageWithoutLowest(input1)); 
    assertEquals(0,ArrayExamples.averageWithoutLowest(input1),0);

  }
}
```

&nbsp;
&nbsp;
### The symptom, as the output of running the tests (provide it as a screenshot of running JUnit with at least the two inputs above)
#### Screenshot for unsucessful tests
![Image](/week3/part2_1.png)
#### Screenshot for sucessful tests
![Image](/week3/part2_2.jpg)
### The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)
#### For the first one testReverseInPlace() , I noticed that it updates the values while assigning to other indices. Therefore, I add a temp to temporarily store the original array. 
#### For the second one testReversed() , I noticed that it returns the new initialized array. I fixed the mixup of variable names. 
#### For the method averageWithoutLowest, I noticed that it did not consider when there are mutiple lowest values. Therefore, I just sum all values, subtract the lowest and then divide by the length of array -1. 

### Before 
```java
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }

  // Averages the numbers in the array (takes the mean), but leaves out the
  // lowest number when calculating. Returns 0 if there are no elements or just
  // 1 element in the array
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
      if(num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
  }


}
```
---
### After
```java
import java.util.Arrays;
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    int[] temp = Arrays.copyOf(arr, arr.length);
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = temp[arr.length - i - 1];
    }
  }

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      newArray[i] = arr[arr.length - i - 1];
    }
    return newArray;
  }

  // Averages the numbers in the array (takes the mean), but leaves out the
  // lowest number when calculating. Returns 0 if there are no elements or just
  // 1 element in the array
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
      sum += num; 
    }
    return (sum-lowest) / (arr.length - 1);
  }


}
```



&nbsp;
&nbsp;

## Part 3
#### From this lab, I learn how to write tests and debug our program. I learn how to write Assertion statement for various data types. The Junit tests are useful in debuging our class and methods. 


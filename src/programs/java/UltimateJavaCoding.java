package programs.java;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UltimateJavaCoding {
    // Method to reverse the string without using String reverse function of string builder
    public String reverseStringWithoutStringBuilderFunction(String input) {
        char chars[] = input.toCharArray();
        String reverseString = null;
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseString = reverseString + chars[i];
        }
        return reverseString;
    }

    // Method to reverse the string using String reverse function of string builder
    public String reverseStringUsingStringBuilderFunction(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method to count number of words in a string using HashMap
    public void countWordsOfStringUsingHashmap(String input) {
        String splitString[] = input.split(" ");
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        for (String string : splitString)
            countMap.put(string, countMap.containsKey(string) ? countMap.get(string) + 1 : 1);
        System.out.println(countMap);
    }

    // Method to verify whether a given number is a prime or not
    public static boolean isPrimeNumber(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    // Method to verify whether a string is palindrome or not
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * Method to verify whether a number is palindrome or not
     * Given an integer x, return true if x is palindrome integer. An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is a palindrome while 123 is not.
     * <p>
     * Example 1:
     * Input: x = 121, Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     * <p>
     * Example 2:
     * Input: x = -121, Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * <p>
     * Example 3:
     * Input: x = 10, Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */
    public boolean palindromeCheckForNumber(int x) {
        int temp = x;
        int remainder = 0, result = 0;

        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        while (temp > 0) {
            remainder = temp % 10;
            temp = temp / 10;
            result = result * 10 + remainder;
        }

        return result == x ? true : false;
    }

    //Method to print first 'n' Fibonacci numbers using non-recursive approach from the series of infinite Fibonacci numbers starting from 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 ..
    public void fibonacciSeries(int num) {
        int a = 0, b = 0, c = 1;

        for (int i = 1; i <= num; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + " ");
        }
    }

    //Recursive method to print first 'n' Fibonacci numbers using recursive approach from the series of infinite Fibonacci numbers starting from 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ..
    public int fibonacciSeriesUsingRecursive(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fibonacciSeriesUsingRecursive(n - 2) + fibonacciSeriesUsingRecursive(n - 1);
    }

    /**
	 * Method to print Fibonacci series numbers until the given fibonacci number.
     * If n = 55, then this method will print Fibonacci numbers until 55 Fibonacci number from the series starting from 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ..
     * If n = 987, then this method will print Fibonacci numbers until 987 Fibonacci number from the series starting from 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 ..
	*/
    public void fibonacciNumbersUntilN(int n) {
        int a = 0, b = 0, c = 1;

        while (a < n) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + " ");
        }
    }

    // Method to sort array in ascending order
    public int[] bubbleSort(int input[]) {

        int temp = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length - i; j++) {
                if (input[j - 1] > input[j]) {
                    temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    // Method to sort array in descending order
    public void sortArrayInDescendingOrder(int input[]) {
        System.out.println("Initial array is: ");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

        int temp = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] < input[j]) {
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }

        System.out.println("Sorted array is: ");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    //Method  to sort a string
    public String sortString(String str) {

        char arr[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (arr[i] > arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
        }
        return result;

        /** This can also be done using Arrays.sort() method
         *
         char[] arr = str.toCharArray();
         Arrays.sort(arr);

         String result = new String(arr);
         return result;
         **/
    }

    // Method to verify whether a num is armstrong num or not
    public void armstrongNumberCheck(int num) {
        int temp = 0, temp1 = num, reminder;
        while (num > 0) {
            reminder = num % 10;
            num = num / 10;
            temp = temp + (reminder * reminder * reminder);
        }

        if (temp == temp1)
            System.out.println(temp1 + " is an armstrong number");
        else
            System.out.println(temp1 + " is not an armstrong number");
    }

    // Method to remove duplicate elements from string
    public String removeDuplicateCharsFromString(String input) {
        /**
         * Simple approach is to insert all the characters of the string into a HashSet which will automatically take care of ignoring duplicates.
         *
         LinkedHashSet<String> set = new LinkedHashSet<String>();
         for (int i = 0; i < input.length(); i++)
         set.add(input.charAt(i));

         System.out.print(set);
         **/

        //The problem with the above approach is that set does not maintain insertion order and gives the final strings with characters in ascending order.
        //To print the string by just removing the duplicate characters and not changing the order of other characters, lets use indexOf() method of string.
        String str = "";
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            if (str.indexOf(ch) < 0)
                str += ch;
        }
        return str;
    }

    // Method to reverse a number
    public void reverseNumber(int num) {
        int reverse = 0, remainder = 0;

        while (num > 0) {
            remainder = num % 10;
            num = num / 10;
            reverse = reverse * 10 + remainder;
        }
        System.out.println(reverse);
    }

    // Method to print first non-repeated character of a string. Example: Apple - A, America - m
    public void getFirstNonRepeatedCharOfString(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<Character, Integer>();
        char result = ' ';
        char charArray[] = str.toCharArray();

        for (char character : charArray)
            countMap.put(character, countMap.containsKey(character) ? countMap.get(character) + 1 : 1);

        for (Map.Entry<Character, Integer> character : countMap.entrySet()) {
            if (character.getValue() == 1) {
                result = character.getKey();
                break;
            }
        }

        if (result == ' ')
            System.out.println("Didn't find any non repeated characters");
        else
            System.out.println("First non repeated character is: " + result);
    }

    // Method to find second-highest number in an array
    public void secondHighestNumInArray(int input[]) {

        int largest = input[0], secondLargest = Integer.MIN_VALUE;
        int arrSize = input.length;

        for (int i = 1; i < arrSize; i++) {
            if (input[i] > largest) {
                secondLargest = largest;
                largest = input[i];
            } else if (input[i] > secondLargest) {
                secondLargest = input[i];
            }
        }

        System.out.println("Second largest number is:" + secondLargest);
        System.out.println("Largest Number is: " + largest);

    }

    // Method to find third-largest element in the array without sorting and using nested for loops.
    public void thirdLargestElementInArray(int arr[]) {
        int arr_size = arr.length;

        if (arr_size < 3) {
            System.out.printf(" Invalid Input ");
            return;
        }

        // Initialize first, second and third Largest element
        int first = arr[0], second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        // Traverse array elements to find the third Largest
        for (int i = 1; i < arr_size; i++) {
            /*
             * If current element is greater than first, then update first, second and third
             */
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            }

            /* If arr[i] is in between second and third */
            else if (arr[i] > third) {
                third = arr[i];
            }
        }

        System.out.printf("The third Largest element is %d\n", third);
    }

    // Method to reverse a linked list
    public void reverseLinkedList(LinkedList<Object> l) {

        for (int i = 0, j = l.size() - 1; i < j; i++)
            l.add(0, l.remove(j));
        System.out.println("Reverse order of given List is :" + l);
    }

	/** Problem: Rotate an array of n elements to the right by k steps.
	 *
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 * @param nums
	 * @param k
	 * @return
	 */
    public int[] rotateArrayByK(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        return nums;
    }

    // Method to find which version (ver1 = 2.4.7 & ver2 = 1.64.7455) is greater or lesser
    public void versionCheck(String ver1, String ver2) {
        String[] ver1Array = ver1.split("\\.");
        String[] ver2Array = ver2.split("\\.");
        String myString = "";

        if (ver1Array.length == 3 && ver2Array.length == 3) {
            if (Integer.parseInt(ver1Array[0]) > Integer.parseInt(ver2Array[0]))
                myString = "Version 1 is greater than Version 2";
            else if (Integer.parseInt(ver1Array[0]) < Integer.parseInt(ver2Array[0]))
                myString = "Version 1 is lesser than Version 2";
            else if (Integer.parseInt(ver1Array[0]) == Integer.parseInt(ver2Array[0])) {
                if (Integer.parseInt(ver1Array[1]) > Integer.parseInt(ver2Array[1]))
                    myString = "Version 1 is greater than Version 2";
                else if (Integer.parseInt(ver1Array[1]) < Integer.parseInt(ver2Array[1]))
                    myString = "Version 1 is lesser than Version 2";
                else if (Integer.parseInt(ver1Array[1]) == Integer.parseInt(ver2Array[1])) {
                    if (Integer.parseInt(ver1Array[2]) > Integer.parseInt(ver2Array[2]))
                        myString = "Version 1 is greater than Version 2";
                    else if (Integer.parseInt(ver1Array[2]) < Integer.parseInt(ver2Array[2]))
                        myString = "Version 1 is lesser than Version 2";
                    else if (Integer.parseInt(ver1Array[2]) == Integer.parseInt(ver2Array[2])) {
                        myString = "Version 1 and Version 2 are same";
                    }
                }
            }
        } else
            myString = "Given versions are not in the correct format";
        System.out.println(myString);
    }

	/** Amazon customer reviews question - This method will output a maximum of 3 keyword suggestions in alphabetical order
	 * after each character is typed by the customer in search field.
	 * Leetcode link: https://leetcode.com/discuss/interview-question/850261/Amazon-Customer-Reviews-Question/996273
 	 */
    public List<List<String>> amazonSearchSuggestions(List<String> repository, String customerQuery) {

        List<List<String>> res = new ArrayList<List<String>>();

        for (int i = 1; i < customerQuery.length(); i++) {
            String s = customerQuery.substring(0, i + 1).toLowerCase();
            List<String> temp = new ArrayList<String>();

            for (int j = 0; j < repository.size(); j++) {
                if (repository.get(j).toLowerCase().startsWith(s)) {
                    temp.add(repository.get(j).toLowerCase());
                }
            }

            Collections.sort(temp);

            List<String> v = new ArrayList<String>();
            for (int p = 0; p <= 2 && p < temp.size(); p++) {
                v.add(temp.get(p));
            }
            res.add(v);
        }
        return res;
    }

    // Method to print all sub arrays of the given array using iterative approach.
    public void printSubarraysUsingIterations(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = i; j < arr.length; j++) {
                temp.add(arr[j]);
                System.out.println(temp);
            }
        }
    }

    // Method to print all sub arrays of the given array using recursion
    public void printSubarraysUsingRecursion(int[] arr, int start, int end) {

        if (end == arr.length)
            return;

        else if (start > end)
            printSubarraysUsingRecursion(arr, 0, end + 1);

        else {
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = start; i <= end; i++)
                temp.add(arr[i]);

            System.out.println(temp);
            printSubarraysUsingRecursion(arr, start + 1, end);
        }
        return;
    }

    // Method to print max sub array length of given array whose product is 1
    public void printMaxSubArrayLengthWhoseProductIsOne(int[] arr) {

        List<Integer> lengthsList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();

            for (int j = i; j < arr.length; j++) {
                temp.add(arr[j]);

                if (productOfListElements(temp) == 1) {
                    lengthsList.add(temp.size());
                }
            }
        }
        System.out.println(Collections.max(lengthsList));
    }

    // Method to find the product of given list
    public int productOfListElements(List<Integer> myList) {
        int size = myList.size();
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = result * myList.get(i);
        }
        return result;
    }

    // Method to iterate and print map values using for each loop
    public void iterateOverMap() {
        Map<String, String> myMap_645614 = new HashMap<String, String>();

        myMap_645614.put("GFG", "geeksforgeeks.org");
        myMap_645614.put("Practice", "practice.geeksforgeeks.org");
        myMap_645614.put("Code", "code.geeksforgeeks.org");
        myMap_645614.put("Quiz", "quiz.geeksforgeeks.org");

        for (Map.Entry<String, String> entry : myMap_645614.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }

    // Method to return the smallest positive number missing from an unsorted array
    public int smallestPositiveInteger(int A[]) {
        int n = A.length;
        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            // Only mark the required elements. All non-positive elements and the elements
            // greater n + 1 will never be the answer.
            // For example, the array will be {1, 2, 3} in the worst case and the result
            // will be 4 which is n + 1
            if (A[i] > 0 && A[i] <= n)
                present[A[i]] = true;
        }

        // Find the first element which didn't appear in the original array
        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;

        // If the original array was of the type {1, 2, 3} in its sorted form, return
        // n+1
        return n + 1;
    }

	/** Method to return a Palindrome string having N chars with K distinct characters.
	 *  Let's say N = 4 and K = 2, Then the answer can be baab or abba or any thing which contains only 2 alphabetical characters.
	 *  The answer cannot be aaaa or bbbb as the palindrome string has only one character.
	 * @param N
	 * @param K
	 */
    public static void generatePalindromHavingNCharsWithKDistinctChars(int N, int K) {

        if (N >= (K * 2) - 1) {
            char letters[] = new char[K];

            System.out.print("List of characters to be used for building the palindrome string are: ");
            for (int i = 0; i < K; i++) {
                letters[i] = (char) ('a' + i);
                System.out.print(letters[i] + " ");
            }

            int l, r, j;

            char Arr[] = new char[N];

            if (N % 2 == 0) {
                l = N / 2 - 1;
                r = N / 2;
                j = 0;
            } else {
                Arr[N / 2] = letters[0];
                l = N / 2 - 1;
                r = N / 2 + 1;
                j = 1;
            }

            while (l >= 0 && r <= N) {
                Arr[l] = letters[j];
                Arr[r] = letters[j];

                l--;
                r++;
                j++;

                if (j >= K)
                    j = 0;
            }

            System.out.println();
            System.out.println("Final palindrome string is: " + new String(Arr));
        } else
            System.out.println("We cannot form a palindrome string of lenght " + N + " by using " + K + " Characters");
    }

	/** Method to find the highest sum of two numbers in the array whose sum of digits are also same
	 *  Input: arr[]={55, 23, 32, 46, 88}, Output: 101
	 *  Explanation: Pair {55, 46} will give the sum of 55 + 46 = 101
	 *  Input: arr[]={18, 19, 23, 15}, Output: Error message
	 */
    public static void highestSumWithHighestDigitsSum(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int result = 0;

        for (int j = n - 1; j > 0; j--) {
            int jElementDigitsSum = digitsSum(A[j]);
            for (int i = n - 2; i > j; i--) {
                int iElementDigitsSum = digitsSum(A[i]);
                if (iElementDigitsSum == jElementDigitsSum) {
                    result = A[i] + A[j];
                    break;
                }
            }
        }

        if (result != 0)
            System.out.println("Final sum is: " + result);
        else
            System.out.println("Array doesn't have numbers satisfying the given conditions");
    }

    // Method to find the sum of the digits of a number
    public static int digitsSum(int a) {
        int remainder = 0, result = 0;

        while (a > 0) {
            remainder = a % 10;
            a = a / 10;
            result = result + remainder;
        }

        return result;
    }

    /** Method to find out the distance between two characters of a string
	 * Examples:
	 *     String str = "Hello, World!";
	 *     char ch1 = 'e';
	 *     char ch2 = 'W';
	 *
	 *     String str = "Hello, World!";
	 *     char ch1 = 'z'; // 'z' is not present in the string
	 *     char ch2 = 'W';
	 *
	 *     String str = "abcdef";
	 *     char ch1 = 'd'; // 'd' occurs at index 3
	 *     char ch2 = 'b'; // 'b' occurs at index 1
    */
    public static void distanceBwnTwoCharsOfString(String str, char ch1, char ch2) {
        // If we just need to test +ve scenario, the below code will work. But to cover all the use cases, we need custom code.
        // System.out.println("Distance between two characters is " + (str.indexOf(ch2) - str.indexOf(ch1)));

        char charArray[] = str.toCharArray();
        int arrayLength = charArray.length;
        int pos1 = -1, pos2 = -1;

        for (int i = 0; i < arrayLength; i++) {
            char element = charArray[i];
            if (element == ch1)
                pos1 = i;
            if (element == ch2)
                pos2 = i;
        }

        if (pos1 == -1 || pos2 == -1)
            System.out.println("Atleast one of the given character not found in the string");
        else
            System.out.println("Distance between two characters is: " + (Math.abs(pos2 - pos1)));
    }

    // Method to put _ between a small and capital letter in a given string
    public static void puttingUnderscoreBetweenSmallAndCapitalLetters(String str) {
        int strLength = str.length();
        String result = "";

        for (int i = 0; i < strLength; i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    && (str.charAt(i + 1) >= 'A' && str.charAt(i + 1) <= 'Z'))
                result = result + str.charAt(i) + '_';
            else
                result = result + str.charAt(i);
        }

        if (result.equals(str))
            System.out.println("There is no scope to insert _ between the small and capital letters in the given string");
        else
            System.out.println("Final string after inserting _ between small and capital letter is: " + result);
    }

    // Java program to write into a file and then read the same file
    public static void writeAndReadFile() {

        // Writing into a file
        try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("Hello World");
            writer.write("\r\n"); // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from the file
        try {
            FileReader reader = new FileReader("MyFile.txt");
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	// Write and read file using buffered class in Java
    public void writeAndReadFileUsingBufferedClass() {
        // Writing into file
        try {
            FileWriter writer = new FileWriter("SampleTextFileToWriteData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("See You Again!");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from file
        try {
            FileReader reader = new FileReader("SampleTextFileWithData.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Line starts here");
                System.out.println(line);
                System.out.println("Line ends here");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to find the same and different elements of the lists
    public static void sameAndDiffElementsOfLists(List<Integer> list1, List<Integer> list2) {

        // Method-1: Using the inbuilt methods of collection framework
        List<Integer> list3 = new ArrayList<Integer>(list1);
        list1.retainAll(list2);
        System.out.println("Common elements: " + list1);

        list3.removeAll(list1);
        System.out.println("List-1 specific elements: " + list3);

        list2.removeAll(list1);
        System.out.println("List-2 specific elements: " + list2);

        // Method-2: Using the core logic of java and finding out the required data
        List<Integer> list1OnlyElements = new ArrayList<Integer>();
        List<Integer> list2OnlyElements = new ArrayList<Integer>();
        List<Integer> commonElements = new ArrayList<Integer>();

        for (Integer l1 : list1) {
            if (list2.contains(l1)) commonElements.add(l1);
            else list1OnlyElements.add(l1);
        }

        for (Integer l2 : list2)
            if (!list1.contains(l2)) list2OnlyElements.add(l2);

        System.out.println("List-1 only elements: " + list1OnlyElements);
        System.out.println("List-2 only elements: " + list2OnlyElements);
        System.out.println("Common elements in both the lists: " + commonElements);
    }

    public static void slidingWindowMax(int arr[], int n, int k) {
        int j, max;

        for (int i = 0; i <= n - k; i++) {

            max = arr[i];

            for (j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }

	/**
	 * Method to print the below pattern
	 *      1
	 *      2 3
	 *      4 5 6
	 *      7 8 9 10
	 *      11 12 13 14 15
 	 */
    public static void printFloydsTriangle(int n) {
        int i, j, k = 1;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(k + "  ");
                k++;
            }
            System.out.println();
        }
    }

	/**
	 * Method to print the below pattern
	 *      15 14 13 12 11
	 *      10 9 8 7
	 *      6 5 4
	 *      3 2
	 *      1
 	 */
    public static void printReverseFloydsTriangle(int num) {
        int k = 15;
        for (int i = num; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k + " ");
                k--;
            }
            System.out.println();
        }
    }

	/**
	 * Method to print the below pattern
	 *      1
	 *      3 2
	 *      6 5 4
	 *      10 9 8 7
	 *      15 14 13 12 11
 	 */
    public static void printFloydsTriangleWithReverseNumbers(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = k + i; j > k - i; j--) {
                System.out.print(j + " ");
                k++;
            }
            System.out.println();
        }
    }

    /**
     * Two Sum Problem: Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * For example:
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index + 1;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }

    // Method to print the length of the maximum sub string in a given string
    public int lengthOfLongestSubstring(String s) {
        String test = "";
        int maxLength = -1;

        if (s.isEmpty())
            return 0;

        else if (s.length() == 1)
            return 1;

        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);

            // If string already contains the character then substring after repeating character
            if (test.contains(current))
                test = test.substring(test.indexOf(current) + 1);

            test = test + current;
            maxLength = Math.max(test.length(), maxLength);
        }
        return maxLength;
    }

	/**
	 * Longest Palindromic Substring in Java
	 * Example 1: Input: s = "babad", Output: "bab". Explanation: "aba" is also a valid answer.
	 * Example 2: Input: s = "cbbd", Output: "bb"
	 *
	 * @param s
	 * @return
	 */
    public String longestPalindrome(String s) {
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();
        // check all possible sub strings
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i;
                String curr = s.substring(i, j + 1);
                if (isPalindrome(curr)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }
        return longestPalindrome;
    }

	/**
	 * Valid Palindrome: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
	 */
    public class ValidPalindrome {
        public boolean isValidPalindrome(String s) {
            if (s == null || s.length() == 0) return false;
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            System.out.println(s);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Method to find the median of two sorted arrays
    public static void findMedianOfSortedArrays(int[] firstArray, int[] secondArray) {
        int mergedArraySize = firstArray.length + secondArray.length;

        int[] mergedArray = new int[mergedArraySize];
        int pos = 0;

        for (int element : firstArray) {
            mergedArray[pos] = element;
            pos++;
        }

        for (int element : secondArray) {
            mergedArray[pos] = element;
            pos++;
        }

        Arrays.sort(mergedArray);

        double median;
        if (mergedArraySize % 2 == 0)
            median = (double) (mergedArray[mergedArraySize / 2] + mergedArray[(mergedArraySize / 2) - 1]) / 2;
        else
            median = (double) mergedArray[mergedArraySize / 2];

        System.out.println(median);
    }

	/**
	 * Method to reverse the characters in a word without changing the position of the words in the sentence
	 * Input: My name is Maruthi.
	 * Output: yM eman si ihturaM
	 *
	 * @param input
	 */
    public static void reverseCharsOfWordsWithoutChangingWordsPosition(String input) {

        String output = "";
        String[] strArray = input.split(" ");

        for (int i = 0; i < strArray.length; i++) {

            String temp = "";
            int length = strArray[i].length();
            for (int j = length - 1; j >= 0; j--) {
                temp = temp + strArray[i].charAt(j);
            }
            output = output + temp + " ";
        }
        System.out.println(output);
    }

	/**
	 * Method to print three numbers when sum of two numbers is equal to its next number.
	 * Input: [1, 2, 3, 5, 6, 6, 7, 8, 15]
	 * Output: [1, 2, 3] [2, 3, 5] [7, 8, 15]
	 *
	 * @param inputList
	 */
    public static void printNumsWhenSumOfTwoNumsIsEqualToNextNum(List<Integer> inputList) {
        int listSize = inputList.size();
        for (int i = 0; i < listSize - 2; i++) {
            int firstNum = inputList.get(i);
            int secondNum = inputList.get(i + 1);
            int thirdNum = inputList.get(i + 2);
            if ((firstNum + secondNum) == thirdNum) {
                System.out.print("[" + firstNum + " " + secondNum + " " + thirdNum + "]");
                System.out.println();
            }
        }
    }

	/**
	 *  Method to print Pascal triangle
	 *  Input : N = 5
	 *  Output:
	 * 		   1
	 * 		 1   1
	 * 	   1   2   1
	 * 	 1   3   3   1
	 *    1   4   6   4   1
	 *  1   5   10   10   5   1
	 *
	 *  nCr formula: n ! / ( n – r ) ! r !
	 *  After using nCr formula, the pictorial representation becomes:
	 *
	 * 		   0C0
	 * 		1C0   1C1
	 * 	 2C0   2C1   2C2
	 *   3C0   3C1   3C2   3C3
	 *
	 * @param n
	 */
    public static void pascalTriangle(int n) {
        int ncrValue = 0, i, j;
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= n - i; j++)
                System.out.print(" "); // for left spacing

            for (j = 0; j <= i; j++)
                System.out.print(" " + factorial(i) / (factorial(i - j) * factorial(j)));

            System.out.println();
        }
    }

    //Method to find the factorial of a given number using recursive approach
    public static int factorial(int i) {
        if (i == 0)
            return 1;
        return i * factorial(i - 1);
    }

	/**
	 * Method to convert a sentence to camel case.
	 * Input: My name is Maruthi
	 * Output: MyNameIsMaruthi
	 *
	 * @param str
	 */
    public static void convertSentenceToCamelCase(String str) {
        //Method-1: Using String Builder
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        //Method-1: Using string builder
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' ') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }
        System.out.println(builder);

        //Method-2: Without using String Builder
        int n = str.length();
        String result = String.valueOf(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == ' ') {
                result = result + Character.toUpperCase(str.charAt(i + 1));
                i++;
            } else
                result = result + str.charAt(i);
        }
        System.out.println(result);
    }

	/**
	 * Method to find the nearest smallest and largest prime number for a given number
	 * Input: 15, Output: Small prime - 13, large prime - 17
	 *
	 * @param n
	 */
    public static void NearestSmallLargePrimeOfGivenNumber(int n) {

        for (int i = n + 1; i <= Integer.MAX_VALUE; i++) {
            if (isPrimeNumber(i)) {
                System.out.println("Largest prime of n is: " + i);
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (isPrimeNumber(i)) {
                System.out.println("Smallest prime of n is: " + i);
                break;
            }
        }
    }

	/**
	 * Method to convert Roman numbers to Integers
	 * Input: MCMXCIV
	 * Output: 1994
	 * Time Complexity: The time complexity of this code is O(n),
	 * where n is the length of Roman Number in String format as we are traversing String only once.
	 *
	 * @param romanNum
	 * @return
	 */
    public static int romanToIntegerConversion(String romanNum) {
        Map<Character, Integer> romanValues = new HashMap<Character, Integer>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = romanValues.get(romanNum.charAt(0));
        int romanNumLength = romanNum.length();

        for (int i = 1; i < romanNumLength; i++) {
            char currentChar = romanNum.charAt(i);
            char previousChar = romanNum.charAt(i - 1);
            if (romanValues.get(currentChar) > romanValues.get(previousChar))
                result = result + (romanValues.get(currentChar)) - (2 * (romanValues.get(previousChar)));
            else
                result = result + romanValues.get(currentChar);
        }
        return result;
    }

	/**
	 * Method to convert given array values into a wave. Given an array of arr[0..n-1], then the wave form of the array is like:
	 * arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]....
	 * Input: 10, 90, 49, 2, 1, 5, 23
	 * Output: 90, 10, 49, 1, 5, 2, 23
	 *
	 * @param inputArray
	 */
    public static void convertArrayToWave(int[] inputArray) {

        //One easy method is to sort the array in ascending order and swap all adjacent elements. For example, let the input array be {3, 6, 5, 10, 7, 20}.
        //After sorting, we get {3, 5, 6, 7, 10, 20}. After swapping adjacent elements, we get {5, 3, 7, 6, 20, 10}.
        //The code looks as shown below.
        /**
         Arrays.sort(inputArray);

         for(int i=0; i<inputArray.length; i+=2) {
         swap(inputArray, i, i+1);
         }
         **/

        //The problem with the above code is that the time complexity of the above solution is O(nLogn) if a O(nLogn) sorting algorithm like Merge Sort, Heap Sort, .. etc is used.
        //This same problem can be solved in O(n) time by doing a single traversal of given array.

        //The idea is based on the fact that if we make sure that all even positioned (at index 0, 2, 4, ..) elements are greater than their adjacent odd elements, we don’t need to worry about odd positioned element. Following are simple steps.
        //1) Traverse all even positioned elements of input array, and do following.
        //	a) If current element is smaller than previous odd element, swap previous and current.
        //	b) If current element is smaller than next odd element, swap next and current.

        int arrayLength = inputArray.length;
        for (int i = 0; i < arrayLength; i += 2) {
            if (i > 0 && inputArray[i] < inputArray[i - 1])
                swap(inputArray, i, i - 1);

            if (i < arrayLength - 1 && inputArray[i] < inputArray[i + 1])
                swap(inputArray, i, i + 1);
        }

        for (int arr : inputArray)
            System.out.print(arr + " ");
    }

    //Method to swap two elements of an array present at given indices
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

	/**
	 * Method to find whether the two strings are anagrams or not
	 * An anagram of a string is another string that contains the same characters, only the order of characters can be different.
	 * For example, “abcd” and “dabc” are an anagram of each other.
	 *
	 * @param str1
	 * @param str2
	 * @return
	 */
    public static boolean anagramsCheck(char str1[], char str2[]) {

        //Method-1: In the following implementation, it is assumed that the characters are stored using 8 bit and there can be 256 possible characters.
        //Create a count array of size 256. Initialize all values in count array as 0.
        //increment the value in count array for characters in str1 and decrement for characters in str2.
        //Finally, if all count values are 0, then the two strings are anagram of each other.

        /**int[] countArray = new int[256];

         if(str1.length != str2.length)
         return false;
         else {
         for(int i=0; i<str1.length; i++) {
         countArray[str1[i] - 'a']++;
         countArray[str2[i] - 'a']--;
         }
         }

         for(int i=0; i<countArray.length; i++)
         if(countArray[i]!=0)
         return false;
         return true; **/

        //The complexity of the above program is O(n) which is fine. But we are creating an array of size 256 which occupies more space.
        //we can optimise it using HashMap where we can store character and count of character in HashMap.
        //Idea is to put all characters of one String in HashMap and reducing them as we encounter while looping over other String.

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str1.length; i++)
            map.put(str1[i], map.containsKey(str1[i]) ? map.get(str1[i]) + 1 : 1);

        for (int i = 0; i < str2.length; i++)
            map.put(str2[i], map.get(str2[i]) - 1);

        for (Map.Entry<Character, Integer> value : map.entrySet())
            if (value.getValue() != 0)
                return false;

        return true;
    }

    //Method to find the largest number that can be formed with the given integers
	public static String largestNumber(int[] nums) {
		// Convert integers to strings
		String[] strNums = Arrays.stream(nums)
				.mapToObj(String::valueOf)
				.toArray(String[]::new);

		// Custom comparator to decide order based on concatenation
		Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

		// If the largest number is "0", return "0"
		if (strNums[0].equals("0")) {
			return "0";
		}

		// Join sorted numbers to form the largest number
		return String.join("", strNums);
	}

    /**
     * First, we convert each integer to a string. Then, we sort the array of strings.
     * While it might be tempting to simply sort the numbers in descending order, this causes problems for sets of numbers with the same leading digit.
     * For example, sorting the problem example in descending order would produce the number 95343039534303, while the correct answer can be achieved by transposing the 33 and the 3030.
     * Therefore, for each pairwise comparison during the sort, we compare the numbers achieved by concatenating the pair in both orders. We can prove that this sorts into the proper order as follows:
     * <p>
     * Assume that (without loss of generality), for some pair of integers aa and bb, our comparator dictates that aa should precede bb in sorted order.
     * This means that a\frown b > b\frown aa⌢b>b⌢a (where \frown⌢ represents concatenation). For the sort to produce an incorrect ordering, there must be some cc for which bb precedes cc and cc precedes aa.
     * This is a contradiction because a\frown b > b\frown aa⌢b>b⌢a and b\frown c > c\frown bb⌢c>c⌢b implies a\frown c > c\frown aa⌢c>c⌢a. In other words, our custom comparator preserves transitivity, so the sort is correct.
     * <p>
     * Once the array is sorted, the most "significant" number will be at the front. There is a minor edge case that comes up when the array consists of only zeroes, so if the most significant number is 00, we can simply return 00.
     * Otherwise, we build a string out of the sorted array and return it.
     * <p>
     * Complexity Analysis
     * Time complexity : O(nlgn)
     * Although we are doing extra work in our comparator, it is only by a constant factor. Therefore, the overall runtime is dominated by the complexity of sort, which is O(nlgn) in Python and Java.
     * <p>
     * Space complexity : O(n)
     * Here, we allocate O(n) additional space to store the copy of nums. Although we could do that work in place (if we decide that it is okay to modify nums), we must allocate O(n) space for the final return string.
     * Therefore, the overall memory footprint is linear in the length of nums.
     */
    public String largestNumWithGivenIntegers(int[] arr) {

        String[] stringArray = new String[arr.length];

        // Get input integers as strings.
        for (int i = 0; i < arr.length; i++)
            stringArray[i] = String.valueOf(arr[i]);

        // Sort strings according to custom comparator.
        Arrays.sort(stringArray, new LargestNumberComparator());

        if (stringArray[0].equals(0))
            return "0";

        // Build largest number from sorted array.
        String largestNumberInString = "";
        for (String str : stringArray)
            largestNumberInString += str;

        return largestNumberInString;
    }

    // Program to remove spaces from given string
    String removeWhiteSpaces(String input) {
        StringBuilder output = new StringBuilder();
        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (!Character.isWhitespace(c))
                output.append(c);
        }
        return output.toString();
    }

    // Shuffle an array
    public int[] shuffleArray(int array[]) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // Method to check vowels are present in the string. Ex: Hello - True. TV - False
    public static boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }

    //Method to remove vowels from a string
    public String removeVowelsFromString(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

	/**
	 * Method to find GCD of two numbers
	 * The HCF or GCD of two integers is the largest integer that can exactly divide both numbers (without a remainder).
	 * Lets say a = 81 and b = 153, then GCD(a,b) is 9. Because 81 % 9 = 0 and 153 % 9 = 0
	 *
	 * @param a
	 * @param b
	 * @return
	 */
    public int gcdOfTwoNumbers(int a, int b) {
        int gcd = 1;

        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }

	/**
	 * Method to find LCM of two numbers
	 * The LCM of two integers is the smallest positive integer that is perfectly divisible by both the numbers (without a remainder).
	 * Lets say a = 72 and b = 120, then LCM(a,b) is 360. Because 360 % 72 = 0 and 360 % 120 = 0
	 *
	 * @param a
	 * @param b
	 * @return
	 */
    public int lcmOfTwoNumbers(int a, int b) {

        //Method-1: Using loop
        //Take the largest number between a and b as initial value of lcm
        int lcm, temp = (a > b) ? a : b;

        while (true) {
            if (temp % a == 0 && temp % b == 0) {
                lcm = temp;
                break;
            }
            temp++;
        }
        return lcm;

        //Method-2: Finding LCM using GCD
        //As per the formulae, LCM = (a * b)/GCD(a,b)
        //int gcd = gcdOfTwoNumbers(a,b);
        //return (a * b)/gcd;
    }

    //Binary search
    public boolean binarySearch(int[] arr, int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) //If the element is present at the middle itself
                return true;

            if (arr[mid] > x) //If element is smaller than mid, then it can only be present in left subarray
                return binarySearch(arr, left, mid - 1, x);

            //Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, right, x);
        }
        return false;
    }

	/**
	 * Problem statement: Given a list of integers, count and return the number of times each value appears as an array of integers.
	 * Input: arr[] = [1, 1, 3, 2, 1]
	 * Output: [0, 3, 1, 1]
	 * All of the values are in the range [0..3], so create an array of zeros, [0, 0, 0, 0]. The results of each iteration follow:
	 * i 	arr[i]	result
	 * 0 	1		[0, 1, 0, 0]
	 * 1 	1		[0, 2, 0, 0]
	 * 2 	3		[0, 2, 0, 1]
	 * 3 	2		[0, 2, 1, 1]
	 * 4 	1		[0, 3, 1, 1]
	 *
	 * @param arr
	 * @return
	 */
    public List<Integer> frequencyOfArrayElements(List<Integer> arr) {
        int inputArraySize = arr.size();
        int[] freqArray = new int[inputArraySize];

        for (int i = 0; i < inputArraySize; i++)
            freqArray[arr.get(i)] = freqArray[arr.get(i)] + 1;

        List<Integer> result = new ArrayList<Integer>();
        for (int temp : freqArray)
            result.add(temp);

        return result;
    }

	/**
	 * Given a square matrix, calculate the absolute difference between the sums of its diagonals. For example, the square matrix array is shown below:
	 * 1 2 3
	 * 4 5 6
	 * 9 8 9
	 * The left-to-right diagonal = 1 + 5 + 9 = 15. The right to left diagonal = 3 + 5 + 9 = 17. Their absolute difference is |15 - 17| = 2
	 */
    public int diagonalDifference(List<List<Integer>> arr) {
        int ld = 0, rd = 0;
        int matrixSize = arr.size();

        for (int i = 0, j = matrixSize - 1; i < matrixSize; i++, j--) {
            ld = ld + arr.get(i).get(i);
            rd = rd + arr.get(i).get(j);
        }
        return Math.abs(ld - rd);
    }

	/**
	 * Given a camelCase string, find the number of words in the given sentence
	 * Input: oneTwoThree
	 * Output: 3 (one, Two, Three)
	 */
    public int NumOfWordsInCamelCaseSentence(String s) {
        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i)))
                result++;
        }
        return result;
    }

    //Given a password string, find the minimum number of characters that must be added to make the password strong
    public int minCharsRequired(String password) {
        boolean lowercase = false;
        boolean uppercase = false;
        boolean number = false;
        boolean special = false;
        char[] schars = "!@#$%^&*()-+".toCharArray();

        Set<Character> cs = new HashSet<Character>();
        for (char c : schars)
            cs.add(c);

        int n = password.length();
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') number = true;
            if (c >= 'a' && c <= 'z') lowercase = true;
            if (c >= 'A' && c <= 'Z') uppercase = true;
            if (cs.contains(c)) special = true;
        }

        int need = 0;
        need += lowercase ? 0 : 1;
        need += uppercase ? 0 : 1;
        need += number ? 0 : 1;
        need += special ? 0 : 1;

        return n + need < 6 ? 6 - n : need;
    }

    //Print the number of errors for each error code in the error logs file
    public void printFrequencyOfErrors() {
        try {
            FileReader reader = new FileReader("ErrorLogsFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            Map<String, Integer> errorsMap = new TreeMap<String, Integer>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String regex = "ERROR: 50[\\d]";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (errorsMap.containsKey(matcher.group()))
                        errorsMap.put(matcher.group(), errorsMap.get(matcher.group()) + 1);
                    else
                        errorsMap.put(matcher.group(), 1);
                }
            }
            reader.close();

            for (Map.Entry<String, Integer> ele : errorsMap.entrySet()) {
                System.out.println(ele.getKey() + " - " + ele.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sorts the array using quickSort algorithm
     *
     * @param arr  - The array to be sorted
     * @param low  - Starting index
     * @param high - Ending index
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * This function takes last element as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     *
     * @param arr  - The array to be sorted
     * @param low  - Starting index
     * @param high - Ending index
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot)
                i++;
            swap(arr, i, j);
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    //Input: Welcome to hello world Maruthi. Output: Welcome ot olleh dlrow Maruthi
    public void reverseMiddleWords(String str) {

        String[] strArray = str.split(" ");
        String result = strArray[0];

        for (int i = 1; i <= strArray.length - 2; i++) {
            StringBuilder sb = new StringBuilder(strArray[i]).reverse();
            result = result + " " + sb;
        }
        result = result + " " + strArray[strArray.length - 1];
        System.out.println("Reveresed string is: " + result);
    }

    /**
     * Given a string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
     * <p>
     * Example:
     * Input: exp = “[()]{}{[()()]()}”, Output: Balanced
     * Input: exp = “[(])”, Output: Not Balanced
     */
    public void checkExpressionIsBalancedOrNot(String exp) {

        char[] charArr = exp.toCharArray();
        boolean balanced = true;

        Stack<Character> s = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');


        char temp = ' ';
        for (char ele : charArr) {
            if (map.containsValue(ele))
                s.push(ele);
            else {
                try {
                    temp = s.pop();
                } catch (Exception e) {
                    balanced = false;
                }
                if (temp != map.get(ele))
                    balanced = false;
            }
        }

        if (balanced)
            System.out.print("Balanced");
        else
            System.out.print("Un balanced");
    }

    /**
     * Print sets of numbers from the list where sum of two adjacent numbers matches any number in the list
     * <p>
     * [1,5,2,6,3,4,9,10,2,6,15,8,21]
     * 2,6,8
     * 6,15,21
     */
    public void sumOfTwoNumsPresentInList(int[] arr) {
        List<Integer> input = new ArrayList<Integer>();
        for (int k = 0; k < arr.length; k++) {
            input.add(arr[k]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            int sum = first + second;

            if (input.contains(sum))
                System.out.println(first + " " + second + " " + sum);
        }
    }

	/**
	 * Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
	 * Input: a = amazon and b = azonam
	 */
    public void findOtherStringByRotatingTwice(String a, String b) {
        String modifiedB = "";

        if (a.length() != b.length())
            System.out.println("Not possible");

        else {
            List<Character> list = new ArrayList<Character>();

            for (int k = 0; k < b.length(); k++)
                list.add(b.charAt(k));


            for (int i = 0, j = list.size() - 1; i < 2; i++) {
                list.add(0, list.remove(j));
            }

            for (Character c : list)
                modifiedB = modifiedB + c;
        }

        if (a.equals(modifiedB))
            System.out.println("Same");
        else
            System.out.println("Not same");
    }

    //Method to print longest substring without repeating characters from the given string
    public static String findLongestSubstring(String str) {
        int i;
        int n = str.length();

        int st = 0; // Starting point of current substring.
        int currlen = 0; // length of current substring.
        int maxlen = 0; // maximum length substring without repeating characters.
        int start = 0; // starting index of maximum length substring.

        HashMap<Character, Integer> pos = new HashMap<Character, Integer>();
        pos.put(str.charAt(0), 0); // Last occurrence of first character is index 0;

        for (i = 1; i < n; i++) {
            // If this character is not present in hash, then this is first occurrence of this character, store this in hash.
            if (!pos.containsKey(str.charAt(i)))
                pos.put(str.charAt(i), i);

            else {
                // If this character is present in hash then this character has previous occurrence, check if that occurrence is before or after starting point of current substring.
                if (pos.get(str.charAt(i)) >= st) {
                    // find length of current substring and update maxlen and start accordingly.
                    currlen = i - st;
                    if (maxlen < currlen) {
                        maxlen = currlen;
                        start = st;
                    }

                    // Next substring will start after the last occurrence of current character to avoid its repetition.
                    st = pos.get(str.charAt(i)) + 1;
                }

                pos.replace(str.charAt(i), i); // Update last occurrence of current character.
            }
        }

        // Compare length of last substring with maxlen and update maxlen and start accordingly.
        if (maxlen < i - st) {
            maxlen = i - st;
            start = st;
        }

        // The required longest substring without repeating characters is from str[start] to str[start+maxlen-1].
        return str.substring(start, start + maxlen);
    }

    // Method to generate a random Alpha numeric string
    public String generateRandomAlphaNumericString(int length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            builder.append(index);
        }
        return builder.toString();
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * <p>
     * Example 2:
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * <p>
     * Algorithm:
     * - Iterate thorugh the array having strings.
     * - Take the first character in each string and compare whether they are equal.
     * - If they are all equal, then add the character to the result.
     * - If any of the strings characters is not equal to the rest of the strings character, then break the loop and return the result.
     */
    public String longestCommonPrefix(String[] strs) {
        int arrLen = strs.length;

        //Finding the length of the shortest string
        int lengthOfShortestString = strs[0].length();
        for (int i = 1; i < arrLen; i++) {
            int lenthOfString = strs[i].length();
            lengthOfShortestString = Math.min(lengthOfShortestString, lenthOfString);
        }

        System.out.println("Lenght of the shortest string is: " + lengthOfShortestString);
        String result = "";
        for (int i = 0; i < lengthOfShortestString; i++) {
            char firstStringChar = strs[0].charAt(i);
            for (int j = 1; j < arrLen; j++) {
                if (strs[j].charAt(i) != firstStringChar)
                    return result;
            }
            result = result + firstStringChar;
        }
        return result;
    }

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     * <p>
     * Example 1:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * <p>
     * Example 2:
     * Input: nums = []
     * Output: []
     * <p>
     * Example 3:
     * Input: nums = [0]
     * Output: []
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (binarySearch(nums, j + 1, n - 1, -(nums[i] + nums[j]))) {
                    List<Integer> t = new ArrayList<Integer>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(-(nums[i] + nums[j]));
                    ans.add(t);
                }
                while (j + 1 < n && nums[j + 1] == nums[j])
                    j++;
            }
            while (i + 1 < n && nums[i + 1] == nums[i])
                i++;
        }
        return ans;
    }

    /**
     * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * <p>
     * Example 1:
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * <p>
     * Example 2:
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     **/
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }

                if (sum <= target) j++;
                else k--;
            }
        }
        return result;
    }

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     * Return the answer in any order. A mapping of digit to letters (just like on the telephone buttons) is shown in "TelephoneKeypad.png" file.
     * Note that 1 does not map to any letters.
     * <p>
     * Example 1:
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * <p>
     * Example 2:
     * Input: digits = ""
     * Output: []
     * <p>
     * Example 3:
     * Input: digits = "2"
     * Output: ["a","b","c"]
     */
    public List<String> letterCombinations(String digits) {
        int digitsLength = digits.length();
        List<String> resultList = new ArrayList<String>();

        if (digitsLength == 0)
            return resultList;

        String temp = "";
        Map<Integer, String> phone = new HashMap<Integer, String>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < digitsLength; j++) {
                temp = temp + phone.get(Character.getNumericValue(digits.charAt(j))).charAt(i);
            }
        }
        return resultList;
    }

    // Method to print an array
    public void printArray(int[] arr) {
        System.out.print("Array values: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        returnValue = Integer.parseInt(stack.pop());
        return returnValue;
    }

    /**
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     * Example 1:
     * 1 -> 2 -> 3
     * |
     * 8 -> 9    4
     * |         |
     * 7 <- 6 <- 5
     * <p>
     * Input: n = 3
     * Output: [[1,2,3],[8,9,4],[7,6,5]]
     * Example 2:
     * <p>
     * Input: n = 1
     * Output: [[1]]
     */
    public static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (num <= n * n) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Traverse from right to left along the bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Traverse from bottom to top along the left column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        // Printing the Matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        return matrix;
    }

    // Method to print 2D matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    // Method to generate a 2D matrix
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            // direction 1 - traverse from left to right
            for (int ptr = layer; ptr < n - layer; ptr++) {
                result[layer][ptr] = cnt++;
            }
            // direction 2 - traverse from top to bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[ptr][n - layer - 1] = cnt++;
            }
            // direction 3 - traverse from right to left
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[n - layer - 1][n - ptr - 1] = cnt++;
            }
            // direction 4 - traverse from bottom to top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
                result[n - ptr - 1][layer] = cnt++;
            }
        }
        return result;
    }

	/**
	 * Search a 2D Matrix: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:
	 *    1) Integers in each row are sorted from left to right.
	 *    2) The first integer of each row is greater than the last integer of the previous row.
	 * For example, consider the following matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]]
	 * Given target = 3, return true.
	 * @param matrix
	 * @param target
	 * @return
	 */
    public boolean search2DMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;
            if (matrix[midX][midY] == target)
                return true;
            if (matrix[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    // Method to find duplicate characters in a string
    public void duplicateCharsInString(String str) {
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : charArray) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Method to convert xxxxxxxxxx to (xxx)xx-xx-xxx
    public void phoneNumberFormatter(String input) {
        System.out.println("(" + input.substring(0, 3) + ")" + input.substring(3, 5) + "-" + input.substring(5, 7) + "-"
                + input.substring(7));
    }

    // Method to convert J1a2v3a4 to jaavvvaaaa
    public void repeatCharsWithGivenNumbers(String input) {
        char[] charArray = input.toCharArray();
        String result = "";

        for (int i = 0; i < charArray.length; i = i + 2) {
            char currentChar = charArray[i];
            int j = Character.getNumericValue(charArray[i + 1]);
            for (int k = 0; k < j; k++)
                result = result + currentChar;
        }

        System.out.println("Final string is: " + result);
    }

    // Method to convert jaavvvaaaa to J1a2v3a4
    public void convertRepeatCharsToNumbers(String input) {
        String output = "";
        int count = 0;

        for (int i = 0; i < input.length(); i = i + count) {
            count = 0;
            output = output + input.charAt(i);
            for (int j = i; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j))
                    count++;
                else
                    break;
            }
            output = output + count;
        }

        System.out.println("Final converted string is " + output);
    }

    //Method to rotate a String right by 'k' times
    public String rotateStringRightByK(String str, int k) {
        return str.substring(str.length() - k) + str.substring(0, str.length() - k);
    }

    //Method to rotate a String left by 'k' times
    public String rotateStringLeftByK(String str, int k) {
        return str.substring(k) + str.substring(0, k);
    }

    // Method to count the uppercase, lowercase, special characters and numeric values. Example: jv_iow*&a34890@ R4GWIG@4WJ
    public static void countOfDifferentTypeOfChars(String str) {
        int upper = 0, lower = 0, number = 0, special = 0;
        char ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                upper++;
            else if (ch >= 'a' && ch <= 'z')
                lower++;
            else if (ch >= '0' && ch <= '9')
                number++;
            else
                special++;
        }

        System.out.println("Lower case letters : " + lower);
        System.out.println("Upper case letters : " + upper);
        System.out.println("Number : " + number);
        System.out.println("Special characters : " + special);
    }

    //Find the frequency of words in the given paragraph
    public void freqOfWordsInPara(String para) {
        String[] arr = para.split("([,.\\s]+)");
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1);

        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    /**
     * Word Break: Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * For example, given s = "leetcode", dict = ["leet", "code"]. Return true because "leetcode" can be segmented as "leet code".
     */
    public boolean wordBreakNaiveApproach(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if (start == s.length()) return true;

        for (String a : dict) {
            int len = a.length();
            int end = start + len;

            //end index should be <= string length
            if (end > s.length()) continue;

            if (s.substring(start, start + len).equals(a))
                if (wordBreakHelper(s, dict, start + len)) return true;
        }
        return false;
    }

    public boolean wordBreakRegularExpressionAppraoch(String s, Set<String> dict) {
        StringBuilder sb = new StringBuilder();

        for (String str : dict) sb.append(str).append("|");
        String pattern = sb.substring(0, sb.length() - 1);

        pattern = "(" + pattern + ")*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        //Printing the result
        System.out.println("Output: " + m.matches());
        return m.matches();
    }

    /**
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
     * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
     */
    public List<String> wordBreakII(String s, Set<String> dict) {
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null) continue;

            for (String word : dict) {
                int len = word.length();
                int end = i + len;

                if (end > s.length()) continue;

                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null)
                        dp[end] = new ArrayList<String>();
                    dp[end].add(word);
                }
            }
        }

        List<String> result = new LinkedList<String>();
        if (dp[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);

        return result;
    }

    public void dfs(List<String> dp[], int end, List<String> result, ArrayList<String> tmp) {
        if (end <= 0) {
            String path = tmp.get(tmp.size() - 1);
            for (int i = tmp.size() - 2; i >= 0; i--)
                path += " " + tmp.get(i);

            result.add(path);
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

	/**
	 * Valid Parentheses: Given a string containing just the characters ’(’, ’)’, ’’, ’’, ’[’ and ’]’, determine if the
	 * input string is valid. The brackets must close in the correct order, "()" and "()[]" are all valid but "(]" and "([)]" are not.
 	 */
    public static boolean isValidParantheses(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        for (Character c : charArray) {
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
	 *  Spiral Matrix: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	 *  For example, given the following matrix:
     *       [
     *       [ 1, 2, 3 ],
     *       [ 4, 5, 6 ],
     *       [ 7, 8, 9 ]
     *       ]
     * You should return [1,2,3,6,9,8,7,4,5].
    */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while (m > 0 && n > 0) {
            //if one row/column left, no circle can be formed
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }
            //below, process a circle
            //top - move right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }
            //right - move down
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x++][y]);
            }
            //bottom - move left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }
            //left - move up
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }
        return result;
    }

    public static void main(String[] args) {
		Object arr2[] = {1, 2, 1, 2, 1, 2, 3, "Hello", "World", "Hello"};
		int arr[] = {100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89};
        int arr3[] = {100, 14, 46, 47, 94, 52, 86, 36, 89};
        int arr4[] = {1, -1, 1, -1, 1, 1, 1, -1, -1, 1, -1};
        int arr5[] = {-45, -18, -614, -44, -73, 0, 1, 2, 3, 25, 41, 6, 486};
        int arr6[] = {55, 23, 32, 46, 88};
        int arr7[] = {10, 90, 49, 2, 1, 5, 23};
        int arr8[] = {4, 39, 6, 29, 8};
		String[] strs = {"flower", "flow", "flight"};

		String s1 = "goalspecial";
		String s2 = "catsanddog";
        String para = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
                + "when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into "
                + "electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, "
                + "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        LinkedList<Object> l = new LinkedList<Object>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        List<String> l2 = Stream.of("mobile", "mouse", "moneypot", "monitor", "mousepad").collect(Collectors.toList());
        List<Integer> l3 = List.of(1, -1, -1, -1, 1, 1, 1, 1);
        List<Integer> l4 = new ArrayList<Integer>(Arrays.asList(1, -1, -1, 1, 1, 1, 1));
        List<Integer> l5 = new ArrayList<Integer>(Arrays.asList(19, -1, 37, 99, 1, 0, 56));
        List<Integer> l6 = new ArrayList<Integer>() {
            {
                add(19);
                add(-1);
                add(3);
                add(69);
                add(1);
                add(889);
                add(26);
            }
        };

        HashSet<String> stringDict = new HashSet<String>();
        stringDict.add("go");
        stringDict.add("goal");
        stringDict.add("goals");
        stringDict.add("special");

        HashSet<String> stringDict2 = new HashSet<String>();
        stringDict.add("cat");
        stringDict.add("cats");
        stringDict.add("and");
        stringDict.add("sand");
        stringDict.add("dog");

		// Test code and method calling goes here
        UltimateJavaCoding UC = new UltimateJavaCoding();
    }
}

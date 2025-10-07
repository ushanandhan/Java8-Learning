package com.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

    @Test
    public void BinarySearchTest() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.printf("Binary Search value of 6 : %d%n",binarySearch(nums,6));
        System.out.printf("Binary Search value of 8 : %d%n", binarySearch(nums, 8));
    }

    //Best Case O(log n) Iteration
    //Worse Case O(1)
    int binarySearch(int[] nums, int item) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int guess;
        while (low <= high) {
            mid = (low + high) / 2;
            guess = nums[mid];
            if (guess == item) return mid;
            if (guess > item) return mid - 1;
            else low = mid + 1;
        }
        return 0;
    }

    @Test
    public void LinearSearchToFindIndexes() {
        int[] nums = {45, 12, 78, 56, 15, 45, 12};
        System.out.printf("The indexes of the given item %d, is %s", 45, linearSearch(nums, 45));
    }

    //Best Case O(1) Iteration
    //Worse Case O(n)
    String linearSearch(int[] nums, int item) {
        boolean valuesInArray = false;
        StringBuilder indexsWithValue = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == item) {
                valuesInArray = true;
                indexsWithValue.append(i).append(", ");
            }
        }
        if (!valuesInArray) {
            indexsWithValue.append("NONE");
        }
        return indexsWithValue.toString();
    }


    @Test
    public void SelectionSort() {
        int[] nums = {12, 85, 45, 97, 36, 52, 71, 55};

        System.out.println("Original array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        selectionSort(nums);

        System.out.println("\nSorted array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //Best Case O(n^2) Iteration
    //Worse Case O(n)
    void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    @Test
    public void FactorialWithRecursion() {
        int number = 5;  // Change this value to calculate factorial for a different number
        int result = factorial(number);

        System.out.println("Factorial of " + number + " is: " + result);
    }

    public int factorial(int n) {
        System.out.println("Calling factorial(" + n + ")");
        if (n == 0) {
            System.out.println("Returning 1");
            return 1;
        } else {
            int result = n * factorial(n - 1);
            System.out.println("Returning " + result + " for factorial(" + n + ")");
            return result;
        }
    }

    @Test
    public void QuickSort() {
        int[] arr = {12, 85, 45, 97, 36, 52, 71, 55};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(nums, low, high);

            // Recursively sort elements before and after partition
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    @Test
    public void test() {
        String constant = "ABDX";

        // Example lists (could be any number of lists)
        List<String> list1 = List.of("1", "2", "3");
        List<String> list2 = List.of("A", "B", "C");
        List<String> list3 = List.of("!", "@", "#");

        // Collect all available lists
        List<List<String>> allLists = new ArrayList<>();
        allLists.add(list1);
        allLists.add(list2);
        allLists.add(list3);

        // Get the combined results
        List<String> results = combineRecursively(constant, allLists);

        System.out.println(results);
        // Output: [ABDX1A!, ABDX2B@, ABDX3C#]

        List<List<String>> allLists1 = new ArrayList<>();
        allLists1.add(list1);


        // Get the combined results
        List<String> results1 = combineRecursively(constant, allLists1);
        System.out.println(results1);
    }

    public static List<String> combineRecursively(String constant, List<List<String>> lists) {
        List<String> results = new ArrayList<>();

        // Base case: if no lists, just return the constant
        if (lists.isEmpty()) {
            results.add(constant);
            return results;
        }

        // Verify all lists have the same size
        int size = lists.get(0).size();
        for (List<String> list : lists) {
            if (list.size() != size) {
                throw new IllegalArgumentException("All lists must be the same size");
            }
        }

        // Process each index
        for (int i = 0; i < size; i++) {
            // Start building the combined string for this index
            StringBuilder combined = new StringBuilder(constant);

            // For each list, append the element at current index
            for (List<String> list : lists) {
                combined.append(list.get(i));
            }

            results.add(combined.toString());
        }

        return results;
    }
}



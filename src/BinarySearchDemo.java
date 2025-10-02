import java.util.Arrays;

public class BinarySearchDemo {

    // Binary search implementation
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary search steps: " + steps);
                return mid;  // found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Binary search steps: " + steps);
        return -1;  // not found
    }

    // Linear search implementation
    public static int linearSearch(int[] arr, int target) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                System.out.println("Linear search steps: " + steps);
                return i;
            }
        }
        System.out.println("Linear search steps: " + steps);
        return -1;
    }

    // Main method
    public static void main(String[] args) {
        int[] sortedArray = new int[20];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i * 2;  // 0, 2, 4, 6, ..., 38
        }

        int targetPresent = 14;
        int targetAbsent = 15;

        System.out.println("Binary Search for present: " + binarySearch(sortedArray, targetPresent));
        System.out.println("Binary Search for absent: " + binarySearch(sortedArray, targetAbsent));

        System.out.println("Linear Search for present: " + linearSearch(sortedArray, targetPresent));
        System.out.println("Linear Search for absent: " + linearSearch(sortedArray, targetAbsent));
    }
}

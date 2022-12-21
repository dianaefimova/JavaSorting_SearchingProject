import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Searching_Sorting {
    public static void binarySearch(int[] arr, int first, int last, int key2) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key2) {
                first = mid + 1;
            } else if (arr[mid] == key2) {
                System.out.println("Found\n");
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Not found\n");
        }
    }
    public static int search(int[] arr, int key1)
    {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == key1)
                return i;
        }
        return -1;
    }
    public static void Sort1(int[] arr)
    {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j-1;
            while ( (i > -1) && (arr [i] > key ) ) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void Sort2(int[] arr, int low, int high)
    {
        if (low < high) {

            int pi = partition(arr, low, high);

            Sort2(arr, low, pi - 1);
            Sort2(arr, pi + 1, high);
        }
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random r = new Random();
        int[] integers = new int[10];
        for (int i = 0;  i < integers.length; i++) {
            integers[i] = r.nextInt(100 + 100) - 100;
        }
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int last = arr.length - 1;
        char choice =0 ;

        while ((choice != 'Q') && (choice != 'q')) {

            System.out.println("Menu of Searching and Sorting Testbed.");
            System.out.println();
            System.out.println("1) Linear Searching");
            System.out.println("2) Binary Searching");
            System.out.println("3) O(n^2) type of Sorting");
            System.out.println("4) O(n*log(n)) type of Sorting");
            System.out.println("q/Q) Quit\n");
            System.out.println("Your choice: ");

            choice = reader.next().charAt(0);


            switch (choice) {
                case '1':
                    System.out.print("In the list are values 0, ...,9; which value would you like to search with binary search?\n ");
                    int key1 = reader.nextInt();
                    int result = search(arr, key1);
                    if (result == -1)
                        System.out.println("Not found \n");

                    else
                        System.out.println("Found \n");
                    break;

                case '2':
                    System.out.print("In the list are values 0, ...,9; which value would you like to search with binary search?\n ");
                    int key2 = reader.nextInt();
                    binarySearch(arr, 0, last, key2);
                    System.out.println("\n");
                    break;

                case '3':
                    System.out.println("Data set before insertion sorting:");
                    System.out.println(Arrays.toString(integers));
                    System.out.println("\n");
                    Sort1(integers);
                    System.out.println("Data set after insertion sorting:");
                    System.out.print(Arrays.toString(integers));
                    System.out.println("\n");
                    break;

                case '4':
                    int n = integers.length;
                    System.out.println("Data set before quicksort: ");
                    System.out.println(Arrays.toString(integers));
                    System.out.println("\n");
                    Sort2(integers, 0, n - 1);
                    System.out.println("Data set after quicksort: ");
                    System.out.println(Arrays.toString(integers));
                    System.out.println("\n");
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Thank you for participation!\n");
                    break;

                default:
                    System.out.println("Wrong input. Try again: put a number between 1-4 or Q/q to quit\n");
            }


        }


    }
}




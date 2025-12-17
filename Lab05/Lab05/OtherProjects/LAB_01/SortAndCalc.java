package OtherProjects.LAB_01;

import java.util.Scanner;

public class SortAndCalc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int array[] = new int[10000];
        int n = 0;

        System.out.print("Enter number of elements: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            System.out.print("Enter " + (i+1) + "th element: ");
            array[i] = scanner.nextInt();
        }

        // Sort array
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }

        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += array[i];
        }
        double avg = (double) sum / n;
        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + avg);

        scanner.close();
    }
}

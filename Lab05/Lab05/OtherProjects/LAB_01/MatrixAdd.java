package OtherProjects.LAB_01;

import java.util.Scanner;

public class MatrixAdd {
    public static void main(String[] args){
        int matA[][] = new int[10][10];
        int matB[][] = new int[10][10];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int c = scanner.nextInt();

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                System.out.print("A[" + (i+1) + "][" + (j+1) + "] = ");
                matA[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                System.out.print("B[" + (i+1) + "][" + (j+1) + "] = ");
                matB[i][j] = scanner.nextInt();
            }
        }

        System.out.println("A + B =");
        for (int i = 0; i < r; i++){
            System.out.print("| ");
            for (int j = 0; j < c; j++){
                System.out.print((matA[i][j] + matB[i][j]) + " ");
            }
            System.out.print("|\n");
        }

        scanner.close();
    }
}

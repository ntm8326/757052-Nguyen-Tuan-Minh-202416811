package OtherProjects.LAB_01;

import java.util.Scanner;

public class MatrixMultiply {
    public static void main(String[] args){
        int matA[][] = new int[10][10];
        int matB[][] = new int[10][10];
        int matRes[][] = new int[10][10];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows for A: ");
        int rA = scanner.nextInt();
        System.out.print("Enter number of columns for A / rows for B: ");
        int cA_rB = scanner.nextInt();
        System.out.print("Enter number of columns for B: ");
        int cB = scanner.nextInt();

        for (int i = 0; i < rA; i++){
            for (int j = 0; j < cA_rB; j++){
                System.out.print("A[" + (i+1) + "][" + (j+1) + "] = ");
                matA[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < cA_rB; i++){
            for (int j = 0; j < cB; j++){
                System.out.print("B[" + (i+1) + "][" + (j+1) + "] = ");
                matB[i][j] = scanner.nextInt();
            }
        }

        System.out.println("A * B =");
        for (int i = 0; i < rA; i++){
            System.out.print("| ");
            for (int j = 0; j < cB; j++){
                matRes[i][j] = 0;
                for (int k = 0; k < cA_rB; k++){
                    matRes[i][j] += matA[i][k] * matB[k][j];
                }
                System.out.print(matRes[i][j] + " ");
            }
            System.out.print("|\n");
        }

        scanner.close();
    }
}

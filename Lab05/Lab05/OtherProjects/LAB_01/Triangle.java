package OtherProjects.LAB_01;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.print("Enter triangle height: ");
        a = scanner.nextInt();
        int width = a*2 - 1;
        for (int i = 1; i <= width; i += 2){
            for (int j = 1; j <= width; j++){
                if (j <= (width - i)/2 || j > (width + i)/2){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
        }
        scanner.close();
    }



}

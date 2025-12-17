package OtherProjects.LAB_01;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name?\n");
        String name = scanner.nextLine();

        System.out.print("How old are you?\n");
        int age = scanner.nextInt();

        System.out.print("How tall are you (m)?\n");
        double height = scanner.nextDouble();

        System.out.println("Hello " + name + ", you are " + age + " years old and " + height + "m tall.");

        scanner.close();
    }
}

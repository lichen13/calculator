import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static String useSymbol = "";
    static Integer number1 = 0;
    static Integer number2 = 0;

    public static void exitCalculator() {
        System.out.println("\nClosing the calculator, have a nice day.\n");
        System.exit(0);
    }

    public static void doOperation() {
        Scanner scanner = new Scanner(System.in);
        Integer answer = 0;

        System.out.println("\nPlease enter two numbers for your operation:");

        try {
            System.out.print("[Number 1]: ");
            number1 = scanner.nextInt();
            System.out.print("[Number 2]: ");
            number2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nError - InputMismatchException.");
            return;
        }

        System.out.println("Start of calculations...");

        if (useSymbol.equals("+")) {
            answer = number1 + number2;
        } else if (useSymbol.equals("-")) {
            answer = number1 - number2;
        } else if (useSymbol.equals("*")) {
            answer = number1 * number2;
        } else if (useSymbol.equals("/")) {
            answer = number1 / number2;
        }

        System.out.println("The correct answer for this operation is: " + answer);
    }

    public static void signSelector() {
        Scanner scanner = new Scanner(System.in);

        String signMenu = """
        \n=== [ S Y M B O L S] ===
        Please select a valid symbol below for your operation:
        + ........................ Addition.
        - ........................ Subtraction.
        * ........................ Multiplication.
        / ........................ Division.""";

        System.out.println(signMenu);
        System.out.print("[?]: ");

        String optionTaken = scanner.next();

        if (optionTaken.equals("+")) {
            useSymbol = "+";
            doOperation();
        } else if (optionTaken.equals("-")) {
            useSymbol = "-";
            doOperation();
        } else if (optionTaken.equals("*")) {
            useSymbol = "*";
            doOperation();
        } else if (optionTaken.equals("/")) {
            useSymbol = "/";
            doOperation();
        } else {
            System.out.println("\nError - invalidOption: Your selected option is invalid.");
            useSymbol = "";
        }
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        String menu = """
        \n=== [ M E N U ] ===
        exit ..................... End this process.
        start .................... Start an operation.

        NOTE:
            - If a number is too large, it might overflow and give wrong answers. Numbers must be integers!""";

        System.out.println(menu);
        System.out.print("[?]: ");

        String optionTaken = scanner.next();

        if (optionTaken.equals("exit")) {
            exitCalculator();
        } else if (optionTaken.equals("start")) {
            signSelector();
        }
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
        }
    }
}






import java.util.Scanner;

public class Main {

    public static void displayError(String errorName) {
        switch (errorName) {
            case "badOption":
                System.out.println("\nERROR - badOption: Wrong option please try again.");
                return;
            
            case "threadError":
                System.out.println("\nERROR - threadError: Thread stopped. Cannot continue.");
                return;

            case "lineOutOfBound":
                System.out.println("\nERROR - lineOutOfBound: The line must contain 3 arguments.");
                return;
        }
        // WILL BE THE ERROR HANDLER
    }


    public static void displayMenu() {
        String menuMessage = """
        \n==={M E N U}===
        exit ............... Exit the program.
        bio ................ Display the biography.
        help ............... Display help.
        start .............. Start the calculator.""";

        Scanner scanner = new Scanner(System.in);

        System.out.println(menuMessage);
        System.out.print("[?] : ");

        String optionTaken = scanner.next();

        if (optionTaken.equals("exit")) {
            exitSystem();

        } else if (optionTaken.equals("help")) {
            displayHelp();

        } else if (optionTaken.equals("bio")) {
            displayBio();

        } else if (optionTaken.equals("start")) {
            startCalculator();

        } else {
            try {
                displayError("badOption");
                Thread.sleep(3000);

            } catch (InterruptedException e1) {
                displayError("threadError");
                System.exit(1);

            }
        }
    }


    public static void startCalculator() {
        int firstArg = 0;
        int thirdArg = 0;
        String secondArg = "";

        String startMessage = """
        \n==={R E A D Y  T O  C A L C U L A T E}===
        IMPORTANT: - If it is your first time, please read the 'help' section.
                   - Spaces are required between arguments.
                   - Maximum and minimum of 3 arguments are required.""";
        

        Scanner scanner = new Scanner(System.in);

        System.out.println(startMessage);
        System.out.print("\n[Line Field] : ");

        String line = scanner.nextLine();

        String[] lineParts = line.split(" ");

        if (lineParts.length == 3) {
            try {
                firstArg = Integer.parseInt(lineParts[0]);

            } catch (NumberFormatException e1) {
                try {
                    System.out.println("\nERROR - syntaxError: First argument must be a number (Integer).");
                    Thread.sleep(3000);
                
                } catch (InterruptedException e2) {
                    displayError("threadError");
                    System.exit(1);

                }
            }

            try {
                int isSecArgInt = Integer.parseInt(lineParts[1]);

            } catch (NumberFormatException e1) {
                switch (lineParts[1]) {
                    case "+":
                        secondArg = "+";
                        break;
                    
                    case "-":
                        secondArg = "-";
                        break;

                    case "*":
                        secondArg = "*";
                        break;

                    case "/":
                        secondArg = "/";

                    default:
                        try {
                            System.out.println("\nERROR - syntaxError: Second argument must be an operation sign ('+', '-', '*', '/').");
                            Thread.sleep(3000);

                        } catch (InterruptedException e2) {
                            displayError("threadError");

                        }
                        break;
                } 
            }

            try {
                thirdArg = Integer.parseInt(lineParts[2]);

            } catch (NumberFormatException e1) {
                try {
                    System.out.println("\nERROR - syntaxError: Third argument must be a number (Integer).");
                    Thread.sleep(3000);
                
                } catch (InterruptedException e2) {
                    displayError("threadError");
                    System.exit(1);

                }
            }

            switch (secondArg) {
                case "+":
                    System.out.println("\nAnswer is : " + (firstArg + thirdArg));
                    break;

                case "-":
                    System.out.println("\nAnswer is : " + (firstArg - thirdArg));
                    break;

                case "*":
                    System.out.println("\nAnswer is : " + (firstArg * thirdArg));
                    break;

                case "/":
                    System.out.println("\nAnswer is : " + (firstArg / thirdArg));
                    break;
            }

        } else {
            try {
                displayError("lineOutOfBound");
                Thread.sleep(3000);

            } catch (InterruptedException e1) {
                displayError("threadError");
                System.exit(1);

            }
        }
    }


    public static void exitSystem() {
        System.out.println("\nExiting system with ERROR STATUS 0. Have a good day.\n");
        System.exit(0);
    }


    public static void displayHelp() {
        String helpMessage = """
        \n==={H E L P}===
        VERSION: Beta
        USAGE: <arg1> <arg2> <arg3>
             - arg1 => First number.
             - arg2 => Operation sign.
             - arg3 => Second number.
        OPERATION SIGNS:
             - '+' => Addition.
             - '-' => Soustraction.
             - '*' => Multiplication.
             - '/' => Division.
        IMPORTANT:
             - Spaces between arguments are required.
             - x2 numbers / Integers are required.
             - x1 operation sign is required.
             - Maximum of 3 arguments are accepted.
        EXAMPLES:
            1) 1 + 1 => Answer will be 2.
            2) 2 - 1 => Answer will be 1.
            3) 2 * 2 => Answer will be 4.
            4) 10 / 2 => Answer will be 5.
            
        Type 'back' to come back to menu.""";

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println(helpMessage);
            System.out.print("[?] : ");
            
            String optionTaken = scanner.next();

            if (optionTaken.equals("back")) {
                return;

            } else {
                try {
                    displayError("badOption");
                    Thread.sleep(3000);

                } catch (InterruptedException e1) {
                    displayError("threadError");
                    System.exit(1);

                }
            }
        }

        // WILL DISPLAY THE HELP
    }


    public static void displayBio() {
        String bioMessage = """
        \n==={B I O G R A P H Y}===
        [!]: Oobs, seems like the biography is empty for now...
        Type 'back' to come back to menu.""";

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println(bioMessage);
            System.out.print("[?] : ");

            String optionTaken = scanner.next();

            if (optionTaken.equals("back")) {
                return;

            } else {
                try {
                    displayError("badOption");
                    Thread.sleep(3000);
                    
                } catch (InterruptedException e1) {
                    displayError("threadError");
                    System.exit(1);

                }
            }
        }
    }
    
    
    // ##############################################
    public static void main(String[] args) {
        while (true) { 
            displayMenu();
        }
        // MAIN FUNCTION
    }
}

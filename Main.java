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
        }
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

        // WILL DISPLAY THE BIOGRAPHY
    }
    
    
    // ##############################################
    public static void main(String[] args) {
        while (true) { 
            displayMenu();
        }
        // MAIN FUNCTION
    }
}

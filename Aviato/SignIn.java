import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SignIn {

    //keeps track of users
    private Set<User> users = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int selection = 0;
        System.out.println(Prompts.WELCOME);

        System.out.println(Prompts.PROMPT_SIGN_IN_OR_CREATE);
        System.out.println("\t1. " + Prompts.SIGN_IN);
        System.out.println("\t2. " + Prompts.CREATE_ACCOUNT);
        String entry = in.nextLine();
        if (canBeParsedToInt(entry)) {
            selection = Integer.parseInt(entry);
        }
        System.out.println();
        handleInitialRequest(selection, in);


    }

    public static void handleInitialRequest(int selection, Scanner in) {
        switch (selection) {
            case 1: //create an account
                System.out.println("Are you a community member or employee (Enter 1 or 2)?");
                System.out.print("\t1. " + "Community Member");
                System.out.print("\t2. " + " Employee");
                String entry = in.nextLine();
                if (canBeParsedToInt(entry)) {
                    int employeeOrMember = Integer.parseInt(entry);
                }
            case 2:
                System.out.println("Enter your username: ");
                String usernameCandidate = in.nextLine();
                System.out.println("Enter your password: ");
                String passwordCandidate = in.nextLine();

        }
    }

    public static User handleAccountCreation(int employeeOrMember, Scanner in) {
        User u = new User();
        switch (employeeOrMember) {
            case 1:
                System.out.print("Welcome! Enter your username.");
                u.setUsername(in.nextLine());
                System.out.print("Enter your password: ");
                u.setPassword(in.nextLine());
                return u;
            case 2:
                System.out.print("Welcome! Enter your employee ID: ");
                u.setEmployee(in.nextInt());
                if (u.isEmployee) {
                    System.out.print("Enter your username: ");
                    u.setUsername(in.nextLine());
                    System.out.print("Enter your password: ");
                    u.setPassword(in.nextLine());
                }
        }

        return u;
    }


    public static boolean canBeParsedToInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    static Map<Integer, Drone> drones = new HashMap<>();

    public static final String separator = "==============";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Aviato! Enter 0 at any time to quit.");
        System.out.print("Are you an employee (1) or community member (2)? ");
        int selection = in.nextInt();
        in.nextLine();
        System.out.println(separator);
        boolean quit_not_entered = true;
        while (quit_not_entered && selection == 1) {
            System.out.println("Welcome employee!");
            System.out.println(separator);
            int empSelection = displayEmployeeMenu(in);
            in.nextLine();

            if (empSelection == 0) { // 0 is a quit
                quit_not_entered = false;
                System.out.println("Goodbye!");
            } else if (empSelection == 1) { // 1 is creation of a new drone
                System.out.println("You selected to create a new drone.");
                Drone d = new Drone();
                setDroneInfo(d, in);
                System.out.println("Name: " + d.name);
                System.out.println("Year: " + d.year);
                System.out.println("Serial number: " + d.serialNumber);
                System.out.println("Status: " + d.status);
                System.out.println("Drone successfully added!");
                System.out.println();
            } else if (empSelection == 2) { // 2 is delete
                System.out.print("Enter the serial number of the drone you'd like to delete: ");
                int deleteCandidate = in.nextInt();
                in.nextLine();
                if (drones.containsKey(deleteCandidate)) {
                    drones.remove(deleteCandidate);
                    System.out.println("Drone deleted successfully.");
                } else {
                    System.out.println("Cannot find drone with serial number: " + deleteCandidate);
                }

            } else if (empSelection == 3) { // 3 is edit
                System.out.print("Enter the serial number of the drone you'd like to edit: ");
                int viewCandidate = in.nextInt();
                in.nextLine();
                if (drones.containsKey(viewCandidate)) {
                    Drone requested = drones.get(viewCandidate);
                    drones.remove(viewCandidate);
                    setDroneInfo(requested, in);
                    System.out.println("Drone info edited successfully");
                } else {
                    System.out.println("Drone not found");
                }
            } else if (empSelection == 4) { // 4 is display all
                int i = 1;
                for (Map.Entry<Integer, Drone> dr : drones.entrySet()) {
                    System.out.println("Drone " + i + ": " + dr.getValue().serialNumber);
                    i++;
                }
                // TODO: add 5
            }


        }
            while (quit_not_entered && selection == 2) {
                System.out.println("Welcome community member!");
                System.out.println(separator);
                while (selection != 0) {
                    selection = displayClientMenu(in);
                    System.out.println(separator);
                }

            }



    }

    /**
     * Sets a given drones information and prompts user for that info.
     * @param d Drone being created or edited
     * @param in
     */
    public static void setDroneInfo(Drone d, Scanner in) {
        System.out.print("Enter drone name: ");
        String name = in.nextLine();
        d.setName(name);

        // TODO: add parameter validation
        System.out.print("Enter model number: ");
        int mNum = in.nextInt();
        in.nextLine();
        d.setModelNumber(mNum);
        System.out.print("Enter the build year: ");
        int year = in.nextInt();
        in.nextLine();
        d.setYear(year);
        System.out.print("Enter the serial number: ");
        int serNum = in.nextInt();
        in.nextLine();
        d.setSerialNumber(serNum);
        System.out.print("Enter drone status: ");
        String status = in.nextLine();
        d.setStatus(status);

        drones.put(serNum, d);
    }

    /**
     * Employee menu
     * @param in
     * @return user's selection
     */
    public static int displayEmployeeMenu(Scanner in) {
        System.out.println("DRONES");
        System.out.println("\t1. Add new drone");
        System.out.println("\t2. Delete a drone");
        System.out.println("\t3. Edit a drone");
        System.out.println("\t4. View all drones");
        System.out.println("\t5. View active drones");
        System.out.println(separator);
        System.out.println("USERS");
        System.out.println("\t6. View users");
        System.out.println("\t7. Get a user's information");
        System.out.println("\t8. Delete a user");
        System.out.println(separator);
        System.out.println("EQUIPMENT");
        System.out.println("\t9. Add new equipment");
        System.out.println("\t10. Delete equipment");
        System.out.println("\t11. Edit Equipment");
        System.out.println(separator);
        System.out.println("GENERAL");
        System.out.println("\t12. View active deliveries");
        System.out.println("\t13. View pending orders");
        System.out.println("\t14. View recently completed deliveries");
        System.out.println("\t15. Generate Drones Report");


        System.out.print("Enter selection: ");
        return in.nextInt();
    }

    /**
     * Generates a report for each drone
     */
    public static void generateReport() {
        System.out.println("Generating Drones Report...");
        System.out.println(separator);
        if (drones.isEmpty()) {
            System.out.println("No drones to display.");
        } else {
            for (Drone d : drones.values()) {
                System.out.println("Name: " + d.name);
                System.out.println("Model Number: " + d.modelNumber);
                System.out.println("Year: " + d.year);
                System.out.println("Serial Number: " + d.serialNumber);
                System.out.println("Status: " + d.status);
                System.out.println(separator);
            }
        }
    }


    /**
     * Selections for clients
     * @param in
     * @return the client's selection
     */
    public static int displayClientMenu(Scanner in) {
        System.out.println("\t1. Select Rental Equipment");
        System.out.println("\t2. Return Equipment");
        System.out.println("\t3. Schedule drone delivery");
        System.out.println("\t4. Schedule equipment pickup");
        System.out.print("Enter selection: ");
        int selection = in.nextInt();
        in.nextLine();
        return selection;
    }

    // TODO: fill out method

    /**
     * Displays the categories of items to rent (get more specific in later impl)
     * @param in
     * @return user selection
     */
    public static int displayRentMenu(Scanner in) {
        System.out.println("\t\t1. Home improvement");
        System.out.println("\t\t2. Technology");
        System.out.print("Enter selection: ");
        int selection = in.nextInt();
        in.nextLine();
        return selection;
    }

    // TODO: fill out method
    public static int displayReturnMenu(Scanner in) {
        return 0;
    }

}

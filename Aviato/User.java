import java.util.HashMap;
import java.util.Map;

public class User {
    public String username;
    private String password;
    public boolean isEmployee = false;
    Map<Integer, String> employees = new HashMap<>();
    Map<String, String> namesToPass = new HashMap<>();
    Map<Integer, Map<String, String>> allUsers = new HashMap<>();

    public void setPassword(String pass) {
        password = pass;
        System.out.println("Username set successfully");
    }

    public void setUsername(String name) {
        if (namesToPass.containsKey(name)) {
            username = name;
        }
        System.out.println("Password set successfully.");
    }

    public void setEmployee(int employeeId) {
        if (employees.containsKey(employeeId)) {
            System.out.println("Employee " + employees.get(employeeId) + " found in database.");
            System.out.println("Employee permissions granted.");
            isEmployee = true;
        } else {
            System.out.println("Employee not found. Access denied");
        }
    }

    public boolean signIn(String username, String password) {
        if (namesToPass.containsKey(username)) {
            String actualPassword = namesToPass.get(username);
            return password.equals(actualPassword);
        }
        return false;
    }
}

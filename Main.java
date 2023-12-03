import java.util.Scanner;
import java.util.Random;

class Employee {
    String firstName, lastName, department;
    
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class CreateCreds{
    public static String generateEmailAddress(Employee employee, String department) {
        return employee.firstName.toLowerCase() + employee.lastName.toLowerCase() + "@" + department + ".abc.com";
    }

    public static String generatePassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'<>,.?/";

        String allCharacters = capitalLetters + smallLetters + numbers + specialCharacters;

        Random obj = new Random();
        StringBuilder password = new StringBuilder();
        password.append(numbers.charAt(obj.nextInt(numbers.length())));
        password.append(capitalLetters.charAt(obj.nextInt(capitalLetters.length())));
        password.append(smallLetters.charAt(obj.nextInt(smallLetters.length())));
        password.append(specialCharacters.charAt(obj.nextInt(specialCharacters.length())));

        for (int i = 4; i < 10; i++) {
            password.append(allCharacters.charAt(obj.nextInt(allCharacters.length())));
        }
        return password.toString();
    }

    public static void showCredentials(Employee employee, String department, String email, String password) {
        System.out.println("\nDear " + employee.firstName + ", your generated credentials are as follows :");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Shyam_OOPs_Lab1");
        System.out.println("Please enter the department from the following");
        System.out.println("1. Technical\n2. Admin\n3. Human Resource\n4. Legal");
        int departmentChoice = scanner.nextInt();

        String department;
        switch (departmentChoice) {
            case 1:
                department = "tech";
                break;
            case 2:
                department = "admin";
                break;
            case 3:
                department = "hr";
                break;
            case 4:
                department = "legal";
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
                
        }

        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        Employee employee = new Employee(firstName, lastName);
        String email = CreateCreds.generateEmailAddress(employee, department);
        String password = CreateCreds.generatePassword();

        CreateCreds.showCredentials(employee, department, email, password);
        scanner.close();
    }
}
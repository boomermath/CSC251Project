import java.util.Scanner;

public class Project_Rikhil_Chilka {

    public static void main(String[] args) {
        // Create a scanner object to capture user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter necessary policy information
        System.out.print("Please enter the Policy Number: ");
        int policyNumber = input.nextInt();
        input.nextLine();  // Consume newline

        System.out.print("Please enter the Provider Name: ");
        String providerName = input.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = input.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = input.nextInt();
        input.nextLine();  // Consume newline

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = input.nextLine();
        boolean isSmoker = smokingStatus.equalsIgnoreCase("smoker");

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weight = input.nextDouble();

        // Create a Policy object using the constructor that accepts arguments
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, isSmoker, height, weight);

        // Display the policy information
        System.out.println();  // Print a blank line
        System.out.println("Policy Number: " + policy.getNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + (policy.isSmoker() ? "smoker" : "non-smoker"));
        System.out.println("Policyholder’s Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + policy.getWeight() + " pounds");
        System.out.printf("Policyholder’s BMI: %.2f%n", policy.calculateBmi());
        System.out.printf("Policy Price: $%.2f%n", policy.policyInsurancePrice());

        // Close the scanner
        input.close();
    }
}

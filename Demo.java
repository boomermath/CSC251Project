import java.io.File;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        // Create a scanner object to capture user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter necessary policy information
        int policyNumber = input.nextInt();
        input.nextLine();  // Consume newline

        String providerName = input.nextLine();

        String firstName = input.nextLine();

        String lastName = input.nextLine();

        int age = input.nextInt();
        input.nextLine();  // Consume newline

        String smokingStatus = input.nextLine();
        boolean isSmoker = smokingStatus.equalsIgnoreCase("smoker");

        double height = input.nextDouble();

        double weight = input.nextDouble();

        // Create a Policy object using the constructor that accepts arguments
        InsurancePolicy insurancePolicy = new InsurancePolicy(policyNumber, providerName, firstName, lastName, age, isSmoker, height, weight);

        // Display the policy information
        System.out.println();  // Print a blank line
        System.out.println("Policy Number: " + insurancePolicy.getPolicyNumber());
        System.out.println("Provider Name: " + insurancePolicy.getProvider());
        System.out.println("Policyholder’s First Name: " + insurancePolicy.getHolderFirstName());
        System.out.println("Policyholder’s Last Name: " + insurancePolicy.getHolderLastName());
        System.out.println("Policyholder’s Age: " + insurancePolicy.getHolderAge());
        System.out.println("Policyholder’s Smoking Status: " + (insurancePolicy.getIsSmoker() ? "smoker" : "non-smoker"));
        System.out.println("Policyholder’s Height: " + insurancePolicy.getHolderHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + insurancePolicy.getHolderWeight() + " pounds");
        System.out.printf("Policyholder’s BMI: %.2f%n", insurancePolicy.calculateBmi());
        System.out.printf("Policy Price: $%.2f%n", insurancePolicy.calculatePolicyCost());

        // Close the scanner
        input.close();
    }
}

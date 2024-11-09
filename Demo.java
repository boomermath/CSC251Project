import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner object to capture user input
        File file = new File("PolicyInformation.txt");
        Scanner input = new Scanner(file);

        int policyNumber = input.nextInt();
        input.nextLine();  // Consume newline

        String providerName = input.nextLine();
        Policy policy = new Policy(policyNumber, providerName);
        
        int smokers = 0;
        int nonsmokers = 0;
        while (input.hasNext()) {
            // Prompt the user to enter necessary policy information
         

            String firstName = input.nextLine();

            String lastName = input.nextLine();

            int age = input.nextInt();
            input.nextLine();  // Consume newline

            String smokingStatus = input.nextLine();
            boolean isSmoker = smokingStatus.equalsIgnoreCase("smoker");

            if (isSmoker) {
                smokers++;
            } else {
                nonsmokers++;
            }

            double height = input.nextDouble();

            double weight = input.nextDouble();

            // Create a Policy object using the constructor that accepts arguments
            PolicyHolder insurancePolicy = new PolicyHolder(firstName, lastName, age, isSmoker, height, weight);
            policy.addPolicyHolder(insurancePolicy);
            // Display the policy information
            System.out.println();  // Print a blank line
        }


        for (PolicyHolder policyHolder : policy.getPolicyHolders()) {
            System.out.println(policyHolder);
        }
        
        System.out.println("Num policies" + policy.numPolicies());
        System.out.println("Smokers " + smokers);
        System.out.println("Non-smokers  " + nonsmokers);

        input.close();
    }
}

import java.util.ArrayList;

public class Policy {
    private int policyNumber = 0;
    private String provider = "";
    private ArrayList<PolicyHolder> policyHolders = new ArrayList<>();
    private static int INSTANCES_CREATED = 0;
    /**
     * Default constructor initializing policy fields to default values.
     */
    public Policy() {
    }

    /**
     * Constructor initializing the policy with given values.
     * @param policyNumber the policy number
     * @param provider the provider name
     * @param holderFirstName the policyholder's first name
     * @param holderLastName the policyholder's last name
     * @param holderAge the policyholder's age
     * @param isSmoker if the policyholder is a smoker
     * @param holderHeight the policyholder's height
     * @param holderWeight the policyholder's weight
     */
    public Policy(int policyNumber, String provider) {
        this.policyNumber = policyNumber;
        this.provider = provider;
        INSTANCES_CREATED++;
    }

    public void addPolicyHolder(PolicyHolder policyHolder) {
        policyHolders.add(policyHolder);
    }

    public ArrayList<PolicyHolder> getPolicyHolders() {
        return policyHolders;
    }

    /**
     * Returns the policy information in a formatted string.
     * @return formatted policy details
     */
    @Override
    public String toString() {
        return String.format("Policy Number: %d" +
            "\nProvider: %s" +
            policyNumber, provider
        );
    }
}

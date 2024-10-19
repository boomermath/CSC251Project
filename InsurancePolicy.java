public class InsurancePolicy {
    private int policyNumber = 0;
    private String provider = "";
    private String holderFirstName = "";
    private String holderLastName = "";
    private int holderAge = 0;
    private boolean isSmoker = false;
    private double holderHeight = 0.0;
    private double holderWeight = 0.0;

    private final int BMI_CONSTANT = 703;
    private final double BASE_FEE = 600.0;
    private final double SMOKER_ADDITIONAL_FEE = 100.0;
    private final double AGE_SURCHARGE = 50.0;
    private final int AGE_THRESHOLD = 50;
    private final int HIGH_BMI_THRESHOLD = 35;
    private final double HIGH_BMI_MULTIPLIER = 20.0;
    private final int BMI_OFFSET = 35;

    /**
     * Default constructor initializing policy fields to default values.
     */
    public InsurancePolicy() {
        this.policyNumber = 0;
        this.provider = "";
        this.holderFirstName = "";
        this.holderLastName = "";
        this.holderAge = 0;
        this.isSmoker = false;
        this.holderHeight = 0.0;
        this.holderWeight = 0.0;
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
    public InsurancePolicy(int policyNumber, String provider, String holderFirstName, String holderLastName, 
                           int holderAge, boolean isSmoker, double holderHeight, double holderWeight) {
        this.policyNumber = policyNumber;
        this.provider = provider;
        this.holderFirstName = holderFirstName;
        this.holderLastName = holderLastName;
        this.holderAge = holderAge;
        this.isSmoker = isSmoker;
        this.holderHeight = holderHeight;
        this.holderWeight = holderWeight;
    }

    // Getters and setters for all fields
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getHolderFirstName() { return holderFirstName; }
    public void setHolderFirstName(String holderFirstName) { this.holderFirstName = holderFirstName; }

    public String getHolderLastName() { return holderLastName; }
    public void setHolderLastName(String holderLastName) { this.holderLastName = holderLastName; }

    public int getHolderAge() { return holderAge; }
    public void setHolderAge(int holderAge) { this.holderAge = holderAge; }

    public boolean getIsSmoker() { return isSmoker; }
    public void setIsSmoker(boolean isSmoker) { this.isSmoker = isSmoker; }

    public double getHolderHeight() { return holderHeight; }
    public void setHolderHeight(double holderHeight) { this.holderHeight = holderHeight; }

    public double getHolderWeight() { return holderWeight; }
    public void setHolderWeight(double holderWeight) { this.holderWeight = holderWeight; }

    /**
     * Computes the BMI of the policyholder.
     * @return BMI value
     */
    public double calculateBmi() {
        return (holderWeight * BMI_CONSTANT) / (holderHeight * holderHeight);
    }

    /**
     * Calculates the total insurance cost based on policyholder's details.
     * @return total insurance cost
     */
    public double calculatePolicyCost() {
        double bmi = calculateBmi();
        double totalCost = BASE_FEE;

        if (holderAge > AGE_THRESHOLD) {
            totalCost += AGE_SURCHARGE;
        }

        if (isSmoker) {
            totalCost += SMOKER_ADDITIONAL_FEE;
        }

        if (bmi > HIGH_BMI_THRESHOLD) {
            totalCost += (bmi - BMI_OFFSET) * HIGH_BMI_MULTIPLIER;
        }

        return totalCost;
    }

    /**
     * Returns the policy information in a formatted string.
     * @return formatted policy details
     */
    @Override
    public String toString() {
        return String.format("Policy Number: %d" +
            "\nProvider: %s" +
            "\nPolicyholder's First Name: %s" +
            "\nPolicyholder's Last Name: %s" +
            "\nPolicyholder's Age: %d" +
            "\nSmoking Status: %s" +
            "\nWeight: %.2f" +
            "\nHeight: %.2f" +
            "\nBMI: %.2f" +
            "\nPolicy Cost: $%.2f",
            policyNumber, provider, holderFirstName, holderLastName, holderAge, 
            (isSmoker ? "Smoker" : "Non-Smoker"), holderWeight, holderHeight, calculateBmi(), calculatePolicyCost()
        );
    }
}

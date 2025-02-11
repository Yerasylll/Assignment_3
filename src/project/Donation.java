public class Donation extends Entity {
    private String donationId;
    private double amount;
    private Donor donor;

    // Constructor
    public Donation(String donationId, double amount, Donor donor) {
        super();  // Call the constructor of Entity to set the id
        this.donationId = donationId;
        this.amount = amount;
        this.donor = donor;
    }

    // Getters and setters
    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    @Override
    public String getCode() {
        return donationId;  // Donation name could be its ID for simplicity
    }

    @Override
    public String toString() {
        return super.toString() + " | Donation ID: " + donationId + " | Amount: " + amount + " | Donor: "
                + donor.getName() + " " + donor.getLastName();
    }
}

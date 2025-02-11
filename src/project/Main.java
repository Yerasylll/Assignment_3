import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Donor donor1 = new Donor("Yerasyl", "Alimbek");
        Donor donor2 = new Donor("Bekzat",  "Muqashev");

        Donation donation1 = new Donation("N001", 100, donor1);
        Donation donation2 = new Donation("N002", 200, donor2);

        ArrayList<Donation> listDonation = new ArrayList<>();
        listDonation.add(new Donation("N003", 300, donor1));
        listDonation.add(new Donation("N004", 400,  donor2));
        listDonation.add(new Donation("N005", 500, donor1));

        Charity charity = new Charity("Biz birgemiz");

        // Adding donations individually
        charity.addEntity(donation1);
        charity.addEntity(donation2);

        // Adding multiple donations at once
        charity.addDonations(listDonation);

        // Displaying Charity details
        System.out.println("Charity name: " + charity.getName());
        for (Donation donation : charity.getDonations()) {
            System.out.println(donation);
        }
    }
}

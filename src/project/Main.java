package project;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.connectToDB("Charity", "postgres", "080707");
//        db.createTable(conn, "donors");
//        db.deleteTable(conn, "donors");
        // Initialize charity organizations
        ArrayList<Charity> charities = new ArrayList<>();
        charities.add(new Charity("Biz birgemiz"));
        charities.add(new Charity("Birligi Zharasqan"));
        charities.add(new Charity("Meiyrimdi qoldar"));

        System.out.println("\nWelcome to the Charity Donation System!");

        // Display available charities
        System.out.println("Available Charities:");
        for (int i = 0; i < charities.size(); i++) {
            System.out.println((i + 1) + ". " + charities.get(i).getName());
        }

        // User selects a charity
        System.out.print("Select a charity (1-" + charities.size() + "): ");
        int charityChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        if (charityChoice < 1 || charityChoice > charities.size()) {
            System.out.println("Invalid choice. Exiting...");
            return;
        }
        Charity selectedCharity = charities.get(charityChoice - 1);
        String charityName = selectedCharity.getName();
        System.out.println("You selected: " + charityName);

        // Collect user input for donation
        System.out.print("Enter your First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the amount you want to donate: ");
        int amount = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter your Address: ");
        String address = scanner.nextLine();

        // Insert donor details with selected charity into database
        db.insertRow(conn, "donors", firstName, lastName, amount, address, charityName);

        // Create donor and donation objects
        Donor donor = new Donor(firstName, lastName);
        Donation donation = new Donation("D" + donor.getId(), amount, donor);

        // Add donation to the selected charity
        selectedCharity.addEntity(donation);

        // Encouragement message
        System.out.println("\nThank you, " + firstName + "! Your donation of " + amount + " has been successfully made to " + charityName + ".");
        System.out.println("Your generosity makes a difference! Consider donating again in the future.");

        // Display all donations for the selected charity
        System.out.println("\nCurrent Donations for " + charityName + ":");
        for (Donation d : selectedCharity.getDonations()) {
            System.out.println(d);
        }
        // Ask if the user wants to delete their donation
        System.out.print("\nDo you want to delete your donation? (yes/no): ");
        String deleteResponse = scanner.nextLine().trim().toLowerCase();

        if (deleteResponse.equals("yes")) {
            System.out.print("Enter your donor ID to delete your donation: ");
            int donorID = scanner.nextInt();
            db.deleteRowByID(conn, "donors", donorID);
            System.out.println("Your donation has been deleted. We hope to see you again!");
        } else {
            System.out.println("Your donation remains in the system. Thank you for your generosity!");
        }

        scanner.close();
    }
}


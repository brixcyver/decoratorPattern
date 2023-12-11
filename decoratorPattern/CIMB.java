package decoratorPattern;

import java.util.Scanner;

public class CIMB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("=== Welcome to CIMB Digital Bank! ===");

        while (true) {
            System.out.println();
            System.out.print("Enter Account Number (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            try {
                int accountNumber = Integer.parseInt(input);

                System.out.print("Enter Account Name: ");
                String accountName = scanner.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                SavingsAccount account = new SavingsAccount();
                account.setAccountNumber(accountNumber);
                account.setAccountName(accountName);
                account.setBalance(balance);

                System.out.println(account.showInfo());
                System.out.println("Account type: " + account.showAccountType());
                System.out.println("Interest rate: " + account.getInterestRate());
                System.out.println("New balance: " + account.computeBalanceWithInterest());
                System.out.println("Benefits: " + account.showBenefits());
                System.out.println("----------------------");

                GSave gSave = new GSave(account);
                System.out.println();
                System.out.println(gSave.showInfo());
                System.out.println("Account type: " + gSave.showAccountType());
                System.out.println("Interest rate: " + gSave.getInterestRate());
                System.out.println("New balance: " + gSave.computeBalanceWithInterest());
                System.out.println("Benefits: " + gSave.showBenefits());
                System.out.println("----------------------");

                UpSave upSave = new UpSave(account);
                System.out.println();
                System.out.println(upSave.showInfo());
                System.out.println("Account type: " + upSave.showAccountType());
                System.out.println("Interest rate: " + upSave.getInterestRate());
                System.out.println("New balance: " + upSave.computeBalanceWithInterest());
                System.out.println("Benefits: " + upSave.showBenefits());
            }
            catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid input. Please enter a valid account number.");
            }
        }
    }
}

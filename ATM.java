import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        balance = initialBalance;
        this.pin = pin;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0, 1234);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (atm.validatePin(enteredPin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }
}

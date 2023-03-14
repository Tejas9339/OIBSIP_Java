import java.util.Scanner;
public class ATMInterface 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int balance = 10000; 
        String transactionHistory = ""; 
        System.out.print("Enter User ID: ");
        String userId = input.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = input.nextLine();

        if (authenticateUser(userId, userPin)) 
        {
            System.out.println("\nWelcome to ATM Interface!");

            while (choice != 5) 
            {
                System.out.println("\nChoose an option:");
                System.out.println("1. View Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                switch (choice)
                {
                    case 1:
                        System.out.println("\nTransaction History: ");
                        System.out.println(transactionHistory);
                        break;
                    case 2:
                        System.out.print("\nEnter the amount to withdraw: ");
                        int withdrawAmount = input.nextInt();
                        if (withdrawAmount > balance) 
                        {
                            System.out.println("Insufficient balance");
                        } 
                        else 
                        {
                            balance -= withdrawAmount;
                            transactionHistory += "Withdrawn: " + withdrawAmount + "\n";
                            System.out.println("Withdrawn: " + withdrawAmount);
                            System.out.println("Balance: " + balance);
                        }
                        break;
                    case 3:
                        System.out.print("\nEnter the amount to deposit: ");
                        int depositAmount = input.nextInt();
                        balance += depositAmount;
                        transactionHistory += "Deposited: " + depositAmount + "\n";
                        System.out.println("Deposited: " + depositAmount);
                        System.out.println("Balance: " + balance);
                        break;
                    case 4:
                        System.out.print("\nEnter the amount to transfer: ");
                        int transferAmount = input.nextInt();
                        if (transferAmount > balance) 
                        {
                            System.out.println("Insufficient balance");
                        } 
                        else 
                        {
                            System.out.print("Enter the recipient account number: ");
                            String recipientAccount = input.next();
                            balance -= transferAmount;
                            transactionHistory += "Transferred: " + transferAmount + " to account " + recipientAccount + "\n";
                            System.out.println("Transferred: " + transferAmount + " to account " + recipientAccount);
                            System.out.println("Balance: " + balance);
                        }
                        break;
                    case 5:
                        System.out.println("\nThank you for using ATM Interface!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.");
                }
            }
        } 
        else 
        {
            System.out.println("\nInvalid credentials. Please try again.");
        }
    }

    public static boolean authenticateUser(String userId, String userPin) 
    {
        return userId.equals("Tejas1234") && userPin.equals("1234");
    }
}

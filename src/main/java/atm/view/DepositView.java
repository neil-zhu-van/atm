package atm.view;

import atm.model.BankAccountView;

import java.util.Optional;

public class DepositView
{
    private BankAccountView accountView;

    public DepositView(BankAccountView accountView)
    {
        this.accountView = accountView;
    }

    public String displayBalanceAndReadAmount()
    {
        System.out.println();
        System.out.println("Deposit:");
        displayBalance();
        return readAmount();
    }

    public void depositSuccessfully(BankAccountView accountView)
    {
        this.accountView = accountView;
        System.out.println("Your money has been successfully deposited");
        this.displayBalance();
        System.console().readLine("Please enter any key to go back to main menu.");
    }

    public void displayInputErrorMessage()
    {
        System.out.println("Invalid number or negative. Please try again.\n");
    }

    private void displayBalance()
    {
        System.out.printf("Your current balance is: %s\n", accountView.getBalance());
    }

    private String readAmount()
    {
        return System.console().readLine("Enter amount to be deposited(press c to cancel): ");
    }
}

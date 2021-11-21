package atm.view;

import atm.model.BankAccountView;

public class WithdrawView
{
    private BankAccountView accountView;

    public WithdrawView(BankAccountView accountView)
    {
        this.accountView = accountView;
    }

    public String displayBalanceAndReadAmount()
    {
        System.out.println();
        System.out.println("Withdraw:");
        displayBalance();
        return readAmount();
    }

    public void withdrawSuccessfully(BankAccountView accountView)
    {
        this.accountView = accountView;
        System.out.println("Please collect your money.");
        this.displayBalance();
        System.console().readLine("Please enter any key to go back to main menu.");
    }

    public void displayInputErrorMessage()
    {
        System.out.println("Invalid number or negative. Please try again.\n");
    }

    public void displayInsufficientFundErrorMessage()
    {
        System.out.println("Insufficient fund for the amount requested.");
        displayBalance();
        System.console().readLine("Please enter any key to go back to main menu.");
    }

    private void displayBalance()
    {
        System.out.printf("Your current balance is: %s\n", accountView.getBalance());
    }

    private String readAmount()
    {
        return System.console().readLine("Enter amount to be withdrew(press c to cancel): ");
    }
}

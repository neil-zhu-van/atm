package atm.view;

import atm.model.BankAccountView;

public class ViewBalanceView
{
    private BankAccountView accountView;

    public ViewBalanceView(BankAccountView accountView)
    {
        this.accountView = accountView;
    }

    public void displayBalanceAndWait()
    {
        displayBalance();
        waitForInput();
    }

    private void displayBalance()
    {
        System.out.printf("Your current balance is: %s\n", accountView.getBalance());
    }

    private void waitForInput()
    {
        System.console().readLine("Please enter any key to go back to main menu.");
    }
}

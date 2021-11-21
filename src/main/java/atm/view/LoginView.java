package atm.view;

public class LoginView
{
    public char[] askToLoginByPin()
    {
        System.out.println("Thank you for visiting our ATM.");
        return System.console().readPassword("Please insert your card and enter your pin number to begin: ");
    }

    public void displayInvalidPinErrorMessage()
    {
        System.out.println("Incorrect pin number.");
    }
}

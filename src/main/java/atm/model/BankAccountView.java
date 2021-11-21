package atm.model;

import atm.domain.BankAccount;

public class BankAccountView
{
    private String name;
    private Double balance;

    public BankAccountView(BankAccount bankAccount)
    {
        this.name = bankAccount.getFirstName() + " " + bankAccount.getLastName();
        this.balance = bankAccount.getBalance();
    }

    public String getName()
    {
        return name;
    }

    public Double getBalance()
    {
        return balance;
    }
}

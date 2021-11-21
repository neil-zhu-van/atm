package atm.domain;

public class BankAccount
{
    private String firstName;
    private String lastName;
    private Double balance;

    public BankAccount(String firstName, String lastName, Double balance)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void deposit(Double amount)
    {
        this.balance += amount;
    }

    public void withdraw(Double amount) throws InsufficientFundException
    {
        if (amount > this.balance) {
            throw new InsufficientFundException();
        }
        balance -= amount;
    }
}

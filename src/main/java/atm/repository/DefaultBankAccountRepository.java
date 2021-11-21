package atm.repository;

import atm.domain.BankAccount;

import java.util.Optional;

public class DefaultBankAccountRepository implements BankAccountRepository
{
    private static final String DEFAULT_PIN = "1234";

    @Override
    public Optional<BankAccount> findAccountByIdAndPin(String id, char[] pin)
    {
        Optional<BankAccount> accountFound = Optional.empty();
        if (DEFAULT_PIN.equals(String.valueOf(pin))) {
            BankAccount account = new BankAccount("Neil", "Zhu", 11000D);
            return Optional.of(account);
        }
        return accountFound;
    }
}

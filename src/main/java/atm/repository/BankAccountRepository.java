package atm.repository;

import atm.domain.BankAccount;

import java.util.Optional;

public interface BankAccountRepository
{
    Optional<BankAccount> findAccountByIdAndPin(String id, char[] pin);
}

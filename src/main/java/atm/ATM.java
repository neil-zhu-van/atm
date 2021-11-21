package atm;

import atm.repository.DefaultBankAccountRepository;
import atm.validator.MoneyAmountValidator;
import atm.validator.PinValidator;

public class ATM
{
    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");
        ATMController atmController = new ATMController(
                new PinValidator(),
                new MoneyAmountValidator(),
                new DefaultBankAccountRepository());
        atmController.loginByPin();
    }
}

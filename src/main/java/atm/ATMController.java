package atm;

import atm.domain.BankAccount;
import atm.domain.InsufficientFundException;
import atm.model.BankAccountView;
import atm.repository.BankAccountRepository;
import atm.validator.MoneyAmountValidator;
import atm.validator.PinValidator;
import atm.view.DepositView;
import atm.view.LoginView;
import atm.view.MainMenuView;
import atm.view.MenuItemView;
import atm.view.ViewBalanceView;
import atm.view.WithdrawView;

import java.util.Objects;
import java.util.Optional;

public class ATMController
{
    private final PinValidator pinValidator;
    private final MoneyAmountValidator moneyAmountValidator;
    private final BankAccountRepository bankAccountRepository;

    public ATMController(PinValidator pinValidator,
                         MoneyAmountValidator moneyAmountValidator,
                         BankAccountRepository bankAccountRepository)
    {
        this.pinValidator = pinValidator;
        this.moneyAmountValidator = moneyAmountValidator;
        this.bankAccountRepository = bankAccountRepository;
    }

    public void loginByPin()
    {
        System.out.print("\033[H\033[2J");
        BankAccount bankAccount = null;
        LoginView loginView = new LoginView();
        while (true) {
            char[] pin = loginView.askToLoginByPin();
            if ( ! pinValidator.isValidPin(pin)) {
                loginView.displayInvalidPinErrorMessage();
                continue;
            }

            Optional<BankAccount> bankAccountOpt = bankAccountRepository.findAccountByIdAndPin("abc", pin);
            if ( ! bankAccountOpt.isPresent()) {
                loginView.displayInvalidPinErrorMessage();
                continue;
            }
            bankAccount = bankAccountOpt.get();
            break;
        }
        mainMenu(bankAccount);
    }

    private void mainMenu(BankAccount bankAccount)
    {
        if (Objects.isNull(bankAccount)) {
            throw new IllegalArgumentException("account cannot be null");
        }

        loop: while (true) {
            MainMenuView mainMenuView = new MainMenuView(new BankAccountView(bankAccount));
            MenuItemView selectedItem = mainMenuView.displayMainMenuAndWaitSelection();
            switch (selectedItem) {
                case Balance:
                    viewBalance(bankAccount);
                    break;
                case Deposit:
                    deposit(bankAccount);
                    break;
                case Withdraw:
                    withdraw(bankAccount);
                    break;
                case Exit:
                    break loop;
                default:
                    throw new IllegalArgumentException("Unknown main menu item: " + selectedItem.getMessage());
            }
        }
        loginByPin();
    }

    private void viewBalance(BankAccount bankAccount)
    {
        ViewBalanceView viewBalanceView = new ViewBalanceView(new BankAccountView(bankAccount));
        viewBalanceView.displayBalanceAndWait();
    }

    private void deposit(BankAccount bankAccount)
    {
        DepositView depositView = new DepositView(new BankAccountView(bankAccount));
        while (true) {
            String strAmount = depositView.displayBalanceAndReadAmount();
            if (isCancelInput(strAmount)) {
                break;
            }
            if (moneyAmountValidator.isValidAmount(strAmount)) {
                bankAccount.deposit(Double.parseDouble(strAmount));
                depositView.depositSuccessfully(new BankAccountView(bankAccount));
                break;
            }
            else {
                depositView.displayInputErrorMessage();
            }
        }
    }

    private void withdraw(BankAccount bankAccount)
    {
        WithdrawView withdrawView = new WithdrawView(new BankAccountView(bankAccount));
        while (true) {
            String strAmount = withdrawView.displayBalanceAndReadAmount();
            if (isCancelInput(strAmount)) {
                break;
            }
            if (moneyAmountValidator.isValidAmount(strAmount)) {
                try {
                    bankAccount.withdraw(Double.parseDouble(strAmount));
                    withdrawView.withdrawSuccessfully(new BankAccountView(bankAccount));
                    break;
                } catch (InsufficientFundException e) {
                    withdrawView.displayInsufficientFundErrorMessage();
                }
            }
            else {
                withdrawView.displayInputErrorMessage();
            }
        }
    }

    private boolean isCancelInput(String input)
    {
        return "c".equalsIgnoreCase(input);
    }
}

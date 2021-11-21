package atm.view;

import atm.model.BankAccountView;

import java.util.Optional;

public class MainMenuView
{
    private BankAccountView accountView;

    public MainMenuView(BankAccountView accountView)
    {
        this.accountView = accountView;
    }

    public MenuItemView displayMainMenuAndWaitSelection()
    {
        MenuItemView itemSelected = null;
        displayMainMenu();
        while (true) {
            String selection = collectSelection();
            Optional<MenuItemView> itemSelectedOpt = MenuItemView.parseSelection(selection);
            if (! itemSelectedOpt.isPresent()) {
                displayErrorMessage();
                continue;
            }
            itemSelected = itemSelectedOpt.get();
            break;
        }
        return itemSelected;
    }

    private void displayMainMenu()
    {
        System.out.printf("Welcome back %s\n\n", accountView.getName());
        System.out.println("Main Menu:");
        MenuItemView.displayMenuItems();
    }

    private String collectSelection()
    {
        return System.console().readLine("Please choose the operation you want to perform: ");
    }

    private void displayErrorMessage()
    {
        System.out.println("Incorrect number.");
    }
}

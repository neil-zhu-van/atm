package atm.view;

import java.util.Optional;

public enum MenuItemView
{
    Balance(1, "View current balance"),
    Deposit(2, "Deposit money"),
    Withdraw(3, "Withdraw money"),
    Exit(4, "Exit");

    final private int num;
    final private String message;

    public static void displayMenuItems()
    {
        for (MenuItemView item : MenuItemView.values()) {
            System.out.printf("%d. %s\n", item.getNum(), item.getMessage());
        }
    }

    public static Optional<MenuItemView> parseSelection(String selection)
    {
        try {
            int sel = Integer.parseInt(selection);
            for (MenuItemView item : MenuItemView.values()) {
                if (item.getNum() == sel) {
                    return Optional.of(item);
                }
            }
        }
        catch (NumberFormatException ex) {
            return Optional.empty();
        }
        return Optional.empty();
    }

    MenuItemView(int num, String message)
    {
        this.num = num;
        this.message = message;
    }

    public int getNum()
    {
        return num;
    }

    public String getMessage()
    {
        return message;
    }
}

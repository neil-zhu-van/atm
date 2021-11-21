package atm.validator;

import java.util.Optional;

public class MoneyAmountValidator
{
    public boolean isValidAmount(String strAmount) {
        Optional<Double> optAmount = parseAmountStr(strAmount);
        return optAmount.isPresent() && optAmount.get() > 0.0;
    }

    private Optional<Double> parseAmountStr(String amount)
    {
        try{
            return Optional.of(Double.parseDouble(amount));
        }
        catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }
}

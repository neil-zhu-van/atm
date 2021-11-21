package atm.validator;

public class PinValidator
{
    public boolean isValidPin(char[] pin)
    {
        return pin.length == 4;
    }
}

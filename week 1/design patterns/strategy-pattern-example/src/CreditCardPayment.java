
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        //show last 4 digits
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("paid $" + amount + " using credit card ending in " + lastFour);
    }
}


public class Main {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("1234567890123456"));

        System.out.println("first order - paying by card:");
        context.executePayment(59.99);

        
        context.setStrategy(new PayPalPayment("user@email.com"));
        System.out.println("\nsecond order - switched to paypal:");
        context.executePayment(120.00);
    }
}

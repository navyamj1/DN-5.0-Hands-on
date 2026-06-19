
public class LinearSearch {

    public static Product searchByName(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                Product match = products[i];
                return match;
            }
        }
        return null;
    }
}

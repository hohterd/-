package lection18_synchronized.store;


public class Lection18_Store {
    public static void main(String[] args) {
        CheckoutDesk checkout1 = new CheckoutDesk(1);
        CheckoutDesk checkout2 = new CheckoutDesk(2);
        CheckoutDesk checkout3 = new CheckoutDesk(3);
        checkout1.start();
        checkout2.start();
        checkout3.start();
        BuyerGenerator generator = new BuyerGenerator();
        generator.start();
    }
}

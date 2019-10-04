package lection18_synchronized.store;

public class Item {

    int No;
    Good good;
    int quantity;
    double cost;
    double discount;
    double discountAmount;

    Item (int No, Good good, int quantity) {
        this.No = No;
        this.good = good;
        this.quantity = quantity;
        this.cost = (double) Math.round(good.price*quantity*100)/100;
        this.discount = good.discount;
        this.discountAmount = (double) Math.round(this.cost*this.discount*100)/100;
    }

    public void print () {
        System.out.println(No+"\t"+good.name+"\t"+quantity+"\t\t"+cost+"\t\t\t"+discount+"\t\t"+discountAmount);
    }
}

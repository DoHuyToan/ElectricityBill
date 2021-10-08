package model;

public class Bill {
    private Customer customer;
    private double oldNumber;
    private double newNumber;
    private double unitPrice;

    public Bill(Customer customer, double oldNumber, double newNumber, double price) {
        this.customer = customer;
        this.oldNumber = oldNumber;
        this.newNumber = newNumber;
        this.unitPrice = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(double oldNumber) {
        this.oldNumber = oldNumber;
    }

    public double getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(double newNumber) {
        this.newNumber = newNumber;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getPrice(){
        double total = unitPrice * (newNumber - oldNumber);
        return total;
    }

    @Override
    public String toString() {
        return "model.Bill: " +
                customer.toString() +
                ", oldNumber= " + oldNumber +
                ", newNumber= " + newNumber +
                ", totalPrice= " + getPrice();
    }
}

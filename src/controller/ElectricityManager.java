package controller;

import model.Bill;
import model.Customer;

import java.util.ArrayList;

public class ElectricityManager {
    ArrayList<Customer> customerArrayList = new ArrayList<>();
    ArrayList<Bill> billArrayList = new ArrayList<>();

    public ElectricityManager(ArrayList<Customer> customerArrayList, ArrayList<Bill> billArrayList) {
        this.customerArrayList = customerArrayList;
        this.billArrayList = billArrayList;
    }

    public void displayInfoCustomer(){
        for (Customer c:customerArrayList) {
            System.out.println(c);
        }
    }

    public void displayInfoBill(){
        for (Bill b: billArrayList) {
            System.out.println(b);
        }
    }

    public void addCustomer(Customer customer){           //thêm khách hàng
            customerArrayList.add(customer);
    }

    public void removeCustomer(String code){              //xóa khách hàng
        for (int i = 0; i<customerArrayList.size(); i++){
            if(customerArrayList.get(i).getCode().equals(code))
            customerArrayList.remove(i);
        }
    }

    public void editCustomer(String code, Customer customer){                //sửa khách hàng
        for (int i = 0; i<customerArrayList.size(); i++){
            if(customerArrayList.get(i).getCode().equals(code))
            customerArrayList.set(i, customer);
        }
    }

    public void addBill(Bill bill){            //thêm bill
        billArrayList.add(bill);
    }

    public void removeBill(String code){          //xóa bill
        for (int i=0; i<billArrayList.size(); i++){
            if(billArrayList.get(i).getCustomer().getCode().equals(code))
            billArrayList.remove(i);
        }
    }

    public Customer searchCustomerByCode(String code){         //search Customer
        Customer customer = null;
        for (int i=0; i<customerArrayList.size(); i++) {
            if(customerArrayList.get(i).getCode().equals(code)){
                customer = customerArrayList.get(i);
                break;
            }
        }
        return customer;
    }

    public void editBill(String code, Bill bill){            //sửa bill
        for (int i=0; i<billArrayList.size(); i++){
            if (billArrayList.get(i).getCustomer().getCode().equals(code))
            billArrayList.set(i, bill);
        }
    }

    public Bill findBillByCustomer(String code){             //tìm bill theo code khách
        for (int i=0; i<billArrayList.size(); i++) {
            if (billArrayList.get(i).getCustomer().getCode().equals(code))
                return billArrayList.get(i);
        }
        return null;
    }

    public double totalPriceBillByCustomer(String code){          //tính tổng tiền bill của 1 hộ
        double totalPrice = 0;
        for (int i=0; i<billArrayList.size(); i++) {
            if (billArrayList.get(i).getCustomer().getCode().equals(code))
                totalPrice += billArrayList.get(i).getPrice();
        }
        return totalPrice;
    }

    public double totalPriceBill(){             //tính tổng tiền của toàn bộ bill
        double totalPrice = 0;
        for (int i=0; i<billArrayList.size(); i++) {
            totalPrice += billArrayList.get(i).getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    public ArrayList<Bill> getBillArrayList() {
        return billArrayList;
    }

    public void setBillArrayList(ArrayList<Bill> billArrayList) {
        this.billArrayList = billArrayList;
    }


}

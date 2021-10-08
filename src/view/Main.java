package view;

import controller.ElectricityManager;
import model.Bill;
import model.Customer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        ArrayList<Bill> billArrayList = new ArrayList<>();


        Customer dinh = new Customer("Dinh", "Hà Đông", "001");
        Customer duy = new Customer("Duy", "Hai Bà Trưng", "002");
        customerArrayList.add(dinh);
        customerArrayList.add(duy);

        Bill bill1 = new Bill(dinh, 200, 300, 750);
        Bill bill2 = new Bill(duy, 250, 400, 750);
        billArrayList.add(bill1);
        billArrayList.add(bill2);

        ElectricityManager dienlucHN = new ElectricityManager(customerArrayList, billArrayList);

        System.out.println("Hiển thị danh sách khách");
        dienlucHN.displayInfoCustomer();
        System.out.println("Thêm khách");
        dienlucHN.addCustomer(new Customer("Tuấn", "Nam Từ Liêm", "003"));
        dienlucHN.displayInfoCustomer();
        System.out.println("Xóa khách");
        dienlucHN.removeCustomer("001");
        dienlucHN.displayInfoCustomer();
        System.out.println("Sửa khách");
        dienlucHN.editCustomer("003", new Customer("Thảo", "Hoài Đức", "003"));
        dienlucHN.displayInfoCustomer();
        System.out.println("Danh sách toàn bộ model.Bill");
        dienlucHN.displayInfoBill();
        System.out.println("Thêm bill");
        dienlucHN.addBill(new Bill(dinh, 300, 380, 750));
        dienlucHN.displayInfoBill();
        System.out.println("Tổng tiền của toàn bộ bill");
        System.out.println(dienlucHN.totalPriceBill());
        System.out.println("Xóa bill theo code");
        dienlucHN.removeBill("002");
        dienlucHN.displayInfoBill();
        System.out.println("Sửa bill theo code");
        dienlucHN.editBill("001", new Bill(dinh, 200, 280, 750));
        dienlucHN.displayInfoBill();
        System.out.println("Tìm model.Bill theo code Khách");
        System.out.println(dienlucHN.findBillByCustomer("001"));
        System.out.println("Tổng tiền bill của 1 hộ");
        System.out.println(dienlucHN.totalPriceBillByCustomer("001"));
    }

//    private static model.Customer inputCustomer(){
//        System.out.println("Nhập khách hàng vào");
//
//    }
}

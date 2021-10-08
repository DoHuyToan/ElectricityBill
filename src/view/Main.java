package view;

import controller.ElectricityManager;
import model.Bill;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        ArrayList<Bill> billArrayList = new ArrayList<>();
        ElectricityManager dienlucHN = new ElectricityManager(customerArrayList, billArrayList);

        int choice;
        do {
            menu();
            System.out.println("Chọn Menu");
            Scanner inputChoice = new Scanner(System.in);
            choice = inputChoice.nextInt();
            switch (choice){
                case 1:
                    dienlucHN.addCustomer(creatCustomer());
                    dienlucHN.displayInfoCustomer();
                    break;
                case 2:
                    dienlucHN.displayInfoCustomer();
                    break;
                case 3:
                    dienlucHN.editCustomer(inputCode(), creatCustomer());
                    dienlucHN.displayInfoCustomer();
                    break;
                case 4:
                    dienlucHN.removeCustomer(inputCode());
                    dienlucHN.displayInfoCustomer();
                    break;
                case 5:
                    dienlucHN.addBill(creatBill());
                    dienlucHN.displayInfoBill();
                    break;
                case 6:
                    dienlucHN.displayInfoBill();
                    break;
                case 7:
                    dienlucHN.editBill(inputCode(), creatBill());
                    dienlucHN.displayInfoBill();
                    break;
                case 8:
                    dienlucHN.removeBill(inputCode());
                    dienlucHN.displayInfoBill();
                    break;
                case 9:
                    System.out.println(dienlucHN.findBillByCustomer(inputCode()));
                    break;
                case 10:
                    System.out.println(dienlucHN.totalPriceBill());
                    break;
                case 11:
                    System.out.println(dienlucHN.totalPriceBillByCustomer(inputCode()));
                    break;
            }
        } while (choice!=0);

//        Customer dinh = new Customer("Dinh", "Hà Đông", "001");
//        Customer duy = new Customer("Duy", "Hai Bà Trưng", "002");
//        customerArrayList.add(dinh);
//        customerArrayList.add(duy);
//
//        Bill bill1 = new Bill(dinh, 200, 300, 750);
//        Bill bill2 = new Bill(duy, 250, 400, 750);
//        billArrayList.add(bill1);
//        billArrayList.add(bill2);
//
//        System.out.println("Thêm khách");
//        System.out.println("Xóa khách");
//        System.out.println("Sửa khách");
//        System.out.println("Danh sách toàn bộ model.Bill");
//        System.out.println("Thêm bill");
//        System.out.println("Tổng tiền của toàn bộ bill");
//        System.out.println("Xóa bill theo code");
//        System.out.println("Sửa bill theo code");
//        System.out.println("Tìm model.Bill theo code Khách");
//        System.out.println("Tổng tiền bill của 1 hộ");
    }

    private static void menu() {
        System.out.println("Menu");
        System.out.println("1. Thêm khách hàng");
        System.out.println("2. Hiển thị danh sách khách hàng");
        System.out.println("3. Sửa khách hàng");
        System.out.println("4. Xóa khách hàng");
        System.out.println("5. Thêm bill");
        System.out.println("6. Hiển thị danh sách Bill");
        System.out.println("7. Sửa bill");
        System.out.println("8. Xóa bill");
        System.out.println("9. Tìm bill theo mã khách hàng");
        System.out.println("10. Tổng tiền của toàn bộ Bill");
        System.out.println("11. Tổng tiền Bill của 1 hộ");
        System.out.println("0. Exit");
    }

    private static String inputCode(){
        Scanner inputCode = new Scanner(System.in);
        String code = inputCode.nextLine();
        return code;
    }

    private static Customer creatCustomer(){
        System.out.println("Nhập tên khách hàng");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Nhập địa chỉ khách");
        Scanner inputAddress = new Scanner(System.in);
        String address = inputAddress.nextLine();
        System.out.println("Nhập mã khách hàng");
        Scanner inputCode = new Scanner(System.in);
        String code = inputCode.nextLine();
        Customer customer = new Customer(name, address, code);
        return customer;
    }

    private static Bill creatBill(){
        System.out.println("Nhập khách hànhg");
        Customer customer = creatCustomer();
        System.out.println("Nhập số công tơ cũ");
        Scanner inputOldNumber = new Scanner(System.in);
        double oldNumber = inputOldNumber.nextDouble();
        System.out.println("Nhập số công tơ mới");
        Scanner inputNewNumber = new Scanner(System.in);
        double newNumber = inputNewNumber.nextDouble();
        System.out.println("Nhập đơn giá/số");
        Scanner inputUnitPrice = new Scanner(System.in);
        double unitPrice = inputUnitPrice.nextDouble();
        Bill bill = new Bill(customer, oldNumber, newNumber, unitPrice);
        return bill;
    }
}

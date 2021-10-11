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
                    creatBill(dienlucHN);
                    dienlucHN.displayInfoBill();
                    break;
                case 6:
                    dienlucHN.displayInfoBill();
                    break;
                case 7:
                    dienlucHN.editBill(inputCode(), creatBill(dienlucHN));
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
    }

    private static Bill creatBill(ElectricityManager dienlucHN) {
        System.out.println("Nhập code khách hàng");
        Scanner codeCustomer = new Scanner(System.in);
        String code = codeCustomer.nextLine();
        Customer customer = dienlucHN.searchCustomerByCode(code);
        if(customer != null){
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
            dienlucHN.addBill(bill);
            return bill;
        }
        else System.out.println("Không tìm thấy khách hàng");
        return null;
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
        System.out.println("Nhập mã khách hàng");
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


}

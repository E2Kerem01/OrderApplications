package com.patika;


import java.time.LocalDate;
import java.util.*;


public class Main {

    private static Invoice invoice;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        Boolean SystemControl = true;
        int tradeNumber = 1;
        int totalAmount = 0;

        System.out.println("Welcome to the Patika Order System...." + "\n");

        while (SystemControl){                     // Uygulamayı başlatır ve işlem seçimlerine göre süreci yönetir.


            System.out.println("Please Choose One Of The Following Options : ");

            System.out.println(                                    // İşlem seçim alanı
                    "Create a Customer : --------------------------------------------------- 1" + "\n"+
                    "Delete a Customer : --------------------------------------------------- 2" + "\n"+
                    "Customer List : ------------------------------------------------------- 3" + "\n" +
                    "List customers with the letter c : ------------------------------------ 4" + "\n" +
                    "Create an order : ----------------------------------------------------- 5" + "\n" +
                    "June Invoice : -------------------------------------------------------- 6" + "\n" +
                    "Invoices over 1500 TL : ----------------------------------------------- 7" + "\n" +
                    "Names of customers with invoices under 500TL in the system : ---------- 8" + "\n" +
                    "Sectors of companies with an average invoice of less than 750 in June : 9" + "\n" +
                    "All Invoice : --------------------------------------------------------- 10" + "\n" +
                    "System Off Buton : ---------------------------------------------------- q");

            System.out.println("************************************************************");
            System.out.print("Enter the Process Number : ");
            String processNumber = scan.nextLine();
            System.out.println("-----------------------------");
            System.out.println("*****************************");


             if (Objects.equals(processNumber, "1")) {                                                                  // Bütün müşterileri listeler.
                if (customers.size() == 0){                   // Listedeki müşteri sayını kontrol edip cevap döner
                    System.out.println("There is no customer in the list");
                    System.out.println("-----------------------------");
                    System.out.println("Please add a Customer in the list");
                    System.out.println("-----------------------------");
                }
                else {                                                                                                     // Listedeki müşterilerin bilgilerini döner.
                    customers.forEach(c -> {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Name: " + c.getFirstName());
                        System.out.println("Registration Date: " + c.getRegistrationDate());
                        System.out.println("Industry: " + c.getIndustry());
                        System.out.println("-----------------------------");
                    });
                }
            }

            else if (Objects.equals(processNumber, "2")){                                                                // Listeye yeni müşteri ekleme işlemi yapar.

                System.out.println("Enter Customer Name : " );
                String name = scan.nextLine();

                System.out.println("Enter Customer ID : " );
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Customer Industry : " );

                String industry = scan.nextLine();

                Customer customer = new Customer(id,name,industry,LocalDate.now());
                System.out.println("The customer named" + customer.getFirstName() +  "is registered in the system.");
                customers.add(customer);
            }

            else if (Objects.equals(processNumber, "3")) {                                                          // C harfi bulunan müşterileri listeler
                 List<Customer> customerList = customers;               // Müşteri listesi
                 boolean customerFound = false;                         // Müşteri bulunup bulunmadığını tutan değişken

                 for (Customer c : customerList) {
                     if (c.getFirstName().contains("C") || c.getFirstName().contains("c")) {
                         System.out.println("Customer Name : " + c.getFirstName() + c.getId() + c.getIndustry()
                                 + c.getRegistrationDate().getMonthValue());
                         customerFound = true;
                     }
                 }
                 if (!customerFound) {
                     System.out.println("No customer found with the letter 'C' in it.");
                 }
            }

            else if (Objects.equals(processNumber, "4")) {                                                            // Müşteri id'si üzerinden müşteri siparişi alma

                System.out.println("Please enter the id of the customer you want to trade : ");
                int id = scan.nextInt();

                scan.nextLine();
                Customer customer = customers.stream().filter(m -> m.getId()==id)
                        .findFirst()
                        .orElse(null);

                System.out.println("Product Name : ");
                String productName = scan.nextLine();

                System.out.println("Product Quantity : ");
                int quantity = scan.nextInt();

                System.out.println("Product Price : ");
                int price = scan.nextInt();
                scan.nextLine();

                Order order = new Order(productName,quantity,price, customer,LocalDate.now());
                orders.add(order);
                Invoice invoice = new Invoice(tradeNumber,(quantity*price) + totalAmount,LocalDate.now(),order);
                invoices.add(invoice);

                tradeNumber += 1;
                System.out.println("Customer Name : " + order.getCustomer().getFirstName() + " "
                        + order.getProductName() + " "
                        + order.getQuantity() + " " + order.getPrice());
                System.out.println("------------------------");
            }

            else if (Objects.equals(processNumber, "5")) {                                                            // Haziran ayında kayıt olan müşteri fatura çıktısı

                 List<Invoice> invoiceList = invoices;
                 boolean customerFound = false;
                 for (Invoice c : invoiceList){
                     if (c.getDate().getMonthValue() == 6){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName());
                         customerFound = true;
                     }
                 }if (!customerFound) {
                     System.out.println("No Invoice found in June.");
                 }
            }

             else if (Objects.equals(processNumber, "6")) {                                                           //Bütün faturaları listelemek için kullanılır.

                List<Invoice> invoiceList = invoices;                   // Fatura Listesi listesi
                boolean customerFound = false;                          // Müşteri bulunup bulunmadığını tutan değişken

                for (Invoice c : invoiceList) {
                    if (invoiceList.size()>0) {
                        System.out.println( c.getOrder().getCustomer().getFirstName() + " "
                                + c.getOrder().getCustomer().getId() + " "
                                + c.getInvoiceNumber() + " " + c.getAmount() + " " + c.getDate());
                        customerFound = true;
                    }
                }

                if (!customerFound) {
                    System.out.println("No customer found ...");
                }
            }

             else if (Objects.equals(processNumber, "7")) {                                                            // 1500 üstü faturalar listelenir.

                 List<Invoice> invoiceList = invoices;
                 boolean customerFound = false;
                 for (Invoice c : invoiceList){
                     if (c.getAmount() > 1500){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName()
                                 + "Invoince Number : " + c.getInvoiceNumber());
                         customerFound = true;
                     }
                 }if (!customerFound) {
                     System.out.println("No customer found with the letter 'C' in it.");
                 }
             }

             else if (Objects.equals(processNumber, "8")) {                                                            // 1500 Tl üstü fatura ortalaması
                 double average = invoices.stream()
                         .filter(invoice -> invoice.getAmount() > 1500)
                         .mapToDouble(Invoice::getAmount)
                         .average()
                         .orElse(0.0);

                 System.out.println(average);
             }

             else if (Objects.equals(processNumber, "9")) {                       //OKEY                               // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin

                 List<Invoice> invoiceList = invoices;
                 boolean customerFound = false;
                 for (Invoice c : invoiceList){
                     if (c.getAmount() < 500){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName());
                         customerFound = true;
                     }
                 }if (!customerFound) {
                     System.out.println("No customer found with the letter 'C' in it.");
                 }
             }

             else if (Objects.equals(processNumber, "10")) {                                                          // Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.

                 List<Invoice> invoiceList = invoices;
                 boolean customerFound = false;

                 for (Invoice c : invoiceList){
                     if (c.getAmount() < 750 && c.getOrder().getOrderDate().getMonthValue()==6){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName()
                                 + "Sector Name : " + c.getOrder().getCustomer().getIndustry());
                         customerFound = true;
                     }
                 }if (!customerFound) {
                     System.out.println("No customer found with the letter 'C' in it.");
                 }
             }

             else if(Objects.equals(processNumber, "11")){                                                               // Müşteri id'sine göre silme işlemi gerçekleştirilir.
                if (customers.size() == 0){
                    System.out.println("There is no customer in the list");
                    System.out.println("-----------------------------");
                    System.out.println("Please add a Customer in the list");
                    System.out.println("-----------------------------");
                }
                else {
                    System.out.println("Please enter the id number of the customer to be deleted : ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    Customer customer = customers.stream().filter(m -> m.getId()==id)
                            .findFirst()
                            .orElse(null);

                    if (customer != null){
                        customers.remove(customer);
                        System.out.println("Customer detele process is success...");
                    }else {
                        System.out.println("Customer nor find the list...");
                    }
                }
            }

             else if (Objects.equals(processNumber, "q")) {                                                             // Sistemden çıkış yapılır.

                System.out.println("Patika order system is closing....");

            }
        }
    }
}




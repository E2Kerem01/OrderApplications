package com.patika;



import java.time.LocalDate;
import java.util.*;


public class Main {


    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        boolean SystemControl = true;
        int tradeNumber = 1;
        int totalAmount = 0;
        int time = 3000;


        System.out.println("Welcome to the Patika Order System...." + "\n");

        while (SystemControl){                                                                                              // Uygulamayı başlatır ve işlem seçimlerine göre süreci yönetir.


            System.out.println("Please Choose One Of The Following Options : ");

            System.out.println(                                    // İşlem seçim alanı
                            "Customer List : ------------------------------------------------------- 1" + "\n"+
                            "Create a Customer : --------------------------------------------------- 2" + "\n"+
                            "List customers with the letter c : ------------------------------------ 3" + "\n" +
                            "Create an order : ----------------------------------------------------- 4" + "\n" +
                            "June Invoice : -------------------------------------------------------- 5" + "\n" +
                            "All Invoice : --------------------------------------------------------- 6" + "\n" +
                            "Invoices over 1500 TL : ----------------------------------------------- 7" + "\n" +
                            "Average Invoices over 1500 TL : --------------------------------------- 8" + "\n" +
                            "Names of customers with invoices under 500TL in the system : ---------- 9" + "\n" +
                            "Sectors of companies with an average invoice of less than 750 in June : 10" + "\n" +
                            "Delete a Customer : --------------------------------------------------: 11" + "\n" +
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
                    Thread.sleep(time);
                }
                else {                                                                                                     // Listedeki müşterilerin bilgilerini döner.
                    customers.forEach(c -> {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Name: " + c.getFirstName());
                        System.out.println("Registration Date: " + c.getRegistrationDate());
                        System.out.println("Industry: " + c.getIndustry());
                        System.out.println("-----------------------------");
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
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

                 Customer customerId = customers.stream().filter(m -> m.getId()==id)
                         .findFirst()
                         .orElse(null);

                 if (customerId == null){
                     Customer customer = new Customer(id,name,industry,LocalDate.now());
                     System.out.println("The customer named " + customer.getFirstName() +  " is registered in the system.");
                     customers.add(customer);
                     Thread.sleep(time);
                 }else {
                     System.out.println("There is a customer with this id number, please try again.");
                     Thread.sleep(time);
                 }


            }

            else if (Objects.equals(processNumber, "3")) {                                                             // C harfi bulunan müşterileri listeler
                 boolean customerFound = false;                         // Müşteri bulunup bulunmadığını tutan değişken

                 for (Customer c : customers) {
                     if (c.getFirstName().contains("C") || c.getFirstName().contains("c")) {
                         System.out.println("Customer Name : " + c.getFirstName() +"\n"+ " Customer ID: " + c.getId() +"\n"+ " Customer Industry: " + c.getIndustry()
                                +"\n"+ "Registration Date: "+ c.getRegistrationDate());
                         System.out.println("----------------------------------");
                         Thread.sleep(time);
                         customerFound = true;
                     }
                 }
                 if (!customerFound) {
                     System.out.println("No customer found with the letter 'C' in it.");
                     Thread.sleep(time);
                 }
            }

            else if (Objects.equals(processNumber, "4")) {                                                            // Müşteri id'si üzerinden müşteri siparişi alma

                System.out.println("Please enter the id of the customer you want to trade : ");
                int id = scan.nextInt();

                scan.nextLine();
                Customer customer = customers.stream().filter(m -> m.getId()==id)
                        .findFirst()
                        .orElse(null);

                System.out.println("Product Name : " );
                String productName = scan.nextLine();

                System.out.println("Product Quantity : " );
                int quantity = scan.nextInt();

                System.out.println("Product Price : " );
                int price = scan.nextInt();
                scan.nextLine();

                Order order = new Order(productName,quantity,price, customer,LocalDate.now());
                orders.add(order);
                Invoice invoice = new Invoice(tradeNumber,(quantity*price) + totalAmount,LocalDate.now(),order);
                invoices.add(invoice);

                tradeNumber += 1;
                System.out.println("Customer Name : " + order.getCustomer().getFirstName() +"\n"+ "Product Name : "
                        + order.getProductName() +"\n"+ "Number of Product"
                        + order.getQuantity() +"\n"+ "Total bill : " + invoice.getAmount());
                Thread.sleep(time);
                System.out.println("------------------------");
            }

            else if (Objects.equals(processNumber, "5")) {                                                            // Haziran ayında kayıt olan müşterilerin fatura çıktısı

                 boolean customerFound = false;
                 for (Invoice c : invoices){
                     if (c.getOrder().getCustomer().getRegistrationDate().getMonthValue()==6){
                         customerFound = isCustomersInvoince(c);
                     }
                 }if (!customerFound) {
                     System.out.println("No Invoice found in June.");
                 }
            }

             else if (Objects.equals(processNumber, "6")) {                                                           //Bütün faturaları listelemek için kullanılır.

                boolean customerFound = false;                          // Müşteri bulunup bulunmadığını tutan değişken
                for (Invoice c : invoices) {
                    customerFound = isCustomersInvoince(c);
                }

                if (!customerFound) {
                    System.out.println("No customer found ...");
                    Thread.sleep(time);
                }
            }

             else if (Objects.equals(processNumber, "7")) {                                                            // 1500 üstü faturalar listelenir.

                 boolean customerFound = false;
                 for (Invoice c : invoices){
                     if (c.getAmount() > 1500){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName()
                                 + "Invoince Number : " + c.getInvoiceNumber());
                         customerFound = true;
                         Thread.sleep(time);
                     }
                 }if (!customerFound) {
                     System.out.println("There is no invoice over 1500 TL.");
                 }
             }

             else if (Objects.equals(processNumber, "8")) {                                                            // 1500 Tl üstü fatura ortalaması
                 double average = invoices.stream()
                         .filter(invoice -> invoice.getAmount() > 1500)
                         .mapToDouble(Invoice::getAmount)
                         .average()
                         .orElse(0.0);

                 System.out.println(average);
                 Thread.sleep(time);

                 if (average==0){
                     System.out.println("Since there is no invoice over 1500 TL, average results cannot be obtained.");
                 }
             }

             else if (Objects.equals(processNumber, "9")) {                                                            // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin

                 boolean customerFound = false;
                 for (Invoice c : invoices){
                     if (c.getAmount() < 500){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName() +"\n");
                         customerFound = true;
                         Thread.sleep(time);
                     }
                 }if (!customerFound) {
                     System.out.println("There is no invoice over 500 TL.");
                 }
             }

             else if (Objects.equals(processNumber, "10")) {                                                          // Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.

                 boolean customerFound = false;

                 for (Invoice c : invoices){
                     if (c.getAmount() < 750 && c.getOrder().getOrderDate().getMonthValue()==6){
                         System.out.println("Customer Name : " + c.getOrder().getCustomer().getFirstName()
                                 + "Sector Name : " + c.getOrder().getCustomer().getIndustry());
                         customerFound = true;
                     }
                 }if (!customerFound) {
                     System.out.println("There is no invoice over 750 TL.");
                 }
             }

             else if(Objects.equals(processNumber, "11")){                                                               // Müşteri id'sine göre silme işlemi gerçekleştirilir.
                if (customers.size() == 0){
                    System.out.println("" +"\n"+"\n"+"\n"+"\n");
                    System.out.println("-----------------------------");
                    System.out.println("There is no customer in the list");
                    System.out.println("-----------------------------");
                    System.out.println("Please add a Customer in the list");
                    System.out.println("-----------------------------" +"\n"+"\n"+"\n"+"\n");
                }
                else {
                    System.out.println("Please enter the id number of the customer to be deleted : " );
                    int id = scan.nextInt();
                    scan.nextLine();
                    Customer customer = customers.stream().filter(m -> m.getId()==id)
                            .findFirst()
                            .orElse(null);

                    if (customer != null){
                        customers.remove(customer);
                        System.out.println("Customer detele process is success...");
                        Thread.sleep(time);
                    }else {
                        System.out.println("Customer nor find the list...");
                    }
                }
            }

             else if (Objects.equals(processNumber, "q")) {                                                             // Sistemden çıkış yapılır.
                 SystemControl = false;
                 System.out.println("Patika order system is closing....");
                 Thread.sleep(time);

            }
        }
    }

    private static boolean isCustomersInvoince(Invoice c) throws InterruptedException {
        boolean customerFound;
        System.out.println( "Customer Name: "+c.getOrder().getCustomer().getFirstName() +"\n"+ "Customer ID: "
                + c.getOrder().getCustomer().getId() +"\n"+ "Invoince Number: "
                + c.getInvoiceNumber() +"\n"+ "Amount: " + c.getAmount() +"\n"
                +"Product Name: " +c.getOrder().getProductName() +"\n"+ "Invoince Date: " + c.getDate());
        System.out.println("-----------------------------" +"\n"+"\n"+"\n"+"\n");
        Thread.sleep(3000);
        customerFound = true;
        return customerFound;
    }
}




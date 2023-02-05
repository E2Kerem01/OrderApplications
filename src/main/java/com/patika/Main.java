package com.patika;


import java.time.LocalDate;
import java.util.*;

import static javax.swing.text.html.parser.DTDConstants.ID;

public class Main {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        Boolean SystemControl = true;


        while (SystemControl){                                    // Uygulamayı başlatır ve işlem seçimlerine göre süreci yönetir.

            System.out.println("Welcome to the Patika Order System....");
            System.out.println("Please Choose One Of The Following Options : ");

            System.out.println(                                         // İşlem seçim alanı
                    "Create a Customer : 1" + "\n"+
                    "Delete a Customer : 2" + "\n"+
                    "Customer List : 3" + "\n" +
                    "List customers with the letter c : 4");

            System.out.print("Enter the Process Number : ");
            String processNumber = scan.nextLine();

            System.out.println("-----------------------------");

            if (Objects.equals(processNumber, "1")){                    // Listeye müşteri ekleme işlemi yapar.

                System.out.println("Enter Customer Name : " );
                String name = scan.nextLine();

                System.out.println("Enter Customer ID : " );
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Customer Industry : " );

                String industry = scan.nextLine();

                Customer customer = new Customer(id,name,industry,LocalDate.now());
                System.out.println(customer);
                customers.add(customer);

            }
            else if (Objects.equals(processNumber, "3")) {
                if (customers.size() == 0){                             // Listedeki müşteri sayını kontrol edip cevap döner
                    System.out.println("There is no customer in the list");
                    System.out.println("-----------------------------");
                    System.out.println("Please add a Customer in the list");
                    System.out.println("-----------------------------");
                }
                else {                                               // Listedeki müşterilerin bilgilerini döner.
                    customers.forEach(c -> {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Name: " + c.getFirstName());
                        System.out.println("Registration Date: " + c.getRegistrationDate());
                        System.out.println("Industry: " + c.getIndustry());
                        System.out.println("-----------------------------");
                    });
                }

            }else if(Objects.equals(processNumber, "2")){
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

            } else if (Objects.equals(processNumber, "4")) {                // C harfi bulunan müşterileri listeler
                List<Customer> customerList = customers;                                    // Müşteri listesi
                boolean customerFound = false;                                              // Müşteri bulunup bulunmadığını tutan değişken

                for (Customer c : customerList) {
                    if (c.getFirstName().contains("C") || c.getFirstName().contains("c")) {
                        System.out.println("Customer Name : " + c.getFirstName() + c.getId() + c.getIndustry());
                        customerFound = true;
                    }
                }

                if (!customerFound) {
                    System.out.println("No customer found with the letter 'C' in it.");
                }


            }


        }









    }
}




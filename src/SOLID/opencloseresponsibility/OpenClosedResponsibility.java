package SOLID.opencloseresponsibility;

import java.util.Scanner;

/*
Definition:
As per OCP, Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

This means that the behavior of a module can be extended without modifying its source code. The goal is to reduce the risk of breaking existing functionality when requirements change.
 */

public class OpenClosedResponsibility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();

        // Using invoker to get the appropriate implementation
        Invoice indiaInvoice = new Invoice(amount, new IndiaTaxCalculator());
        System.out.println("Total (India): ₹" + indiaInvoice.getTotalAmount());

        Invoice usInvoice = new Invoice(amount, new USTaxCalculator());
        System.out.println("Total (US): $" + usInvoice.getTotalAmount());

        Invoice ukInvoice = new Invoice(amount, new UKTaxCalculator());
        System.out.println("Total (UK): £" + ukInvoice.getTotalAmount());

        sc.close();
    }
}

class IndiaTaxCalculator implements TaxCalcultor {
    @Override
    public double calculateTax(double amount) {
       return amount * 0.18;
    }
}

class USTaxCalculator implements TaxCalcultor {
    @Override 
    public double calculateTax(double amount) {
        return amount * 0.08;
    }
}

class UKTaxCalculator implements TaxCalcultor {
    @Override 
    public double calculateTax(double amount) {
        return amount * 0.12;
    }
}

// Using dependency Injection
class Invoice {
    private double amount;
    private TaxCalcultor taxCalculator;

    public Invoice(double amount, TaxCalcultor taxCalculator) {
        this.amount = amount;
        this.taxCalculator = taxCalculator;
    }

    public double getTotalAmount() {
        return amount + taxCalculator.calculateTax(amount);
    }
}



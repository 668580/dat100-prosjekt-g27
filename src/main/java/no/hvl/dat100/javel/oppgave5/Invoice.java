package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

import java.util.Arrays;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month


    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {

        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0;

    }

    public void computeAmount() {

        double total = 0;

        switch (c.getAgreement()) {
            case SPOTPRICE:
                total = MonthlyPower.computeSpotPrice(usage, prices);
                break;

            case POWERSUPPORT:
                total = MonthlyPower.computeSpotPrice(usage, prices)
                        - MonthlyPower.computePowerSupport(usage, prices);
                break;

            case NORGESPRICE:
                total = MonthlyPower.computeNorgesPrice(usage);
                break;
        }

        this.amount = total;

    }

    public void printInvoice() {

        System.out.println("Customer number "+c.getCustomerId());
        System.out.println("Name "+c.getName());
        System.out.println("Email+ "+c.getEmail());
        System.out.println("Agreemenr "+c.getAgreement());
        System.out.println();
        System.out.println("Month "+ month);

        double totalUsage = MonthlyPower.computePowerUsage(usage);
        System.out.printf("Usage:%12.2f kWh%n", totalUsage);
        System.out.printf("Amount:%11.2f NOK%n", amount);


    }
}

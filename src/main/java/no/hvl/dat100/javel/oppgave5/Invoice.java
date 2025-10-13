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

        this.customer = c;
        this.month = month;
        this.usage = usage;
        this.power_prices = prices;
        this.amount = 0;

    }

    public void computeAmount() {

        PowerAgreementType agreement = c.getAgreement();
        for(int i = 0; i < usage.length; i++){
            for(int j = 0; j < usage[i].length; j++){
                double u = usage[i][j];
                double p = power_prices[i][j];
                double priceToUse = 0;

                switch(agreement){
                    case SPOTPRICE:
                        priceToUse = p;
                        break;
                    case NORGESPRICE:
                        priceToUse = Power.NORGESPRICE_KWH;
                        break;
                    case

                }

            }

        }

    }

    public void printInvoice() {

        // TODO

    }
}

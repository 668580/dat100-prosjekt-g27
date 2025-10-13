package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        double[][] usage = MonthPowerData.powerusage_month;
        double[][] prices = MonthPowerData.powerprices_month;

        // 2) Lag noen kunder (juster til din Customer-konstruktør)
        Customer c1 = new Customer("Charlie Rose", "charlie@example.com", 1003, PowerAgreementType.POWERSUPPORT);
        Customer c2 = new Customer("Diana Prince", "diana@example.com", 1004, PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer("Ethan Hunt", "ethan@example.com", 1005, PowerAgreementType.SPOTPRICE);

        // 3) Lag fakturaer for måneden (samme data, ulike avtaler)
        Invoice i1 = new Invoice(c1, "January", usage, prices);
        Invoice i2 = new Invoice(c2, "January", usage, prices);
        Invoice i3 = new Invoice(c3, "January", usage, prices);

        // 4) Prosesser og skriv ut alle fakturaer
        Invoice[] invoices = { i1, i2, i3 };
        Invoices.processInvoices(invoices);

    }
}

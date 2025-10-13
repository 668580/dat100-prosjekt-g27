package no.hvl.dat100.javel.oppgave5;

public class Invoices {

    public static void processInvoices(Invoice[] invoices) {

        for(Invoice i : invoices){
            System.out.println("========================");

            //beregne beløpet for fakturaen
            i.computeAmount();

            //printe ut fakturaenen
            i.printInvoice();

            System.out.println("========================");
            System.out.println();
        }

    }
}

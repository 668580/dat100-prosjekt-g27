package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        Customer c1 = new Customer("Alice Smith", "alice@example.com", 1001, PowerAgreementType.SPOTPRICE);

        // 🔹 Tester toString()
        System.out.println("== Original kunde ==");
        System.out.println(c1);

        // 🔹 Tester get-metoder
        System.out.println();
        System.out.println("Navn: " + c1.getName());
        System.out.println("E-post: " + c1.getEmail());
        System.out.println("Kunde-ID: " + c1.getCustomerId());
        System.out.println("Avtale: " + c1.getAgreement());

        // 🔹 Tester set-metoder (endrer verdier)
        c1.setName("Alice Smith");
        c1.setEmail("alice@example.com");
        c1.setAgreement(PowerAgreementType.SPOTPRICE);

        // 🔹 Skriver ut igjen for å sjekke endringer
        System.out.println();
        System.out.println("== Etter endringer ==");
        System.out.println(c1);
    }
}

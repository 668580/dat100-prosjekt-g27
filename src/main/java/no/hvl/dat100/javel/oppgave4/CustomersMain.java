package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4 – TEST AV CUSTOMERS-KLASSEN");
        System.out.println("==============");
        System.out.println();

        // Oppretter en Customers-tabell med plass til 5 kunder
        Customers customerList = new Customers(5);

        // Oppretter noen testkunder
        Customer c1 = new Customer("Alice Myrde", "alice@example.com", 1001, PowerAgreementType.SPOTPRICE);
        Customer c2 = new Customer("Kari Nordmann", "kari.nordmann@gmail.com",1002, PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer("Ali Khan", "a.khan@icloud.com",1003,PowerAgreementType.SPOTPRICE);

        // ---- TEST: addCustomer ----
        System.out.println("Legger til kunder i listen...");
        customerList.addCustomer(c1);
        customerList.addCustomer(c2);
        customerList.addCustomer(c3);

        System.out.println("Antall kunder nå: " + customerList.countNonNull());
        System.out.println();

        // ---- TEST: getCustomer ----
        System.out.println("Henter kunde med ID 1002:");
        Customer found = customerList.getCustomer(1002);
        if (found != null) {
            System.out.println("Fant kunde: " + found.getCustomerId() + " - " + found.getName());
        } else {
            System.out.println("Ingen kunde funnet med ID 1002");
        }
        System.out.println();

        // ---- TEST: getCustomers ----
        System.out.println("Liste over alle aktive kunder:");
        for (Customer c : customerList.getCustomers()) {
            System.out.println(c.getCustomerId() + " - " + c.getName() + " (" + c.getAgreement() + ")");
        }
        System.out.println();

        // ---- TEST: removeCustomer ----
        System.out.println("Sletter kunde med ID 1001...");
        Customer removed = customerList.removeCustomer(1001);
        if (removed != null) {
            System.out.println("Fjernet kunde: " + removed.getCustomerId() + " - " + removed.getName());
        } else {
            System.out.println("Fant ingen kunde å slette med ID 1001");
        }
        System.out.println();

        // ---- Etter sletting: sjekk status ----
        System.out.println("Antall kunder etter sletting: " + customerList.countNonNull());
        System.out.println("Gjenværende kunder:");
        for (Customer c : customerList.getCustomers()) {
            System.out.println(c.getCustomerId() + " - " + c.getName());
        }

        System.out.println();
        System.out.println("== Ferdig testet alle metoder i Customers-klassen ==");
    }
}

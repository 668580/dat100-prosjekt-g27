package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor
    public Customers(int size) {
        this.customers = new Customer[size];

    }

    // b) count number of non-null references
    public int countNonNull() {

        int count = 0;
        for(Customer customer : customers) {
            if(customer != null){
                count++;
            }
        }
        return count;
    }

    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {
        for(Customer c : customers) {
            if (c != null && c.getCustomerId() == customer_id) {
                return c;
            }
        }
        return null;
    }

    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {


        for(int i = 0; i < customers.length; i++) {
            if(customers[i] == null) {
                customers[i] = c;
                return true;
            }
        }

        return false;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;

        for(int i = 0; i < customers.length; i++) {
            if(customers[i] != null && customers[i].getCustomerId() == customer_id) {
             Customer c = customers[i];
             customers[i] = null;
                return c;
            }
        }

        return null;
    }

    // f) return reference table with all customers
    public Customer[] getCustomers() {

        //tell antall kunder
        int count = 0;
        for(Customer c : customers){
            if(c != null){
                count++;
            }
        }
        //ny tabell
        Customer[] newCustomers = new Customer[count];

        //fyll ny tabell
        int j = 0;
        for(Customer c : customers){
            if(c != null){
                newCustomers[j] = c;
                j++;
            }
        }

        return newCustomers;
    }
}
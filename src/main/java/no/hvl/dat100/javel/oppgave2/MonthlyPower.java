package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {
        // skriver ut strømforbruket for måneden basert på innholdet av den
        // 2-dimensjonale tabellen som er gitt med som parameter
        for(int i=0; i < usage.length; i++){
            System.out.print("Day " + (i + 1) + ":");
                DailyPower.printPowerUsage(usage[i]); // fra oppgave 1
                System.out.println();;
        }
    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {
       for(int i=0; i < prices.length; i++) {
           System.out.print("Day " + (i + 1) + ":");
           DailyPower.printPowerPrices(prices[i]); // fra oppgave 1
           System.out.println();
           ;
       }
    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;
        for(int i=0; i<usage.length; i++){
            sum += DailyPower.computePowerUsage(usage[i]);;
        }
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double usage = computePowerUsage(powerusage);
        if(usage > threshold){
              exceeded = true;
        }
        return exceeded;
    }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;
        for(int i=0; i < usage.length; i++){
                price += DailyPower.computeSpotPrice(usage[i], prices[i]);
            }
        return price;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;
        for(int i=0; i < usage.length; i++){
            support += DailyPower.computePowerSupport(usage[i], prices[i]);
        }

        return support;
    }

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;
        for(double[] day : usage){
            price += DailyPower.computeNorgesPrice(day);
        }
        return price;
    }
}

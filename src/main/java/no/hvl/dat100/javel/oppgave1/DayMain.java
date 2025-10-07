package no.hvl.dat100.javel.oppgave1;

import java.util.Arrays;

public class DayMain {

    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;
        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1 – Dagsdata");
        System.out.println("==============\n");

        // 1) Skriv ut rådata (valgfritt – nyttig for feilsøking)
        System.out.println("Usage (kWh per time): " + Arrays.toString(powerusage_day));
        System.out.println("Prices (kr/kWh per time): " + Arrays.toString(powerprices_day));
        System.out.println();

        // 2) a) Skrive ut priser med to desimaler
        System.out.println("a) printPowerPrices:");
        DailyPower.printPowerPrices(powerprices_day);
        System.out.println("\n");

        // 3) b) (hvis du har en printPowerUsage – ikke alltid påkrevd)
        System.out.println("b) printPowerUsage:");
        DailyPower.printPowerUsage(powerusage_day);
        System.out.println("\n");

        // 4) c) Spotpris (total kostnad ved spot)
        double totalSpot = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("c) Total spotpris for dagen: %.3f kr%n%n", totalSpot);

        // 5) e) Strømstøtte totalt (bruker getSupport internt)
        double totalSupport = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("e) Total strømstøtte for dagen: %.3f kr%n%n", totalSupport);

        // 6) g) Norgespris (fastpris 0.50 kr/kWh)
        double totalNorges = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.printf("g) Total med Norgespris (0.50 kr/kWh): %.3f kr%n%n", totalNorges);

        // 7) Største timesforbruk
        double peak = DailyPower.findPeakUsage(powerusage_day);
        System.out.printf("Største timesforbruk: %.3f kWh%n%n", peak);

        // 8) Gjennomsnittlig timesforbruk
        double avg = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("Gjennomsnittlig forbruk per time: %.3f kWh%n%n", avg);



    }
}

package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthMain {
    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;
        double[][] power_usage_month  = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2 – MANUELLE TESTER");
        System.out.println("==============");
        System.out.println();

        // a) Print forbruk per dag
        System.out.println("a) print_PowerUsage:");
        MonthlyPower.print_PowerUsage(power_usage_month);
        System.out.println();

        // b) Print priser per dag
        System.out.println("b) print_PowerPrices:");
        MonthlyPower.print_PowerPrices(power_prices_month);
        System.out.println();

        // c) Total månedsforbruk
        double totalUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("c) Total power usage (kWh): %.2f%n", totalUsage);

        // d) Sjekk terskel
        double lowThreshold  = totalUsage - 0.01;
        double highThreshold = totalUsage + 0.01;
        System.out.println("d) exceedThreshold (low):  " + MonthlyPower.exceedThreshold(power_usage_month, lowThreshold));  // forventer true
        System.out.println("d) exceedThreshold (high): " + MonthlyPower.exceedThreshold(power_usage_month, highThreshold)); // forventer false

        // e) Spotpris (uten støtte)
        double monthSpot = MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month);
        System.out.printf("e) Spot price (NOK): %.2f%n", monthSpot);

        // f) Strømstøtte for måneden
        double monthSupport = MonthlyPower.computePowerSupport(power_usage_month, power_prices_month);
        System.out.printf("f) Power support (NOK): %.2f%n", monthSupport);

        // g) Norgespris (flat pris pr kWh)
        double monthNorges = MonthlyPower.computeNorgesPrice(power_usage_month);
        System.out.printf("g) Norges price (NOK): %.2f%n", monthNorges);

        // Ekstra: kryssjekk dag 1 bare som sanity-check
        if (power_usage_month.length > 0) {
            double d1Usage     = DailyPower.computePowerUsage(power_usage_month[0]);
            double d1Spot      = DailyPower.computeSpotPrice(power_usage_month[0], power_prices_month[0]);
            double d1Support   = DailyPower.computePowerSupport(power_usage_month[0], power_prices_month[0]);
            double d1Norges    = DailyPower.computeNorgesPrice(power_usage_month[0]);
            System.out.println();
            System.out.printf("Dag 1 – usage: %.2f, spot: %.2f, support: %.2f, norges: %.2f%n",
                    d1Usage, d1Spot, d1Support, d1Norges);
        }
    }
}

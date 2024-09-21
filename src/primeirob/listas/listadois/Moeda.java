package primeirob.listas.listadois;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Moeda {

    static String[] moedas = {"USD", "EUR", "JPY", "GBP", "BRL"};
    static double[] taxas = {1.0, 0.85, 110.0, 0.75, 5.4};

    public static int findCurrencyIndex(String currency) {
        for (int i = 0; i < moedas.length; i++) {
            if (moedas[i].equalsIgnoreCase(currency)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Moeda não suportada: " + currency);
    }

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        int fromIndex = findCurrencyIndex(fromCurrency);
        int toIndex = findCurrencyIndex(toCurrency);

        double valorEmUSD = amount / taxas[fromIndex];
        return valorEmUSD * taxas[toIndex];
    }

    public static String formatCurrency(double value, String currency) {
        NumberFormat formato;

        switch (currency.toUpperCase()) {
            case "BRL" -> formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            case "USD" -> formato = NumberFormat.getCurrencyInstance(Locale.US);
            case "EUR" -> formato = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            case "GBP" -> formato = NumberFormat.getCurrencyInstance(Locale.UK);
            case "JPY" -> formato = NumberFormat.getCurrencyInstance(Locale.JAPAN);
            default -> throw new IllegalArgumentException("Moeda não suportada para formatação: " + currency);
        }
        return formato.format(value);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o valor: ");
            double valor = sc.nextDouble();
            System.out.print("Moeda de origem (USD, EUR, JPY, GBP, BRL): ");
            String moedaOrigem = sc.next();
            System.out.print("Moeda de destino (USD, EUR, JPY, GBP, BRL): ");
            String moedaDestino = sc.next();
        try {
            double valorConvertido = convert(valor, moedaOrigem, moedaDestino);
            String resultado = formatCurrency(valorConvertido, moedaDestino);
            System.out.println(formatCurrency(valor, moedaOrigem) + " é equivalente a " + resultado + " " + moedaDestino);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
        }
    }
}
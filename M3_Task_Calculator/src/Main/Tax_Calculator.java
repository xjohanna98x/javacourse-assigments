package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tax_Calculator {
    public static void main(String[] args) {
        List<Double> incomes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter weekly income (or 'done' to finish): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("done")) {
                break;
            } else {
                try {
                    double income = Double.parseDouble(input);
                    incomes.add(income);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        scanner.close();

        if (incomes.isEmpty()) {
            System.out.println("No income data provided.");
        } else {
            double averageWithholding = calculateWeeklyAverageTaxWithholding(incomes);
            System.out.printf("Weekly Average Tax Withholding: $%.2f%n", averageWithholding);
        }
    }

    public static double calculateTaxWithholding(double income) {
        double taxRate;
        if (income < 500) {
            taxRate = 0.10;
        } else if (income >= 500 && income <= 1500) {
            taxRate = 0.15;
        } else if (income >= 1500 && income <= 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }
        return income * taxRate;
    }

    public static double calculateWeeklyAverageTaxWithholding(List<Double> incomes) {
        double totalWithholding = 0;
        for (double income : incomes) {
            totalWithholding += calculateTaxWithholding(income);
        }
        return totalWithholding / incomes.size();
    }
}

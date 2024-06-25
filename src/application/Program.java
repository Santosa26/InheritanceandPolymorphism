package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();
        
        System.out.println("Enter the number of taxpayers: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            
            System.out.println("Taxpayer #" + (i+1) + " data:" );
            System.out.print("Individual or camppany (i/c) ? ");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Anual income: ");
            Double anualIncome = sc.nextDouble();
            if (type == 'i'){
                System.out.println("Health expenditures: ");
                Double health = sc.nextDouble();
                Individual x = new Individual(name, anualIncome, health);
            } else {
                System.out.println("Number of employee: ");
                Integer numberOfEmployee = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployee));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        for (TaxPayer tp : list){
            System.out.print((tp.getName() + ": $ " + String.format("%.2f", tp.tax())));
        }

        double sum = 0.0;
        for (TaxPayer tp : list){
            sum += tp.tax();
        }
        System.out.print((tp.getName() + ": $ " + String.format("%.2f", sum)));


        sc.close();
    }

}

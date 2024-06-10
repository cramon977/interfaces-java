package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Register;
import model.services.Installment;
import model.services.PaypalTax;

public class Program {
	public static void main (String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter with contract number : ");
		int contractNumber = sc.nextInt();
		System.out.print("Enter with cantract date (dd/MM/yyyy): ");
		LocalDate date =  LocalDate.parse(sc.next(), fmt);
		System.out.print("Enter with total value contract: ");
		double value = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, date, value );
		
		
		System.out.print("How many months do you want to pay in installments? ");
		int portion = sc.nextInt();
		
		Installment inst = new Installment( portion, new PaypalTax());
		
		inst.installment(contract);
		
		System.out.println("Portions:");
		
		for (Register r : inst.list) {
			System.out.println(r);
		}
		
		
	}
}

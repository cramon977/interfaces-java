package model.services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Register;



public class Installment {
		
	private Integer portionNumber;
	private ServicePay servicePay;
	
	public List<Register> list = new ArrayList<>();

	public Installment(Integer portion, ServicePay servicePay) {
		this.portionNumber = portion;
		this.servicePay = servicePay;
	}

	public Integer getPortion() {
		return portionNumber;
	}

	public void setPortion(Integer portion) {
		this.portionNumber = portion;
	}
	
	public void installment(Contract contract) {
		
		double portionValue = contract.getContractValue() / portionNumber;

		
		for(int i = 1; i<=this.portionNumber; i++) {
		
			double portionTax = servicePay.taxPay(portionValue, i);
			LocalDate portionDate = contract.getContractDate().plusMonths(i);
			
			contract.setRegister(new Register(portionDate, portionTax));
			list.add(contract.getRegister());
			
		}
	}
	
		
	
}

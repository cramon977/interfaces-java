package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Register {
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate portionDate;
	private Double portionValue;
	
	
	
	public Register(LocalDate portionDate, Double portionValue) {
		this.portionDate = portionDate;
		this.portionValue = portionValue;
	}

	public LocalDate getPortionDate() {
		return portionDate;
	}

	public void setPortionDate(LocalDate portionDate) {
		this.portionDate = portionDate;
	}

	public Double getPortionValue() {
		return portionValue;
	}

	public void setPortionValue(Double portionValue) {
		this.portionValue = portionValue;
	}

	@Override
	public String toString() {
		return fmt.format(portionDate) + " - R$ "+ String.format("%.2f", portionValue);
	}
}

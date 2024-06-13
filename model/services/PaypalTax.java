package model.services;

public class PaypalTax implements TaxService {
	@Override
	public Double taxPay(double value, int portionNum) {
		
		double tax;
			tax = value * (0.01 * portionNum);
			value += tax ;
			value  *= 1.02;
			return value;
	}
}

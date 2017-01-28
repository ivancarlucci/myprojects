package myprojects.project;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import myprojects.project.model.Product;
import myprojects.project.model.Receipt;

public class PurchaseController {

	private Receipt receipt;
	
	public PurchaseController(){
		receipt = new Receipt();
	}
	
	public void purchaseProduct(Product product) {
		receipt.getProductsList().add(product);
	}

	public void calculateTotalPrice() {
		double totalPrice = 0;
		for(Product p: receipt.getProductsList()){
			double salesTaxRounded = calculateSalesTaxes(p);
			double importTaxesRounded = calculateImportTaxes(p);
			double totalPriceSingleItem = calculateSingleItemPriceWithTaxes(p, salesTaxRounded, importTaxesRounded);
			BigDecimal temp1 = toHaveTwoDecimalDigits(totalPriceSingleItem);
			totalPrice = totalPrice + temp1.doubleValue();
		}
		receipt.setTotalPrice(toHaveTwoDecimalDigits(totalPrice).doubleValue());
	}

	public void calculateTotalTax() {
		double totalTax = 0;
		for(Product p: receipt.getProductsList()){
			totalTax = totalTax + p.getPrice()*p.getImportTaxes() + p.getPrice()*p.getSalesTax();
		}
		receipt.setTotalTaxes(toRoundNearest005(totalTax));
	}
	
	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	private BigDecimal toHaveTwoDecimalDigits(double totalPriceSingleItem) {
		BigDecimal temp1 = new BigDecimal(totalPriceSingleItem);
		temp1 = temp1.round(new MathContext(4, RoundingMode.HALF_UP));
		return temp1;
	}

	private double calculateSingleItemPriceWithTaxes(Product p, double salesTaxRounded, double importTaxesRounded) {
		BigDecimal temp = new BigDecimal(p.getPrice()+importTaxesRounded + salesTaxRounded);
		p.setPriceWithTax((temp.round(new MathContext(4, RoundingMode.HALF_UP))).doubleValue());
		double totalPriceSingleItem = (importTaxesRounded + salesTaxRounded) + p.getPrice()*p.getQuantity();
		return totalPriceSingleItem;
	}

	private double calculateImportTaxes(Product p) {
		double importTaxes = p.getPrice()*p.getImportTaxes();
		double importTaxesRounded = 0;
		if(p.getImportTaxes()!=0){
			importTaxesRounded = toRoundNearest005(importTaxes);
		}else{
			importTaxesRounded = importTaxes;
		}
		return importTaxesRounded;
	}

	private double calculateSalesTaxes(Product p) {
		double salesTaxes = p.getPrice()*p.getSalesTax();
		double salesTaxesRounded = 0;
		if(p.getSalesTax()!=0){
			salesTaxesRounded = toRoundNearest005(salesTaxes);
		}else{
			salesTaxesRounded = salesTaxes;
		}
		return salesTaxesRounded;
	}

	private double toRoundNearest005(double salesTaxes) {
		return Math.ceil(salesTaxes / 0.05) * 0.05;
	}

}

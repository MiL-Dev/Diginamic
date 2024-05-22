package fr.diginamic.banque.utils;

public class Debit extends Operation {
	
	public Debit(String date, int ammout) {
		super(date, ammout);
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "DEBIT";
	}
}

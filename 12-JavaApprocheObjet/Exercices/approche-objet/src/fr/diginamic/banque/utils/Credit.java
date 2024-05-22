package fr.diginamic.banque.utils;

public class Credit extends Operation {

	public Credit(String date, int ammout) {
		super(date, ammout);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "CREDIT";
	}
}

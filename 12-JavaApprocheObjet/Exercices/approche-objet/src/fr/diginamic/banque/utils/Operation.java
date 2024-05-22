package fr.diginamic.banque.utils;

public abstract class Operation {
	String dateOp;
	int ammoutOp;
	public Operation (String date, int ammout) {
		dateOp = date;
		if(getType() == "CREDIT") {
			ammoutOp += ammout;
		}else {
			ammoutOp -= ammout;
		}
		
	}
	public abstract String getType(); //Toutes les filles qui utilise cette classe ont l'obligation de cree cette methode.
	
	public String getDateOp() {
		return dateOp;
	}
	public void setDateOp(String dateOp) {
		this.dateOp = dateOp;
	}
	public int getAmmoutOp() {
		return ammoutOp;
	}
	public void setAmmoutOp(int ammoutOp) {
		this.ammoutOp = ammoutOp;
	}
}

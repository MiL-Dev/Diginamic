package fr.diginamic.banque.entites;

public class Compte {
	private int idAccount;
	private double bankBalance;
	
	public Compte(int idAccount, double bankBalance) {
		this.idAccount = idAccount;
		this.bankBalance = bankBalance;
	}
	
	@Override
	public String toString() {
		return "Numero de compte : " + this.idAccount + "\nSolde : "+ this.bankBalance+"$";
	}
	public void setbankBalance(int bankBalance) {
		this.bankBalance += bankBalance;
	}
	
}

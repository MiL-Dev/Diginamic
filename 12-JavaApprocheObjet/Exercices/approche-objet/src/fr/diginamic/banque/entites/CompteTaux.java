package fr.diginamic.banque.entites;

public class CompteTaux extends Compte {
	private int remunerationRate;
	
	public CompteTaux(int idAccount, double bankBalance, int remunerationRate ) {
		// TODO Auto-generated method stub
		super(idAccount, bankBalance);
		this.remunerationRate = remunerationRate;
	}
	
	//Override signifie qu'on modifie la methode de la classe mere
	@Override
	public String toString() {
		return super.toString()+ "\nTaux : " + remunerationRate + "%";
	}

}

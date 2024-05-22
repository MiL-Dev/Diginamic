package fr.diginamic.banque;

import fr.diginamic.banque.utils.*;
import fr.diginamic.banque.entites.*;
public class TestOperation {
	
	public static void main(String[] args) {
		Compte account = new Compte(21345, 1000);
		Operation[] op = new Operation[4];
		op[0] = new Credit("2024/05/03", 100);
		op[1] = new Credit("2021/03/25", 100);
		op[2] = new Debit("2022/10/30", 50);
		op[3] = new Debit("2024/12/22", 100);
		
		for(Operation o : op) {
			account.setbankBalance(o.getAmmoutOp());
			System.out.println(account.toString());
		}
		
	}
	
}

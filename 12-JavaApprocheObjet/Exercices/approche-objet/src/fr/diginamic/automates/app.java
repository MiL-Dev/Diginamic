package fr.diginamic.automates;


public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JeuDeLaVie game = new JeuDeLaVie();
		game.setTray(3, 3);
		game.setCell(1, 0, true);
		game.setCell(1, 1, true);
		game.setCell(1, 2, true);
		
		game.next();
		
	}

}

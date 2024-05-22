package fr.algorithmie;

public class AffichageSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("for");
		System.out.println(" --------------- \n");
		for(int i=1; i <= 10; i++) {
			System.out.println(i);
			
		}
		
		System.out.println("\n --------------- \n");
		for(int i=1; i <= 10; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			
		}
		
		System.out.println("\n --------------- \n");
		for(int i=1; i <= 10; i++) {
			if(i%2 == 1) {
				System.out.println(i);
			}
			
		}
		
		System.out.println("\nwhile");
		System.out.println("\n --------------- \n");
		int y = 1;
		while(y <= 10) {
			System.out.println(y);
			y++;
		}
		
		System.out.println("\n --------------- \n");
		y = 1;
		while(y <= 10) {
			if(y%2 == 0) {
				System.out.println(y);
			}
			y++;
		}
		System.out.println("\n --------------- \n");
		y = 1;
		while(y <= 10) {
			if(y%2 == 1) {
				System.out.println(y);
			}
			y++;
		}
	}

}

package fr.diginamic.automates;

public class JeuDeLaVie {
	int rows;
    int columns;
    Boolean[][] tray;
    
	public void setTray(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.tray = new Boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	        	tray[i][j] = false;
	        }
	    }
	    
	}
	public Boolean[][] setCell(int x, int y, boolean status) {
		if(status) {
			tray[x][y] = true;
		}else {
			tray[x][y] = false;

		}
		return tray;
	}
	
	public void displayTray() {
		for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	        	if(tray[i][j]== true) {
	        		System.out.print("X|");
	        	}else {
	        		System.out.print (" |");
	        	}
	        	
	            
	        }
	        System.out.println();
	    }
	}
	
	public void next() {
		displayTray();
		survival();
		death();
		birth();
		System.out.println();
		displayTray();
	}
	public int countStatus(int x, int y) {
		int count = 0;
		for (int  i = x - 1; i <= x + 1; i++) {
			for ( int j = y - 1; j <= y + 1; j++) {
				if (this.tray[i][j] == true) {
					count++;
				}
			}
		}
		return count;
	}
	
	public void survival() {
		for(int i =1; i < this.rows-1; i++) {
			for(int j =1; j < this.columns-1; j++) {
				int count = countStatus(i, j);	
				if(count ==  2 || count ==3 ){
					setCell(i,j, true);
				}
			}
			
		}
	}
	public void death() {
		for(int i =1; i < this.rows-1; i++) {
			for(int j =1; j < this.columns-1; j++) {
				int count = countStatus(i, j);	
				if(count > 4 || count < 2) {
					setCell(i,j, false);
				}
			}
		}
	}
	public void birth() {
		for(int i =1; i < this.rows-1; i++) {
			for(int j =1; j < this.columns-1; j++) {
				int count = countStatus(i, j);	
				if(count == 3) {
					setCell(i,j, true);
				}
			}
			
		}
	}
	
}

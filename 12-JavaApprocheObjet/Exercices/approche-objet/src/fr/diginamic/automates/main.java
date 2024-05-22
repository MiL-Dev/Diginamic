package fr.diginamic.automates;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int col = 10;
		int row = 10;
		
		int[][] map = setTray(row, col);
		int i = 0;
		while(i < 10) {
			map = update(map, row, col);
			System.out.println();
			i++;
		}
	}
	
	public static int[][] setTray(int rows, int columns) {

		int[][] tray = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	        	tray[i][j] = (int)Math.floor(Math.random() * 2);
	        }
	    }
	    return tray;
	}
	
	public static void draw (int[][] map , int row, int col) {
		for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	        	if(map[i][j]== 1) {
	        		System.out.print("X|");
	        	}else {
	        		System.out.print (" |");
	        	}
	        }
	        System.out.println();
	    }
	}
	
	public static int[][] update(int[][] previousMap, int row, int col) {
		
		int[][] mapClone = setTray( row, col);
		
		draw(previousMap, row, col);
		
		
		
		int totalTop = 0;
		int totalMiddle = 0;
		int totalBottom = 0;
		int total = 0;
		
		//start for
		for(int i =0; i < row; i++) {
			for(int j =0; j < col; j++) {
				int topLeft = 0;
				int topRight = 0;
				int topMiddle = 0;
				
				int middleLeft = 0;
				int middleRight = 0;
				
				int bottomRight = 0;
				int bottomMiddle = 0;
				int bottomLeft = 0;
				
				
				
				if(i == 0) {
					if(j == 0) {
						middleRight = previousMap[i][j+1];
						bottomMiddle = previousMap[i+1][j];
						bottomRight = previousMap[i+1][j+1];
					}
					else if(j == col-1) {
						
						middleLeft = previousMap[i][j-1];
						bottomMiddle = previousMap[i+1][j];
						bottomLeft = previousMap[i+1][j-1];
					}
					else {
						middleLeft = previousMap[i][j-1];
						middleRight = previousMap[i][j+1];
						bottomMiddle = previousMap[i+1][j];
						bottomRight = previousMap[i+1][j+1];
						bottomLeft = previousMap[i+1][j-1];

					}
				}
				else if(i == row-1) {
					if(j == 0) {
						middleRight = previousMap[i][j+1];
						topMiddle = previousMap[i-1][j];
						topRight = previousMap[i-1][j+1];
					}
					else if(j == col-1) {
						middleLeft = previousMap[i][j-1];
						topMiddle = previousMap[i-1][j];
						topLeft = previousMap[i-1][j-1];
					}
					else {
						middleLeft = previousMap[i][j-1];
						middleRight = previousMap[i][j+1];
						topMiddle = previousMap[i-1][j];
						topRight = previousMap[i-1][j+1];
						topLeft = previousMap[i-1][j-1];

					}
				}
				else  {
					if(j == 0) {
						middleRight = previousMap[i][j+1];
						topMiddle = previousMap[i-1][j];
						topRight = previousMap[i-1][j+1];
						bottomMiddle = previousMap[i+1][j];
						bottomRight = previousMap[i+1][j+1];
					}
					else if(j == col-1) {
						middleLeft = previousMap[i][j-1];
						topMiddle = previousMap[i-1][j];
						topLeft = previousMap[i-1][j-1];
						bottomMiddle = previousMap[i+1][j];
						bottomLeft = previousMap[i+1][j-1];
					}
					else {
						middleLeft = previousMap[i][j-1];
						middleRight = previousMap[i][j+1];
						topMiddle = previousMap[i-1][j];
						topRight = previousMap[i-1][j+1];
						topLeft = previousMap[i-1][j-1];
						bottomMiddle = previousMap[i+1][j];
						bottomRight = previousMap[i+1][j+1];
						bottomLeft = previousMap[i+1][j-1];

					}
				}
				
				totalTop = topLeft + topRight + topMiddle;
				totalBottom = bottomLeft + bottomRight + bottomMiddle;
				totalMiddle = middleLeft + middleRight;

				
				total = totalTop + totalBottom + totalMiddle;
				
				
				
				switch(previousMap[i][j]) {
				case 1 :
					if(total < 2  ) {
						mapClone[i][j] = 0;
					}
					if(total == 2 || total == 3) {
						mapClone[i][j] = 1;
					}
					if( total > 3) {
						mapClone[i][j] = 0;
					}
					break;
				default :
					if(total < 3 || total > 3 ) {
						mapClone[i][j] = 0;
					}
					if(total == 3 ) {
						mapClone[i][j] = 1;
					}
					break;
				}

			}
			
		}
		//end for
		return mapClone;
		
	}
	
}

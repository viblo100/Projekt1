package rover;

public class Rover {
	
	static char[][] mars = rover.MarsMap.mars;
	
	/*Abfrage wie der Rover sich bewegen muss, nach den übergebenen Argumenten*/
	public static void moveRover(char command) {
		int[] pos = searchRover();
		if (command == 'f') {
			goForward(pos);									
		} else if (command== 'b') {
			goBackward(pos);		
		} else if (command == 'l') {
			goLeft(pos);
		} else if (command == 'r') {
			goRight(pos);
		}
	}
	
	public static void goForward(int[] pos) {
		if(pos[0] > 0 && pos[1] > 0 && pos[0] < rover.MarsMap.x -1 && pos[1] < rover.MarsMap.y -1 ) {	//Abfrage ob der Rover am Rand der Karte steht.
			if (mars[pos[0]][pos[1]] == '^' && !(mars[pos[0]-1][pos[1]] == '#')) {
				mars[pos[0]-1][pos[1]] = '^';
				mars[pos[0]][pos[1]] = ' ';
			}
			else if (mars[pos[0]][pos[1]] == 'V' && !(mars[pos[0]+1][pos[1]] == '#')) {
				mars[pos[0]+1][pos[1]] = 'V';
				mars[pos[0]][pos[1]] = ' ';	
			}
			else if (mars[pos[0]][pos[1]] == '<' && !(mars[pos[0]][pos[1]-1] == '#')) {
				mars[pos[0]][pos[1]-1] = '<';
				mars[pos[0]][pos[1]] = ' ';
			}
			else if (mars[pos[0]][pos[1]] == '>' && !(mars[pos[0]][pos[1]+1] == '#')) {
					mars[pos[0]][pos[1]+1] = '>';
					mars[pos[0]][pos[1]] = ' ';
			}
		} else {
			System.out.println("ERROR: Rover reached end of Map!");
			System.exit(0);
		}
	}
	
	public static void goBackward(int[] pos) {
		if(pos[0] > 0 && pos[1] > 0 && pos[0] < rover.MarsMap.x -1 && pos[1] < rover.MarsMap.y -1 ) {	//Abfrage ob der Rover am Rand der Karte steht.
			if (mars[pos[0]][pos[1]] == '^' && !(mars[pos[0]+1][pos[1]] == '#')) {
				mars[pos[0]+1][pos[1]] = '^';
				mars[pos[0]][pos[1]] = ' ';
			}
			else if (mars[pos[0]][pos[1]] == 'V' && !(mars[pos[0]-1][pos[1]] == '#')) {
				mars[pos[0]-1][pos[1]] = 'V';
				mars[pos[0]][pos[1]] = ' ';	
			}
			else if (mars[pos[0]][pos[1]] == '<' && !(mars[pos[0]][pos[1]+1] == '#')) {
				mars[pos[0]][pos[1]+1] = '<';
				mars[pos[0]][pos[1]] = ' ';
			}
			else if (mars[pos[0]][pos[1]] == '>' && !(mars[pos[0]][pos[1]-1] == '#')) {
					mars[pos[0]][pos[1]-1] = '>';
					mars[pos[0]][pos[1]] = ' ';
			}
		} else {
			System.out.println("ERROR: Rover reached end of Map!");
			System.exit(0);
		}
	}
	
	public static void goLeft(int[] pos) {
		if (mars[pos[0]][pos[1]] == '^')
			mars[pos[0]][pos[1]] = '<';
		else if (mars[pos[0]][pos[1]] == '<')
			mars[pos[0]][pos[1]] = 'V';
		else if (mars[pos[0]][pos[1]] == 'V')
			mars[pos[0]][pos[1]] = '>';
		else if (mars[pos[0]][pos[1]] == '>')
			mars[pos[0]][pos[1]] = '^';
	}
	
	public static void goRight(int[] pos) {
		if (mars[pos[0]][pos[1]] == '^')
			mars[pos[0]][pos[1]] = '>';
		else if (mars[pos[0]][pos[1]] == '<')
			mars[pos[0]][pos[1]] = '^';
		else if (mars[pos[0]][pos[1]] == 'V')
			mars[pos[0]][pos[1]] = '<';
		else if (mars[pos[0]][pos[1]] == '>')
			mars[pos[0]][pos[1]] = 'V';
	}
	
	/*Sucht den Rover und gibt die aktuelle Position zurück*/
	private static int[] searchRover() {
		int x = rover.MarsMap.x;
		int y = rover.MarsMap.y;
		int[] pos = {-1,-1};
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(mars[i][j] != '#' && mars[i][j] != ' ') {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		if(pos[0] > -1) {
			return pos;
		} else {
			throw new IllegalStateException("Rover missing in action");
		}
	}
	
}

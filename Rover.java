package rover;

public class Rover {
	
	static char[][] mars = rover.MarsMap.mars;
	
	/*Abfrage wie der Rover sich bewegen muss, nach den übergebenen Argumenten*/
	public static void moveRover(char c) {
		int[] p = searchRover();
		if (c == 'f') {
			goForward(p);									
		} else if (c == 'b') {
			goBackward(p);		
		} else if (c == 'l') {
			goLeft(p);
		} else if (c == 'r') {
			goRight(p);
		}
	}
	
	public static void goForward(int[] p) {
		if(p[0] > 0 && p[1] > 0 && p[0] < rover.MarsMap.x -1 && p[1] < rover.MarsMap.y -1 ) {
			if (mars[p[0]][p[1]] == '^' && !(mars[p[0]-1][p[1]] == '#')) {
				mars[p[0]-1][p[1]] = '^';
				mars[p[0]][p[1]] = ' ';
			}
			else if (mars[p[0]][p[1]] == 'V' && !(mars[p[0]+1][p[1]] == '#')) {
				mars[p[0]+1][p[1]] = 'V';
				mars[p[0]][p[1]] = ' ';	
			}
			else if (mars[p[0]][p[1]] == '<' && !(mars[p[0]][p[1]-1] == '#')) {
				mars[p[0]][p[1]-1] = '<';
				mars[p[0]][p[1]] = ' ';
			}
			else if (mars[p[0]][p[1]] == '>' && !(mars[p[0]][p[1]+1] == '#')) {
					mars[p[0]][p[1]+1] = '>';
					mars[p[0]][p[1]] = ' ';
			}
		}
	}
	
	public static void goBackward(int[] p) {
		if(p[0] > 0 && p[1] > 0 && p[0] < rover.MarsMap.x -1 && p[1] < rover.MarsMap.y -1 ) {
			if (mars[p[0]][p[1]] == '^' && !(mars[p[0]+1][p[1]] == '#')) {
				mars[p[0]+1][p[1]] = '^';
				mars[p[0]][p[1]] = ' ';
			}
			else if (mars[p[0]][p[1]] == 'V' && !(mars[p[0]-1][p[1]] == '#')) {
				mars[p[0]-1][p[1]] = 'V';
				mars[p[0]][p[1]] = ' ';	
			}
			else if (mars[p[0]][p[1]] == '<' && !(mars[p[0]][p[1]+1] == '#')) {
				mars[p[0]][p[1]+1] = '<';
				mars[p[0]][p[1]] = ' ';
			}
			else if (mars[p[0]][p[1]] == '>' && !(mars[p[0]][p[1]-1] == '#')) {
					mars[p[0]][p[1]-1] = '>';
					mars[p[0]][p[1]] = ' ';
			}
		}
	}
	
	public static void goLeft(int[] p) {
		if (mars[p[0]][p[1]] == '^')
			mars[p[0]][p[1]] = '<';
		else if (mars[p[0]][p[1]] == '<')
			mars[p[0]][p[1]] = 'V';
		else if (mars[p[0]][p[1]] == 'V')
			mars[p[0]][p[1]] = '>';
		else if (mars[p[0]][p[1]] == '>')
			mars[p[0]][p[1]] = '^';
	}
	
	public static void goRight(int[] p) {
		if (mars[p[0]][p[1]] == '^')
			mars[p[0]][p[1]] = '>';
		else if (mars[p[0]][p[1]] == '<')
			mars[p[0]][p[1]] = '^';
		else if (mars[p[0]][p[1]] == 'V')
			mars[p[0]][p[1]] = '<';
		else if (mars[p[0]][p[1]] == '>')
			mars[p[0]][p[1]] = 'V';
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

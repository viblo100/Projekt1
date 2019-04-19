package rover;

import java.util.Random;

public class MarsMap {
	
	static Random r = new Random();
	static char[][] mars;
	static int x = 20;
	static int y = 80;
	
	/*Mars Landschaft initialisieren*/
	public static void init() {
		mars = new char[x][y];
		int rx = x / 2;
		int ry = y / 2;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				mars[i][j] = ' ';
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (r.nextDouble() < 0.25 && !(rx == i && ry == j))
					mars[i][j]= '#';
			}
		}
		mars[rx][ry] = '^';
	}
	
	/*Gibt die Marskarte aus*/
	public static void output() {
		for (int j = 0; j < x; j++) {
			for (int i = 0; i < y; i++) {
				System.out.print(mars[j][i]);
			}
			System.out.println();
		}
		for (int i = 0; i < y; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}


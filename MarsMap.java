package rover;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class MarsMap {
	
	static Random r = new Random();
	static LinkedHashMap<int[], String> mars;
	
	/*Mars Landschaft initialisieren*/
	public static void init() {
		mars = new LinkedHashMap<>();
		int x = 80;
		int y = 20;
		int rx = x / 2;
		int ry = y / 2;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int[] p = new int[] { i, j };
				if (r.nextDouble() < 0.25 && !(rx == i && ry == j))
					mars.put(p, "#");
			}
		}
		mars.put(new int[] { rx, ry }, "n");
	}
	
	/*Gibt die Marskarte aus*/
	public static void output() {
		int[] max = maximum(mars.keySet());
		for (int j = 0; j < max[1]; j++) {
			for (int i = 0; i < max[0]; i++) {
				if (getChar(mars, new int[] { i, j }) == null) {
					System.out.print(" ");
					continue;
				}
				if (getChar(mars, new int[] { i, j }).equals("#"))
					System.out.print("#");
				else if (getChar(mars, new int[] { i, j }).equals("n"))
					System.out.print("^");
				else if (getChar(mars, new int[] { i, j }).equals("s"))
					System.out.print("V");
				else if (getChar(mars, new int[] { i, j }).equals("e"))
					System.out.print(">");
				if (getChar(mars, new int[] { i, j }).equals("w"))
					System.out.print("<");
			}
			System.out.println();
		}
		for (int i = 0; i < max[0]; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public static int[] maximum(Set<int[]> set) {
		int[] x = new int[2];
		for (int[] e : set) {
			if (e[0] > x[0])
				x[0] = e[0];
			if (e[1] > x[1])
				x[1] = e[1];
		}
		return x;
	}
	
	/*Gibt den char an der übergebenen Stelle zurück*/
	public static String getChar(Map<int[], String> stones, int[] p) {
		Set<Entry<int[], String>> entrySet = stones.entrySet();
		for (Entry<int[], String> entry : entrySet) {
			if (entry.getKey()[0] == p[0] && entry.getKey()[1] == p[1])
				return entry.getValue();
		}
		return null;
	}

	
}

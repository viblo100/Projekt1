package rover;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Rover {
	
	static LinkedHashMap<int[], String> mars = rover.MarsMap.mars;
	
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
		if (rover.MarsMap.getChar(mars, p).equals("n"))
			p[1]--;
			if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
				p[0]++;	
			else if (rover.MarsMap.getChar(mars, p).equals("s"))
				p[1]++;
				if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#"))
					p[0]--;											
			else if (rover.MarsMap.getChar(mars, p).equals("e"))
				p[0]++;
				if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
					p[0]--;											
			else if (rover.MarsMap.getChar(mars, p).equals("w"))
				p[0]--;
				if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
					p[0]++;			
	}
	
	public static void goBackward(int[] p) {
		if (rover.MarsMap.getChar(mars, p).equals("s"))
			p[1]--;
			if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
				p[0]++;			
		else if (rover.MarsMap.getChar(mars, p).equals("n"))
			p[1]++;
			if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
				p[0]--;			
		else if (rover.MarsMap.getChar(mars, p).equals("w"))
			p[0]++;
			if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
				p[0]--;			
		else if (rover.MarsMap.getChar(mars, p).equals("e"))
			p[0]--;
			if (rover.MarsMap.getChar(mars, new int[] { p[0], p[1] }).equals("#")) 
				p[0]++;	
	}
	
	public static void goLeft(int[] p) {
		if (rover.MarsMap.getChar(mars, p).equals("n"))
			mars.put(p, "w");
		else if (rover.MarsMap.getChar(mars, p).equals("s"))
			mars.put(p, "e");
		else if (rover.MarsMap.getChar(mars, p).equals("e"))
			mars.put(p, "n");
		else if (rover.MarsMap.getChar(mars, p).equals("w"))
			mars.put(p, "s");
	}
	
	public static void goRight(int[] p) {
		if (rover.MarsMap.getChar(mars, p).equals("w"))
			mars.put(p, "n");
		else if (rover.MarsMap.getChar(mars, p).equals("e"))
			mars.put(p, "s");
		else if (rover.MarsMap.getChar(mars, p).equals("n"))
			mars.put(p, "e");
		else if (rover.MarsMap.getChar(mars, p).equals("s"))
			mars.put(p, "w");
	}
	
	/*Sucht den Rover und gibt die aktuelle Position zurück*/
	private static int[] searchRover() {
		Set<Entry<int[], String>> entrySet = mars.entrySet();
		for (Entry<int[], String> entry : entrySet) {
			if (entry.getValue() != null && !entry.getValue().equals("#"))
				return entry.getKey();
		}
		throw new IllegalStateException("Rover missing in action");
	}
	
}

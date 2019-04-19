package rover;

import java.util.Random;

public class Start_new {

	static Random r = new Random();

	public static void main(String[] args) {
		if (args.length > 1) {
			long seed = Long.parseLong(args[1]);
			r.setSeed(seed);
		}
		rover.MarsMap.init();
		String pg = args[0];
		rover.MarsMap.output();
		for (int i = 0; i < pg.length(); i++) {
			rover.Rover.moveRover(pg.charAt(i));
			rover.MarsMap.output();
		}
	}

}

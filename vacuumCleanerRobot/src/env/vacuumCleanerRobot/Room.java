// CArtAgO artifact code for project vacuumCleanerRobot

package vacuumCleanerRobot;

import java.util.Random;

import cartago.*;

public class Room extends Artifact {
	
	boolean isAccessible[][] = null;
	boolean isDirty[][] = null;
	boolean hasRobot[][] = null;
	
	// Robot will start at (0,0)
	private int[] robotAt = {0,0};
	private Random rnd = new Random(System.currentTimeMillis());	
	
	public void init(int roomWidth, int roomHeight) {
		System.out.println("Rooms::Init() - Creating a room " + roomWidth + "x" + roomHeight);

		isDirty = new boolean[roomWidth][roomHeight];
		isAccessible = new boolean[roomWidth][roomHeight];
		hasRobot = new boolean[roomWidth][roomHeight];
				
		defineObsProperty("at", robotAt);
		
		for (int x = 0; x < roomWidth; roomWidth++) {
			for (int y = 0; y < roomHeight; roomHeight++) {
				isDirty[x][y] = false;
				isAccessible[x][y] = true;
				hasRobot[x][y] = false;
			}
		}
		
		execInternalOp("randomDirtySpawn");
	}
	
	@INTERNAL_OPERATION
	// method to spawn a dirty in some tile at our room (70% chance) - Hardcoded :(
	void randomDirtySpawn() {
		while(true)
		{
			if(rnd.nextDouble() <= 0.7) {
				int xRandom = rnd.nextInt(isDirty.length);
				int yRandom = rnd.nextInt(isDirty[0].length);
				System.out.println("Dirty is at: " + xRandom + " x " + yRandom);
				isDirty[xRandom][yRandom] = true;
			}
			await_time(1000);
		}
	}
	
	@OPERATION
	public boolean tileIsDirty(int x, int y) {
		return isDirty[x][y];
	} 
	
	@OPERATION
	public boolean tileIsAccessible(int x, int y) {
		// Out-of-bound checking
		if (x < 0 || y < 0 || x > isAccessible[0].length-1 || y > isAccessible[1].length -1)
		{
			return false;
		}
		return isAccessible[x][y];
	}
	
	@OPERATION
	public boolean tileHasRobot(int x, int y) {
		
		// Out-of-bound checking
		if (x < 0 || y < 0 || x > hasRobot[0].length-1 || y > hasRobot[1].length -1)
		{
			//TODO throw a formal exception?
			System.out.print("Internal Exception: Index out of bounds! Room()::tileHasRobot()");
			return false;
		}
		
		return hasRobot[x][y];
	}
	
	
	@OPERATION
	void goLeft() {
		if(robotAt[0] - 1 >= 0)
		{
			robotAt[0]--;
			getObsProperty("at").updateValue(this.robotAt);
			signal("arrive");
			if (isDirty[robotAt[0]] [robotAt[1]])
				signal("dirty");
			else
				signal("noDirty");
		}
		else
			signal("horizontalBorder");
	}
	
	@OPERATION
	void goRight() {
		if(robotAt[0] + 1 < isDirty.length)
		{
			robotAt[0]++;
			getObsProperty("at").updateValue(robotAt);
			signal("arrive");
			if (isDirty[robotAt[0]] [robotAt[1]])
				signal("dirty");
			else
				signal("noDirty");
		}
		else
			signal("horizontalBorder");
	}
	
	@OPERATION
	void goUp() {
		if(robotAt[1] + 1 < isDirty[0].length)
		{
			robotAt[1]++;
			getObsProperty("at").updateValue(robotAt);
			signal("arrive");
			if (isDirty[robotAt[0]] [robotAt[1]])
				signal("dirty");
			else
				signal("noDirty");
		}
		else
			signal("verticalBorder");
	}
	
	@OPERATION
	void goDown() {
		if(robotAt[1] - 1 >= 0)
		{
			robotAt[1]--;
			getObsProperty("at").updateValue(robotAt);
			signal("arrive");
			if (isDirty[robotAt[0]] [robotAt[1]])
				signal("dirty");
			else
				signal("noDirty");
		}
		else
			signal("verticalBorder");
	}

	@OPERATION
	void clean() {
		
		if (isDirty[robotAt[0]] [robotAt[1]])
			isDirty[robotAt[0]] [robotAt[1]] = false;
		else
			signal("noDirty");
	}
}
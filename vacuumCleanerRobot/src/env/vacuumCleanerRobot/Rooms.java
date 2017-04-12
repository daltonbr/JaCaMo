// CArtAgO artifact code for project vacuumCleanerRobot

package vacuumCleanerRobot;

import java.util.Random;

import cartago.*;

public class Rooms extends Artifact {
	private boolean dirtyRoom[][] = null;
	//private int robotAt = 0;
	private Random rnd = new Random(System.currentTimeMillis());	
	
	public void init() {
		//dirtyRoom = new boolean[][];
		//defineObsProperty("at", 0);
		System.out.println("Rooms::Init()");
//		for (int x = 0; x < roomWidth; roomWidth++) {
//			for (int y = 0; y < roomHeight; roomHeight++) {
//				dirtyRoom[x][y] = false;
//			}
//		}
		
//		execInternalOp("run");
	}
	
	@INTERNAL_OPERATION
	void run() {
		while(true)
		{
			if(rnd.nextDouble() <= 0.7) {
				int xRandom = rnd.nextInt(dirtyRoom.length);
				int yRandom = rnd.nextInt(dirtyRoom[0].length);
				System.out.println("xRandom: " + xRandom + ", yRandom: " + yRandom);
				//System.out.println("Trash in [" + dirtyRoomIndex);
				dirtyRoom[xRandom][yRandom] = true;
			}
			
			await_time(4000);
		}
	}
	
	@OPERATION
	public boolean tileIsDirty(int x, int y) {
		return dirtyRoom[x][y];
	} 
	
//	@OPERATION
//	void goLeft() {
//		if(this.robotAt - 1 >= 0)
//		{
//			this.robotAt--;
//			getObsProperty("at").updateValue(this.robotAt);
//			signal("arrive");
//			if(dirtyRoom[this.robotAt])
//				signal("dirty");
//		}
//		else
//			signal("border");
//	}
//	
//	@OPERATION
//	void goRight() {
//		if(this.robotAt + 1 < dirtyRoom.length)
//		{
//			this.robotAt++;
//			getObsProperty("at").updateValue(this.robotAt);
//			signal("arrive");
//			if(dirtyRoom[this.robotAt])
//				signal("dirty");
//		}
//		else
//			signal("border");
//	}
//	
	@OPERATION
	void cleanTile(int x, int y) {
		if (dirtyRoom[x][y])
			dirtyRoom[x][y] = false;
		else
			signal("noDirty");
	}
	
	@OPERATION
	boolean tileIsOccupied (int x, int y){
		//TODO
		return true;
	}
}
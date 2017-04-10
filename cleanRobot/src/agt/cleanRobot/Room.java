// CArtAgO artifact code for project cleanRobot

package cleanRobot;

import cartago.*;
//import java.util.Random;
//import jason.stdlib.*  -  ateh isso tentei;

public class Room extends Artifact {

	//private Random rnd = new Random(System.currentTimeMillis());	
	
	public void init(int roomSide) {
		System.out.println("Debugu: Room::Init(" + roomSide + ")");
	}
	
	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}
}


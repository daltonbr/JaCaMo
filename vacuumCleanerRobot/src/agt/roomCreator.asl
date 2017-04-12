// Agent roomCreator in project vacuumCleanerRobot

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("Creating Room");
 				  makeArtifact("Room", "vacuumCleanerRobot.Room", [4,5], ID);
 				  focus(ID);
 				  // Start the robots
 				  .broadcast(tell, activateRobot).
-!start.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }

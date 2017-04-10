// Agent roomCreator in project vacuumCleanerRobot

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("God is here");
 				  .makeArtifact("rooms", "vacuumCleanerRobot.Rooms", [4], ID);
         		  focus(ID).
-!start.

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }

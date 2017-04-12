// Agent robot in project vacuumCleanerRobot

/* Initial beliefs and rules */
horizontalDirection(right).
verticalDirection(up).

/* Initial goals */

!awake.

/* Plans */

+!awake <- .println(" a robot has awaked!").
-!awake. 

// Can only be activated externally by roomCreator agent                  
+activateRobot[source(Src)] <- .println(Src, " activate this Robot");
								!searchArtifact.

// search for a room, until find it
+!searchArtifact <- lookupArtifact("Room",ID); 
					focus(ID);
					.println("Robot searching for a Room");
					!searchTrash.
//           		  	!checkRoomDimensions.
           		  			
//-!searchArtifact <- !searchArtifact.
 
+!searchTrash <- .drop_all_intentions; 
				!move;
 		  		.wait(1500);	
 		  		!searchTrash.

// Horizontal movement has precedence over Vertical (by convention)
+!move : at(X) & horizontalDirection(right) <- goRight.
+!move : at(X) & horizontalDirection(left) <- goLeft.

+!moveVertical : at(X) & verticalDirection(down) <- goDown.
+!moveVertical : at(X) & verticalDirection(up) <- goUp.
        

                           
+dirty : at(X) <- 
        .println("Cleaning room ", X);
        clean.
        
+noDirty : .println("Tile was clean").
        
+horizontalBorder : horizontalDirection(left) <- .println("Left Border Reached");
											 							 !moveVertical; 
										     							 -+horizontalDirection(right).
							 
+horizontalBorder : horizontalDirection(right) <- .println("Right Border Reached");
													!moveVertical;
				   									-+horizontalDirection(left).
				   
+verticalBorder : verticalDirection(down) <- .println("Bottom Border Reached"); 
				  -+verticalDirection(up).
							 
+verticalBorder : verticalDirection(up) <- .println("Top Border Reached");
				  -+verticalDirection(down).

+arrive : at(X) <- .println("Moving to room ", X).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }

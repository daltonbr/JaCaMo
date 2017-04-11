// Agent robot in project vacuumCleanerRobot

/* Initial beliefs and rules */
//direction(right).

/* Initial goals */

!start.

/* Plans */

+!start[source(src)] : .println(src, " has started a robot!"). 
          				//!searchTrash.
                  
//+!searchTrash <- .drop_all_intentions;
//                 !move;
//                 .wait(1000);
//                 !searchTrash.
//
//+!move : at(X) & direction(right) <- goRight.
//        
//+!move : at(X) & direction(left) <- goLeft.
//                           
//+dirty : at(X) <- 
//        .println("Cleaning room ", X);
//        clean.     
//        
//+border : direction(left) <- -+direction(right).
//+border : direction(right) <- -+direction(left).
//
//+arrive : at(X) <- .println("Moving to room ", X).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }

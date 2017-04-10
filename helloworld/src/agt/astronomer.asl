// Agent astronomer in project helloworld

/* Initial beliefs and rules */
planet("Mercury").
planet("Venus").
planet("Earth").

/* Initial goals */

!start.

/* Plans */
+!start : true <- .print("I can tell all the planets of the solar system! :");
				  .findall(X, planet(X), L);
				  .println("They are ", L).
	

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
//{ include("$jacamoJar/templates/org-obedient.asl") }

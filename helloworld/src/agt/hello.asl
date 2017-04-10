

// Agent hello in project helloworld

/* Initial beliefs and rules */
raining.
name(renato).
isAt(renato, unesp).
isAt(renato, work).
car("Fiesta").
has(renato, car("Fiesta")).
temperature(10).

/* Initial goals */

!init.

/* Plans */

+!init : name(X) & isAt(X, Y) <- .print("Hello ", X , "how are you?");
								 .println("I see you are now at ", Y);
								 !checkWeather;
								 !checkTemperature.
					
+!checkWeather: raining <- .println("Today is raining.\n Take your umbrella!").

+!checkWeather: sunny <- .println("Today is a sunny day!").

+!checkTemperature: temperature(X) & X < 15 <- .println("Temperature : ", X, "\n I suggest you to bring your coat!").

+!checkTemperature: temperature(X) & X > 25 <- .println("It's really hot today!").

-!checkTemperature: .println("It is a warm day").

+!init : true <- .print("hello world.");
                 -raining;
                 -+isAt(renato, home);
				 +sunny.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have a agent that always complies with its organization  
{ include("$jacamoJar/templates/org-obedient.asl") }

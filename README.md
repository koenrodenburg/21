# 21

## Starting the program

* Open a command window in the root of the project
* Run `mvn clean install`
* Run `java -jar target\21-1.0-SNAPSHOT.jar`
* Visit `http://localhost:8080`

## Playing the game

You will be dealt two cards to start with. The goal of the game is to get as close as possible to 21 points, but if that number is exceeded, it is game over.

Use the Hit button to request an extra card. The Stand button hands the initiative to the bank, after which it is shown who has won the game.

## The Application

This is a simple implementation of the Dutch card game Twenty-One, built within a single day. 

The application is built in Java 8 using Spring Boot with an MVC architecture. It uses HTML, JavaScript, jQuery and Bootstrap for the frontend.

The core business logic is contained in the model.Game class. It represents the game itself, and controls the turns and determines the winner. The other classes 
in the model package are built in service of the Game class. Most of those are Enumerations or other classes encapsulating logical entities, such as Card, 
Deck and Hand.

The frontend is served statically from the src/main/resources folder. It communicates through jQuery GET and POST requests with the Game API that is hosted under the 
/game/ endpoint. That endpoint is exposed by controller.GameController class. It uses the simple Java beans in the view package for JSON serialization. The reason
for that is to expose only the necessary information to the client, and keep the rest internal in the application.

## TO DO

Several TO DO's are still open. Throughout the code, TODO comments indicate places where improvements can and should be made. Additionally, the following points are still open:

* Ace can count for 1 or 11 points
* Betting
* Multi-player
* The Split action

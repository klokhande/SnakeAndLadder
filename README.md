# SnakeAndLadder
 This is a SnakeAndLadder game with two types of Dices.
 1. Normal Dice: Well type known dice which returns values between 1 to 6 for each roll.
 2. Crooked Dice: A special dice which always returns even values between 1 to 6.

The dice can be set using java property dicetype. The default value for dicetype is normal.

e.g.
for Normal dice: -Ddicetype=normal, 
for Crooked dice: -Ddicetype=crooked

Steps to build:
1. cd snakeladder
2. mvn clean install

Steps to run:
1. Default Dice: java -jar target/snakeladder-1.0-SNAPSHOT.jar
2. Normal Dice: java -jar -Ddicetype=normal target/snakeladder-1.0-SNAPSHOT.jar
3. Crooked Dice: java -jar -Ddicetype=crooked target/snakeladder-1.0-SNAPSHOT.jar

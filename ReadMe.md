Installation:
1. Clone/Download as zip this repo
2. Do a mvn clean install on the root directory(Maven version 3+ should work fine)
3. cd target/appassembler/bin
4. Run the script with ./tictactoe and enjoy!


Design:
The TicTacToePlayer class can be implemented to support a wide type of users
Human or Computer. For ComputerPlayer, the current version is naive, generating moves randomly.
But the model is good enough so that you can have your own SmartComputerPlayer using AI to beat the human!
The nextMove() function can be implemented with some smart algo to generate the next move.

Assumptions:
The computer is assigned X while human is assigned 0. Changes can be made to switch.


Scope:
The current version supports Human v/s Computer only. However, Human v/s Human is possible with a few changes in the model with a few changes.

Inputs:

The human can enter a number 1-9 to indicate the "spot" where he wants to put "0"
If he/she/it enters a spot already taken, input has to be entered again. This even applies to a
BadComputerPlayer who generates already occupied spot! In short, a bad AI generating the same move can be forced to generate a new move!



Enhancements possible:
1. SmartComputerPlayer
2. Human vs Human, Computer v/s Computer, Human v/s Computer
3. Give the user choice for X or 0
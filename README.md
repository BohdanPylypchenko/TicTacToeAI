# TicTacToe game (AI version)

My implementation of TicTacToe game

### Features:
1. 3 levels of difficulty.
2. Play with friend or yourself.
3. Highly extensible - ideas like n x n field, more than 2 players etc
   can be easily implemented in future 
   (by writing another static creator of Game instance, similar to create2User3x3 method in Game class).

I highly encourage other people to contribute to this project.

### small game tutorial:

To launch, just run jar file (no arguments are required).

To start the game itself, enter "start" command.
Start command takes 2 arguments.
1st defines type of player 1;
2nd defines type of player 2;
There are 4 types for each player:
    1. Easy bot     - makes random moves only
    2. Medium bot   - random moves, if other player is 1 move from win - denies that move
                      by taking the field
    3. Hard bot     - Dark Souls like difficulty (Mini-Max algorithm)
    4. Human player - enter moves from keyboard.
To play against bot, enter "start user (easy|medium|hard)".
To play against human friend, enter "start user user".
To turn the program into Skynet, use "start hard hard".

After starting game session as human player, you will be asked to enter coordinates of cell
to occupy.
Coordinate in grid numerated in matrix-style:
    x ----
y 11 12 13
| 21 22 23
| 31 32 33
To enter coordinates of move, pass them like this: x y (x coord, SPACE, y coord).
Example: to occupy cell 23, enter "2 3".

Finally, to exit, enter "exit" command.
(Notice, to exit the game / start new game, you first need to finish current one.)

Good luck :)

### Game session example:

    Input command: start user medium
    ---------
    |       |
    |       |
    |       |
    ---------
    Enter the coordinates: 1 1
    ---------
    | X     |
    |       |
    |       |
    ---------
    Making move level "medium"
    ---------
    | X     |
    | O     |
    |       |
    ---------
    Enter the coordinates: 1 3
    ---------
    | X   X |
    | O     |
    |       |
    ---------
    Making move level "medium"
    ---------
    | X O X |
    | O     |
    |       |
    ---------
    Enter the coordinates: 2 2
    ---------
    | X O X |
    | O X   |
    |       |
    ---------
    Making move level "medium"
    ---------
    | X O X |
    | O X   |
    |     O |
    ---------
    Enter the coordinates: 3 1
    ---------
    | X O X |
    | O X   |
    | X   O |
    ---------
    X wins
                    
    Input command: exit

# 2048
A Java implementation for the game **2048** with simple customizability options.

## How To Play 

### Start
1. Run **Runner.java**
2. Type in preferred settings as prompted in console
3. The game will start

### Input
- '**W**' will move all tiles **up**
- '**A**'  will move all tiles to the **left**
- '**S**' will move all tiles **down**
- '**D**' will move all tiles to the **right**

### Rules
- Type in *W*,*A*,*S* or *D* into the console to make a move
- Tiles with the same number will merge into one tile when touched
- The newly merged tile's number will be double the previous tiles
- Add them up to reach 2048!


## Future Goals

- Improve cohesion and coupling (few modules have dependant behavior that can be changed)
- Break down larger classes into smaller ones
- Add limits to game settings (board size and number of inputs)
- Add instructions to main menu
- Improve user input
  - Currently, if the user makes an invalid move, the move will default to 'up'
- Add and improve unit testing
  - Previously implemented unit tests were not ideal
  - Previous implementation tried accessed class variables as state variables
  - Not all classes have been tested

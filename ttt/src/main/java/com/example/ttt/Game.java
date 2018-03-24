package com.example.ttt;

/**
 * Created by Kelly on 3/18/2018.
 */

public class Game {
  private IUIEngine uiEngine;                 //An interface to the user interface
  private Square[] squares = new Square[9];   //The squares in the game
  
  private enum gameState {P1Win, P2Win, TIE, NO};
  private gameState state = gameState.NO;
  
  /**
   * Creates a game object (do not edit)
   */
  private Game(IUIEngine uiEngine) {
    this.uiEngine = uiEngine;
    
  }
  
  /**
   * Starts a game of tic-tac-toe.  This is where you will write the majority of your code.
   */
  private void startGame() {
    uiEngine.showIntro();
    initializeObjects();
    int turn = 1;
         
         /*Your code goes here for a single playthrough of the game*/
    //while game is not over
    while (state == gameState.NO){
      if (turn % 2 == 1){
        uiEngine.updateUI(squares, 1);
      } else {
        uiEngine.updateUI(squares, 2);
      }
      int pos = uiEngine.getUserInput();
      if (turn % 2 == 1){
        squares[pos].squareType = Square.SquareType.X;
      } else {
        squares[pos].squareType = Square.SquareType.O;
      }
      if (turn % 2 == 1){
        state = findWin(squares, 1);
      } else {
        state = findWin(squares, 2);
      }
      turn++;
    }
    
    if (state == gameState.P1Win){
      uiEngine.showResult(1);
    } else if (state == gameState.P2Win){
      uiEngine.showResult(2);
    } else if (state == gameState.TIE){
      uiEngine.showResult(0);
    }
    //update the ui with a call to the IUIEngine interface
    //get user input with a call to the IUIEngine interface
    //update the game (change state within this class)
    //update the ui one last time
    //if not computed in the loop, figure out if there is a winner
    //uiEngine.showResult(winner) - Call this funciton with the winning player number (0 for tie) at the end of this function
  }
  
  private gameState findWin(Square[] squares, int player){
    gameState game = gameState.NO;
    if (player == 1){
      if (checkRowWin(squares, Square.SquareType.X) || checkColWin(squares, Square.SquareType.X) || checkDiagonalWin(squares, Square.SquareType.X)){
        game = gameState.P1Win;
      }
    } else {
      if (checkRowWin(squares, Square.SquareType.O) || checkColWin(squares, Square.SquareType.O) || checkDiagonalWin(squares, Square.SquareType.O)){
        game = gameState.P2Win;
      }
    }
    if ((!(game == gameState.P1Win || game == gameState.P2Win)) && checkTie(squares)){
      game = gameState.TIE;
    }
    return game;
  }
  
  //checks for horizontal win
  private boolean checkRowWin(Square[] squares, Square.SquareType player){
    boolean win = false;
    for (int i = 0; i < 3; i++){
      int temp = 0;
      for (int j = 0; j < 3; j++){
        if (squares[(i*3)+j].squareType == player) {
          temp++;
        }
      }
      if (temp == 3){
        win = true;
      }
    }
    return win;
  }
  
  //checks for vertical win
  private boolean checkColWin(Square[] squares, Square.SquareType player){
    boolean win = false;
    for (int i = 0; i < 3; i++){
      int temp = 0;
      for (int j = 0; j < 3; j++){
        if (squares[(3*j)+i].squareType == player) {
          temp++;
        }
      }
      if (temp == 3){
        win = true;
      }
    }
    return win;
  }
  
  //checks for diagonal win
  private boolean checkDiagonalWin(Square[] squares, Square.SquareType player){
    boolean win = false;
    if (squares[0].squareType == player && squares[4].squareType == player && squares[8].squareType == player){
      win = true;
    }
    if (squares[2].squareType == player && squares[4].squareType == player && squares[6].squareType == player){
      win = true;
    }
    return win;
  }
  
    //checks for tie
  private boolean checkTie(Square[] squares){
    boolean tie = false;
    int temp = 0;
    for (int i = 0; i < 9; i++){
      if (!(squares[i].squareType == Square.SquareType.EMPTY)){
        temp++;
      }
    }
    if (temp == 9){
      tie = true;
    }
    return tie;
  }
  /**
   * Intializes the game grid. (do not edit)
   */
  private void initializeObjects() {
    for (int i = 0; i < 9; i++) {
      squares[i] = new Square(i);
    }
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Game game = new Game(new ConsoleUIEngine());
    game.startGame();
  }
  
}

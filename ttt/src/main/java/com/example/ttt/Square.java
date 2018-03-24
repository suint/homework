package com.example.ttt;

/**
 * Created by Kelly on 3/18/2018.
 */

public class Square {
  public enum SquareType {EMPTY,X,O};
  
  int position; //0-8 one of the 9 positions on the board
  
  public SquareType squareType=SquareType.EMPTY; //The type of the current square
  
  /**
   * Constructor: creates a square
   * @param position: The 0-8 position of the square being created
   */
  public Square(int position){
    this.position=position;
  }
}

package com.example.ttt;
import java.util.Scanner;
/**
 * Created by Kelly on 3/18/2018.
 */

public class ConsoleUIEngine implements IUIEngine {
  
  
  Scanner scanner=new Scanner(System.in);
  
  @Override
  public void showIntro() {
    System.out.println("Welcome to Tic Tac Toe");
  }
  
  @Override
  public void updateUI(Square[] squares,int player) {
    for (int i=0;i<9;i++){
      if (squares[i].squareType== Square.SquareType.EMPTY){
        System.out.printf("% d ",i+1);
      }
      else if (squares[i].squareType==Square.SquareType.X){
        System.out.print(" X ");
      }
      else{
        System.out.print(" O ");
      }
      if ((i+1)%3==0)
        System.out.println("");
    }
    if (player>0){
      System.out.printf("Player %d",player);
      System.out.println("");
    }
  }
  
  @Override
  public void showResult(int winner) {
    if (winner>0)
      System.out.printf("The winner is Player %d.",winner);
    else
      System.out.printf("It was a tie");
    System.out.println("");
  }
  
  @Override
  public int getUserInput() {
    System.out.println("Enter a position for your move");
    return scanner.nextInt()-1;
  }
  
}

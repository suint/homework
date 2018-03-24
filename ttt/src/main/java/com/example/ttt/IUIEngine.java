package com.example.ttt;

/**
 * Created by Kelly on 3/18/2018.
 */

public interface IUIEngine {
  /**
   * Displays welcome information to the user
   */
  void showIntro();
  /**
   * Draws the current state of the game
   * @param squares: The list of squares in thegame
   * @param player: The current player
   */
  void updateUI(Square[] squares,int player);
  /**
   * Shows the result of a finished game
   * @param winner: the winning player (0 for tie)
   */
  void showResult(int winner);
  /**
   * Asks the user for the next position chosen (0-8) for the game.
   * @returns The position selected by the user (not necessarily valid)
   */
  int getUserInput();
}

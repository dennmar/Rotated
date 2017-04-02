/*
 * File: RandomizedBoard.java
 * Description: A board that can start with a different amount of black and white squares
 * Version: 1.0
 * Date: 4/1/17
 */

package com.extracliff.rotated;

import android.view.View;
import android.widget.ImageView;

/**
 * A board that can have a random amount of black and white squares every time.
 */
public class RandomizableBoard {

	private static final int WHITE_LEVEL = 1;
	private static final int BLACK_LEVEL = 0;
	private View rootView;
	private int minBlackSquares;
	private int maxBlackSquares;
	private int maxRow;
	private int maxCol;

	/**
	 * Initializes the instance variables with the given values.
	 * @param rView The view that includes all views in the fragment
	 * @param minBSquares The minimum amount of squares that will be rotated to black
	 * @param maxBSquares The maximum amount of squares that will be rotated to black
	 * @param boardSize The maximum row and column number
	 */
	public RandomizableBoard(View rView, int minBSquares, int maxBSquares, int boardSize) {
		rootView = rView;
		minBlackSquares = minBSquares;
		maxBlackSquares = maxBSquares;
		maxRow = boardSize;
		maxCol = boardSize;
	}

	/**
	 * Changes a random amount of squares to be black.
	 */
	public void randomize() {
		int blackSquares = (int)(Math.random() * (maxBlackSquares - minBlackSquares + 1))
				+ minBlackSquares;
		int i = 0;
		while (i < blackSquares) {
			int row = (int)(Math.random() * maxRow) + 1;
			int col = (int)(Math.random() * maxCol) + 1;
			String squareTag = "r" + row + "c" + col;
			ImageView square = (ImageView)rootView.findViewWithTag(squareTag);
			if (square.getDrawable().getLevel() == WHITE_LEVEL) {
				square.setImageResource(R.drawable.rounded_square_black_mdpi);
				square.getDrawable().setLevel(BLACK_LEVEL);
				i++;
			}
		}
	}
}

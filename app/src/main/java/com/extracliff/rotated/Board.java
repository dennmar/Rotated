/*
 * File: Board.java
 * Description: A board of rotatable squares that can be randomized
 * Version: 0.15
 * Date: 4/29/17
 */

package com.extracliff.rotated;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Creates a board of Squares that can start with a random amount of white and black squares.
 */
public class Board {

	private static int MIN_ROW = 0;
	private static int MIN_COL = 0;
	private static int WHITE_LEVEL = 1;
	private static int BLACK_LEVEL = 0;
	private static int EASY_BOARD = 4;
	private static int MEDIUM_BOARD = 5;
	private Square[][] board;
	private View rootView;
	private int maxRow;
	private int maxCol;

	/**
	 * Initializes the instance variables with the given values.
	 * @param squareViews The ImageViews of all the Squares that will be on the board
	 * @param rView The view that includes all views in the fragment
	 * @param boardSize The maximum row and column number
	 */
	public Board(ArrayList<ImageView> squareViews, View rView, int boardSize) {
		rootView = rView;
		maxRow = boardSize;
		maxCol = boardSize;
		board = new Square[maxRow + 1][maxCol + 1];
		int svIndex = 0;
		for (int row = MIN_ROW; row <= maxRow; row++) {
			for (int col = MIN_COL; col <= maxCol; col++) {
				Square sq = new Square(squareViews.get(svIndex), row, col, rootView, boardSize);
				board[row][col] = sq;
				svIndex++;
			}
		}
	}

	/**
	 * Sets onClickListeners for all the squares on the board so that they will rotate when
	 * 		clicked.
	 */
	public void setClickListeners() {
		for (int row = MIN_ROW; row <= maxRow; row++) {
			for (int col = MIN_COL; col <= maxCol; col++) {
				final int rowNumber = row;
				final int colNumber = col;
				board[row][col].getSquare().setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						board[rowNumber][colNumber].rotateWithNeighbors();
						if (hasWon()) {
							TextView winText = (TextView)rootView.findViewById(R.id.winMessage);
							winText.setVisibility(View.VISIBLE);
							setClickable(false);
						}
					}
				});
			}
		}
	}

	/**
	 * Changes a random amount of white squares to rotate to black.
	 * @param minBlackSquares The minimum amount of white squares that will turn into black squares
	 * @param maxBlackSquares The maximum amount of white squares that will turn into black squares
	 */
	public void randomize(int minBlackSquares, int maxBlackSquares) {
		int blackSquares = (int)(Math.random() * (maxBlackSquares - minBlackSquares + 1))
				+ minBlackSquares;
		int i = 0;
		while (i < blackSquares) {
			int row = (int)(Math.random() * (maxRow + 1));
			int col = (int)(Math.random() * (maxCol + 1));
			String squareTag = "r" + row + "c" + col;
			ImageView square = (ImageView)rootView.findViewWithTag(squareTag);
			if (square.getDrawable().getLevel() == WHITE_LEVEL) {
			  if (maxRow == EASY_BOARD) {
					square.setImageResource(R.drawable.rounded_square_black_mdpi);
				}
				else if (maxRow == MEDIUM_BOARD) {
					square.setImageResource(R.drawable.rounded_square_black_medium_mdpi);
				}
				else {
					square.setImageResource(R.drawable.rounded_square_black_hard_mdpi);
				}
				square.getDrawable().setLevel(BLACK_LEVEL);
				i++;
			}
		}
	}

	/**
	 * Checks if all the squares are black.
	 * @return True if all squares are black, false otherwise
	 */
	private boolean hasWon() {
		for (int row = 0; row <= maxRow; row++) {
			for (int col = 0; col <= maxCol; col++) {
				String squareTag = "r" + row + "c" + col;
				ImageView square = (ImageView)rootView.findViewWithTag(squareTag);
				if (square.getDrawable().getLevel() == WHITE_LEVEL) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Makes all squares on the board unclickable or clickable
	 * @param clickable True if the all squares should be clickable, false if all squares should not
	 *                  be clickable
	 */
	private void setClickable(boolean clickable) {
		for (int row = 0; row <= maxRow; row++) {
			for (int col = 0; col <= maxCol; col++) {
				String squareTag = "r" + row + "c" + col;
				ImageView square = (ImageView)rootView.findViewWithTag(squareTag);
				if (clickable) {
					square.setClickable(true);
				}
				else {
					square.setClickable(false);
				}
			}
		}
	}
}

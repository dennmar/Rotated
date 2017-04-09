/*
 * File: Square.java
 * Description: A rotatable Square that also rotates its neighbors
 * Version: 0.13
 * Date: 4/2/17
 */

package com.extracliff.rotated;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Defines a rotatable Square where all neighbors must be rotated if the Square is rotated.
 */
public class Square {

	public static final int MIN_ROW = 0;
	public static final int MIN_COL = 0;
	public static final int WHITE_LEVEL = 1;
	public static final int BLACK_LEVEL = 0;
	private static int EASY_BOARD = 4;
	private static int MEDIUM_BOARD = 5;
	private int maxRow;
	private int maxCol;
	private ImageView square;
	private int row;
  private int col;
	private View rootView;

	/**
	 * Initializes the instance variables with the given values.
	 * @param sq The rotatable square
	 * @param rowNumber The row that the rotatable square is in
	 * @param colNumber The column that the rotatable square is in
	 * @param rView The view that includes all views in the fragment
	 * @param boardSize The maximum row and column number
 	*/
	public Square(ImageView sq, int rowNumber, int colNumber, View rView, int boardSize) {
		square = sq;
		row = rowNumber;
		col = colNumber;
		rootView = rView;
		maxRow = boardSize;
		maxCol = boardSize;
	}

	/**
	 * Rotates the square and its neighbors: the squares above, below, to the left of, and to the
	 *     right of it.
 	 */
	public void rotateWithNeighbors() {
		rotate(square);
		ArrayList<ImageView> neighbors = findNeighbors();
		int i = 0;
		while (i < neighbors.size()) {
			ImageView currSquare = neighbors.get(i);
			rotate(currSquare);
			i++;
		}
	}

	/**
	 * Locates the squares directly above, below, to the left of, and to the right of the square
	 *     that possesses the given coordinates.
	 * @return All of the neighboring squares
	 */
	private ArrayList<ImageView> findNeighbors() {
		ArrayList<ImageView> neighbors = new ArrayList<>();
		if (row != maxRow) {
			String belowTag = "r" + (row + 1) + "c" + col;
			ImageView below = (ImageView)rootView.findViewWithTag(belowTag);
			neighbors.add(below);
		}
		if (row != MIN_ROW) {
			String aboveTag = "r" + (row - 1) + "c" + col;
			ImageView above = (ImageView)rootView.findViewWithTag(aboveTag);
			neighbors.add(above);
		}
		if (col != maxCol) {
			String rightTag = "r" + row + "c" + (col + 1);
			ImageView right = (ImageView)rootView.findViewWithTag(rightTag);
			neighbors.add(right);
		}
		if (col != MIN_COL) {
			String leftTag = "r" + row + "c" + (col - 1);
			ImageView left = (ImageView)rootView.findViewWithTag(leftTag);
			neighbors.add(left);
		}
		return neighbors;
	}

	/**
	 * Rotates the given square.
	 * @param square The square whose color will be switched
	 */
	private void rotate(ImageView square) {
		if (maxRow == EASY_BOARD) {
			if (square.getDrawable().getLevel() == WHITE_LEVEL) {
				square.setImageResource(R.drawable.rounded_square_black_mdpi);
				square.getDrawable().setLevel(BLACK_LEVEL);
			}
			else {
				square.setImageResource(R.drawable.rounded_square_mdpi);
				square.getDrawable().setLevel(WHITE_LEVEL);
			}
		}
		else if (maxRow == MEDIUM_BOARD) {
			if (square.getDrawable().getLevel() == WHITE_LEVEL) {
				square.setImageResource(R.drawable.rounded_square_black_medium_mdpi);
				square.getDrawable().setLevel(BLACK_LEVEL);
			}
			else {
				square.setImageResource(R.drawable.rounded_square_medium_mdpi);
				square.getDrawable().setLevel(WHITE_LEVEL);
			}
		}
	}

	/**
	 * Accesses the ImageView of the square.
	 * @return The ImageView of the square
	 */
	public ImageView getSquare() {
		return square;
	}
}

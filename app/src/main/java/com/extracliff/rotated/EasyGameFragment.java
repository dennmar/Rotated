/*
 * File: EasyGameFragment.java
 * Description: Allows the user to play an easy game of Rotated
 * Version: 0.2
 * Date: 1/30/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class EasyGameFragment extends Fragment {

	public static final int MIN_ROW = 1;
	public static final int MIN_COL = 1;
	public static final int MAX_ROW = 5;
	public static final int MAX_COL = 5;
	public static final int ROW_NUM_INDEX = 1;
	public static final int COL_NUM_INDEX = 3;
	public static final int WHITE_LEVEL = 1;
	public static final int BLACK_LEVEL = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.easy_frag_view, container, false);

		// sets click listeners for all squares
		for (int i = MIN_ROW; i <= MAX_ROW; i++) {
			for (int j = MIN_COL; j <= MAX_COL; j++) {
				String squareName = "r" + i + "c" + j;
				int squareID = getResources().getIdentifier(squareName, "id",
						getContext().getPackageName());
				final ImageView currView = (ImageView)rootView.findViewById(squareID);
				currView.getDrawable().setLevel(WHITE_LEVEL);
				currView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						rotate(currView);
					  rotateNeighbors(currView, rootView);
					}
				});
			}
		}

		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
	}


	/**
	 * Rotates the squares directly above, below, to the left of, and to the right of the current
	 *     square as well as the current square itself.
	 * @param currentSquare The square that was tapped
	 * @param rootView The view that includes all views in the fragment
	 */
	private void rotateNeighbors(View currentSquare, View rootView) {
		String cSquareTag = (String)(currentSquare.getTag());
		Log.d("TAGS", "cSquareTag is " + cSquareTag);
		int rowNumber = Character.getNumericValue(cSquareTag.charAt(ROW_NUM_INDEX));
		int colNumber = Character.getNumericValue(cSquareTag.charAt(COL_NUM_INDEX));
		Log.d("NUMBERS", "rowNumber is " + rowNumber);
		Log.d("NUMBERS", "colNumber is " + colNumber);
		ArrayList<ImageView> neighbors = findNeighbors(rowNumber, colNumber, rootView);
		int i = 0;
		while (i < neighbors.size()) {
			ImageView currView = neighbors.get(i);
			rotate(currView);
			i++;
		}
	}

	/**
	 * Locates the squares directly above, below, to the left of, and to the right of the square
	 *     that possesses the given coordinates.
	 * @param row The row number of the square
	 * @param col The column number of the square
	 * @param rootView The view that includes all views in the fragment
	 * @return All of the neighboring squares
	 */
	private ArrayList<ImageView> findNeighbors(int row, int col, View rootView) {
		ArrayList<ImageView> neighbors = new ArrayList<>();
		if (row != MAX_ROW) {
			String belowTag = "r" + (row + 1) + "c" + col;
			Log.d("TAGS", "belowTag is " + belowTag);
			ImageView below = (ImageView)rootView.findViewWithTag(belowTag);
			neighbors.add(below);
		}
		if (row != MIN_ROW) {
			String aboveTag = "r" + (row - 1) + "c" + col;
			Log.d("TAGS", "aboveTag is " + aboveTag);
			ImageView above = (ImageView)rootView.findViewWithTag(aboveTag);
			neighbors.add(above);
		}
		if (col != MAX_COL) {
			String rightTag = "r" + row + "c" + (col + 1);
			Log.d("TAGS", "rightTag is " + rightTag);
			ImageView right = (ImageView)rootView.findViewWithTag(rightTag);
			neighbors.add(right);
		}
		if (col != MIN_COL) {
			String leftTag = "r" + row + "c" + (col - 1);
			Log.d("TAGS", "leftTag is " + leftTag);
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
		if (square.getDrawable().getLevel() == WHITE_LEVEL) {
			square.setImageResource(R.drawable.rounded_square_black_mdpi);
			square.getDrawable().setLevel(BLACK_LEVEL);
		}
		else {
			square.setImageResource(R.drawable.rounded_square_mdpi);
			square.getDrawable().setLevel(WHITE_LEVEL);
		}
	}
}

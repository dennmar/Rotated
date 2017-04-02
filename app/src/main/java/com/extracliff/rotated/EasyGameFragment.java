/*
 * File: EasyGameFragment.java
 * Description: Allows the user to play an easy game of Rotated
 * Version: 0.21
 * Date: 4/30/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Starts an easy game of Rotated.
 */
public class EasyGameFragment extends Fragment {

	public static final int MIN_ROW = 1;
	public static final int MIN_COL = 1;
	public static final int MAX_ROW = 5;
	public static final int MAX_COL = 5;
	public static final int ROW_NUM_INDEX = 1;
	public static final int COL_NUM_INDEX = 3;
	public static final int WHITE_LEVEL = 1;
	public static final int BOARD_SIZE = 5;
	public static final int MIN_BLACK_SQUARES = 6;
	public static final int MAX_BLACK_SQUARES = 10;

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
						String cSquareTag = (String)(currView.getTag());
						int rowNumber = Character.getNumericValue(cSquareTag.charAt(ROW_NUM_INDEX));
						int colNumber = Character.getNumericValue(cSquareTag.charAt(COL_NUM_INDEX));
						Square currSquare = new Square(currView, rowNumber, colNumber, rootView, BOARD_SIZE);
						currSquare.rotateWithNeighbors();
					}
				});
			}
		}

		RandomizableBoard board = new RandomizableBoard(rootView, MIN_BLACK_SQUARES, MAX_BLACK_SQUARES,
				BOARD_SIZE);
		board.randomize();

		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}

/*
 * File: EasyGameFragment.java
 * Description: Allows the user to play an easy game of Rotated
 * Version: 0.22
 * Date: 3/30/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Starts an easy game of Rotated.
 */
public class EasyGameFragment extends Fragment {

	public static final int MIN_ROW = 0;
	public static final int MIN_COL = 0;
	public static final int MAX_ROW = 4;
	public static final int MAX_COL = 4;
	public static final int WHITE_LEVEL = 1;
	public static final int BOARD_SIZE = 4;
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

		ArrayList<ImageView> squareViews = new ArrayList<>();
		for (int i = MIN_ROW; i <= MAX_ROW; i++) {
			for (int j = MIN_COL; j <= MAX_COL; j++) {
				String squareName = "r" + i + "c" + j;
				int squareID = getResources().getIdentifier(squareName, "id",
						getContext().getPackageName());
				final ImageView currView = (ImageView) rootView.findViewById(squareID);
				currView.getDrawable().setLevel(WHITE_LEVEL);
				squareViews.add(currView);
			}
		}

		Board board = new Board(squareViews, rootView, BOARD_SIZE);
		board.setClickListeners();
		board.randomize(MIN_BLACK_SQUARES, MAX_BLACK_SQUARES);

		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}

/*
 * File: HardGameFragment.java
 * Description: Allows the user to play a hard game of Rotated
 * Version: 0.11
 * Date: 4/8/17
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
 * Starts a hard game of Rotated.
 */
public class HardGameFragment extends Fragment {


	public static final int MIN_ROW = 0;
	public static final int MIN_COL = 0;
	public static final int MAX_ROW = 6;
	public static final int MAX_COL = 6;
	public static final int WHITE_LEVEL = 1;
	public static final int BOARD_SIZE = 6;
	public static final int MIN_BLACK_SQUARES = 10;
	public static final int MAX_BLACK_SQUARES = 14;

	/**
	 * Called to do initial creation of a fragment.
	 * @param savedInstanceState If the fragment is being re-created from a previous saved state,
	 *                           this is the state.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
}

	/**
	 * Called to have the fragment instantiate its user interface view.
	 * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment
	 * @param container If non-null, this is the parent view that the fragment's UI should be
	 *                  attached to. The fragment should not add the view itself, but this can be
	 *                  used to generate the LayoutParams of the view.
	 * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous
	 *                           saved state as given here
	 * @return The View for the fragment's UI, or null
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.hard_frag_view, container, false);

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

	/**
	 * Called when the Fragment is no longer resumed.
	 */
	@Override
	public void onPause() {
		super.onPause();
	}
}

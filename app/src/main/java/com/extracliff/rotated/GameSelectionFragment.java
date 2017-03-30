/*
 * File: GameSelectionFragment.java
 * Description: Offers the user three choices for the difficulty of the game
 * Version: 1.0
 * Date: 1/30/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Allows the user to select an easy, medium, or hard game
 */
public class GameSelectionFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * Handles clicks on the three different difficulty settings
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.game_selection_frag_view, container, false);

		Button easy = (Button) rootView.findViewById(R.id.easyButton);
		easy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EasyGameFragment easyGameFrag = new EasyGameFragment();
				showOtherFragment(easyGameFrag);
			}
		});
		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	/**
	 * Switches to the specified fragment
	 *
	 * @param desiredFragment represents the fragment that the main activity will switch to
	 */
	public void showOtherFragment(Fragment desiredFragment) {
		FragmentChangeListener fc = (FragmentChangeListener)getActivity();
		fc.replaceFragment(desiredFragment);
	}
}


/*
 * File: StartFragment.java
 * Description: The first fragment displayed to the user upon start up and the fragment that acts
 *              as the 'home screen' of the app
 * Version: 0.1
 * Date: 3/30/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

// TODO: Play will lead to easy, medium, hard game selection
// TODO: Levels will lead to level selection
// TODO: Themes will lead to theme selection
// TODO: Help will lead to tutorial on how to play (and maybe tips for gesture shortcuts)

/**
 * Acts as the start menu and allows the user to start a game, change themes, or get help
 */
public class StartFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * Handles clicks on the ImageViews to navigate user to the following screen
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.start_frag_view, container, false);

	  ImageView play = (ImageView) rootView.findViewById(R.id.playButton);
    play.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	// takes the user to the game selection screen
	    	GameSelectionFragment gameSelectFrag = new GameSelectionFragment();
	    	showOtherFragment(gameSelectFrag);
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

/*
 * File: StartFragment.java
 * Description: The first fragment displayed to the user upon start up and the fragment that acts
 *              as the 'home screen' of the app
 * Version: 0.11
 * Date: 4/2/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Acts as the start menu and allows the user to start a game, change themes, or get help.
 */
public class StartFragment extends Fragment {

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
		final View rootView = inflater.inflate(R.layout.start_frag_view, container, false);

	  ImageView play = (ImageView) rootView.findViewById(R.id.playButton);
    play.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	GameSelectionFragment gameSelectFrag = new GameSelectionFragment();
	    	showOtherFragment(gameSelectFrag);
	    }
	  });
		return rootView;
	}

	/**
	 * Called when the Fragment is no longer resumed.
	 */
	@Override
	public void onPause() {
		super.onPause();
	}

	/**
 	 * Switches to the specified fragment.
	 * @param desiredFragment The fragment that the main activity will switch to
	 */
	public void showOtherFragment(Fragment desiredFragment) {
		FragmentChangeListener fc = (FragmentChangeListener)getActivity();
		fc.replaceFragment(desiredFragment);
	}
}

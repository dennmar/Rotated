/*
 * File: HardGameFragment.java
 * Description: Allows the user to play a hard game of Rotated
 * Version: 0.1
 * Date: 4/8/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Starts a hard game of Rotated.
 */
public class HardGameFragment extends Fragment {

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

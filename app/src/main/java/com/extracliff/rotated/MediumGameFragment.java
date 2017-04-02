/*
 * File: MediumGameFragment.java
 * Description: Allows the user to play an medium game of Rotated
 * Version: 0.1
 * Date: 4/2/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Starts a medium game of Rotated.
 */
public class MediumGameFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.medium_frag_view, container, false);
		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}

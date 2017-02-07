package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.start_frag_view, container, false);

		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}

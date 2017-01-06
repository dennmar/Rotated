package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
		return inflater.inflate(R.layout.start_frag_view, container, false);
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}

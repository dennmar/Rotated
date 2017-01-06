package com.extracliff.rotated;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Displays the starting menus for the user
 */
public class MainActivity extends AppCompatActivity {

	/**
	 * Adds a StartFragment to its layout
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// prevents overlapping fragments if restored from a previous state
		if (savedInstanceState != null) {
			return;
		}

		StartFragment startFragment = new StartFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
				startFragment).commit();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}

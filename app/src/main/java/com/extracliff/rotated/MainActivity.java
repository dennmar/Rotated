/*
 * File: MainActivity.java
 * Description: The single activity used to switch all fragments for the user
 * Version: 0.12
 * Date: 4/11/17
 */

package com.extracliff.rotated;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Displays the starting menus for the user
 */
public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

	/**
	 * Called when the activity is first created.
	 * @param savedInstanceState  If the activity is being re-initialized after previously being
	 *                            shut down then this Bundle contains the data it most recently
	 *                            supplied in onSaveInstanceState(Bundle)
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

	/**
	 * Called after onCreate(Bundle) — or after onRestart() when the activity had been stopped, but
	 *   is now again being displayed to the user.
	 */
	@Override
	protected void onStart() {
		super.onStart();
	}

	/**
	 * Called after onRestoreInstanceState(Bundle), onRestart(), or onPause(), for your activity to
	 *   start interacting with the user.
	 */
  @Override
	protected void onResume() {
		super.onResume();
	}

	/**
	 * Called when an activity is going into the background, but has not (yet) been killed.
	 */
	@Override
	protected void onPause() {
		super.onPause();
	}

	/**
	 * Called when this activity is no longer visible to the user.
	 */
	@Override
	protected void onStop() {
		super.onStop();
	}

	/**
	 * Performs any final cleanup before an activity is destroyed.
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	/**
	 * Changes to the specified fragment.
	 * @param fragment The fragment that will be switched to
	 * Attribution: Stack Overflow
	 * 							http://stackoverflow.com/questions/21228721/how-to-replace-a-fragment-on-button-
	 *              click-of-that-fragment
	 *              Author of question: Top Cat - http://stackoverflow.com/users/3049917/top-cat
	 *              Author of answer: Ahmad Raza - http://stackoverflow.com/users/2105241/ahmad-raza
	 */
	@Override
	public void replaceFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, fragment, null);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}

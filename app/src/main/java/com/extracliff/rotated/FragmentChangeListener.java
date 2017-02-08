package com.extracliff.rotated;

import android.support.v4.app.Fragment;

/**
 * Used to switch a fragment with another fragment
 */

public interface FragmentChangeListener {

	/**
	 * Changes to the specified fragment
	 *
	 * @param fragment represents the fragment that will be switched to
	 */
	void replaceFragment(Fragment fragment);
}

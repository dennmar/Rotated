/*
 * File: FragmentChangeListener.java
 * Description: Switches to a given fragment
 * Version: 1.0
 * Date: 3/30/17
 */

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

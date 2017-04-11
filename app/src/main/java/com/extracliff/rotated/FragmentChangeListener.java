/*
 * File: FragmentChangeListener.java
 * Description: Switches to a given fragment
 * Version: 1.01
 * Date: 4/11/17
 */

package com.extracliff.rotated;

import android.support.v4.app.Fragment;

/**
 * Used to switch a fragment with another fragment
 * Attribution: Stack Overflow
 * 							http://stackoverflow.com/questions/21228721/how-to-replace-a-fragment-on-button-
 *              click-of-that-fragment
 *              Author of question: Top Cat - http://stackoverflow.com/users/3049917/top-cat
 *              Author of answer: Ahmad Raza - http://stackoverflow.com/users/2105241/ahmad-raza
 */

public interface FragmentChangeListener {

	/**
	 * Changes to the specified fragment
	 * @param fragment represents the fragment that will be switched to
	 */
	void replaceFragment(Fragment fragment);
}

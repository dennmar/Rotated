/*
 * File: EasyGameFragment.java
 * Description: Allows the user to play an easy game of Rotated
 * Version: 0.11
 * Date: 1/30/17
 */

package com.extracliff.rotated;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class EasyGameFragment extends Fragment {

	public static final int MIN_ROW = 1;
	public static final int MIN_COL = 1;
	public static final int MAX_ROW = 5;
	public static final int MAX_COL = 5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.easy_frag_view, container, false);

		// sets click listeners for all squares
		for (int i = MIN_ROW; i <= MAX_ROW; i++) {
			for (int j = MIN_COL; j <= MAX_COL; j++) {
				String squareName = "r" + i + "c" + j;
				int squareID = getResources().getIdentifier(squareName, "id",
						getContext().getPackageName());
				final ImageView currView = (ImageView)rootView.findViewById(squareID);
				currView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if (currView.getTag() == null || !currView.getTag().equals("black")) {
							currView.setImageResource(R.drawable.rounded_square_black_mdpi);
							currView.setTag("black");
						}
						else {
							currView.setImageResource(R.drawable.rounded_square_mdpi);
							currView.setTag("white");
						}
					}
				});
			}
		}

		return rootView;
	}
}

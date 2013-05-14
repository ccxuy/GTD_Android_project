package com.gtdtool.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gtdtool.control.MainControl;
import com.gtdtool.object.GtdEvent;
import com.gtdtool.R;

/**
 * A fragment representing a single GtdEventFolder detail screen. This fragment
 * is either contained in a {@link GtdEventFolderListActivity} in two-pane mode
 * (on tablets) or a {@link GtdEventFolderDetailActivity} on handsets.
 */
public class GtdEventFolderDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The GtdEvent content this fragment is presenting.
	 */
	private GtdEvent mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public GtdEventFolderDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the GtdEvent content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = MainControl.gtdEventsOp.events_map.get(
					getArguments().containsKey(ARG_ITEM_ID));
		}
	}

	/* 
	 * TODO: Generate view of GtdEvent content here
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.fragment_gtdeventfolder_detail, container, false);

		// Show the content as text in a TextView.
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.gtdeventfolder_detail))
					.setText(mItem.getName());
		}

		return rootView;
	}
}

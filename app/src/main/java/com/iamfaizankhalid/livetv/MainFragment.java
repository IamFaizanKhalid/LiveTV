package com.iamfaizankhalid.livetv;

import android.os.Bundle;
import android.widget.Toast;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

public class MainFragment extends BrowseSupportFragment implements CardClickListener {

	@Override
	public void onCardClicked(Video video) {
		// Implement your logic to navigate to video playback fragment
		navigateToVideoPlaybackFragment(video);
	}

	private void navigateToVideoPlaybackFragment(Video video) {
		// Display a toast message to indicate the click event
		Toast.makeText(requireContext(), "Card clicked: " + video.getTitle(), Toast.LENGTH_SHORT).show();

		// Create a new instance of VideoPlaybackFragment and pass the clicked video's information
		VideoPlaybackFragment playbackFragment = VideoPlaybackFragment.newInstance(video);

		// Use FragmentManager to replace the current fragment with the video playback fragment
		requireFragmentManager()
				.beginTransaction()
				.replace(R.id.main_browse_fragment, playbackFragment)
				.addToBackStack(null)
				.commit();
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Set title
		setTitle("Live TV");

		// Example headers
		setHeadersState(HEADERS_ENABLED);
		setHeadersTransitionOnBackEnabled(true);

		// Create and set a new header
		HeaderItem header = new HeaderItem(0, "News");

		CardPresenter cardPresenter = new CardPresenter();
		cardPresenter.setCardClickListener(this); // Set the click listener

		ArrayObjectAdapter adapter = new ArrayObjectAdapter(cardPresenter);

		// Add your video data to the adapter
		Video video1 = new Video("Al Jazeera", "Al Jazeera");
		Video video2 = new Video("ARY News", "ARY News");
		// Add more videos as needed
		adapter.add(video1);
		adapter.add(video2);

		ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
		rowsAdapter.add(new ListRow(header, adapter));
		setAdapter(rowsAdapter);
	}
}

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
		String playbackUrl = video.getUrl();
		if (playbackUrl == "") {
			Toast.makeText(requireContext(), "Fetch to get stream", Toast.LENGTH_LONG).show();
			return;
		}

		// Create a new instance of VideoPlaybackFragment and pass the clicked video's information
		ExoPlayerFragment exoPlayerFragment = ExoPlayerFragment.newInstance(playbackUrl);

		// Use FragmentManager to replace the current fragment with the video playback fragment
		requireFragmentManager()
				.beginTransaction()
				.replace(R.id.main_browse_fragment, exoPlayerFragment)
				.addToBackStack(null)
				.commit();
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

//		NewPipe.init(getDownloader());

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


	// Downloader
//	protected Downloader getDownloader() {
//		final DownloaderImpl downloader = DownloaderImpl.init(null);
//		setCookiesToDownloader(downloader);
//		return downloader;
//	}
//
//	protected void setCookiesToDownloader(final DownloaderImpl downloader) {
//		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
//
//		downloader.setCookie("recaptcha_cookies", prefs.getString("recaptcha_cookies", null));
//		downloader.updateYoutubeRestrictedModeCookies(false);
//	}

}

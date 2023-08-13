package com.iamfaizankhalid.livetv;

import android.os.Bundle;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

public class MainFragment extends BrowseSupportFragment {

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
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(new CardPresenter());

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

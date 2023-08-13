package com.iamfaizankhalid.livetv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

public class VideoPlaybackFragment extends Fragment {
    private static final String ARG_VIDEO = "video";

    public static VideoPlaybackFragment newInstance(Video video) {
        VideoPlaybackFragment fragment = new VideoPlaybackFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_VIDEO, video);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate your fragment's layout here and set up video playback
        // Use getArguments() to retrieve the Video object passed to this fragment
        // Implement video playback logic here
        View rootView = inflater.inflate(R.layout.fragment_video_playback, container, false);

        // Initialize and configure your video playback here, using the VideoView
        VideoView videoView = rootView.findViewById(R.id.video_view);

        // Set the video URI and start playback, etc.

        return rootView;
    }

}

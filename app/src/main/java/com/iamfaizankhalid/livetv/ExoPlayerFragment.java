package com.iamfaizankhalid.livetv;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class ExoPlayerFragment extends Fragment {
	private PlayerView playerView;
	private ExoPlayer player;

	public static ExoPlayerFragment newInstance(String videoUrl) {
		ExoPlayerFragment fragment = new ExoPlayerFragment();
		Bundle args = new Bundle();
		args.putString("ARG_VIDEO_URL", videoUrl);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_exo_player, container, false);
		playerView = rootView.findViewById(R.id.player_view);
		return rootView;
	}

	@Override
	public void onStart() {
		super.onStart();
		if (player == null) {
			initializePlayer();
		}
	}

	@Override
	public void onStop() {
		super.onStop();
		releasePlayer();
	}

	private void initializePlayer() {
		player = new ExoPlayer.Builder(requireContext()).build();

		playerView.setPlayer(player);
		playerView.setUseController(false);

		String videoUrl = getArguments().getString("ARG_VIDEO_URL");

		MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoUrl));
		player.setMediaItem(mediaItem);

		player.prepare();
		player.play();
	}

	private void releasePlayer() {
		if (player != null) {
			player.release();
			player = null;
		}
	}

}
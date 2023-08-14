package com.iamfaizankhalid.livetv;


import static org.schabi.newpipe.extractor.ServiceList.YouTube;

import android.os.AsyncTask;
import android.util.Log;

import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

import java.io.IOException;
import java.util.List;

class ExtractStreamTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... strings) {
		String link = strings[0];
		String playbackUrl = "";

		try {
			NewPipe.init(DownloaderImpl.init(null));

			YoutubeStreamExtractor extractor = (YoutubeStreamExtractor) YouTube.getStreamExtractor(link);
			extractor.fetchPage();


			List<VideoStream> streams = extractor.getVideoStreams();
			Log.d("VideoStreams", String.format("%d streams found", streams.size()));

			int maxHeight = 0;

			for (VideoStream stream : streams) {
				Log.d("VideoStream", String.format("%d: %s", stream.getHeight(), stream.getContent()));
				if (stream.getHeight() > maxHeight) {
					maxHeight = stream.getHeight();
					playbackUrl = stream.getContent();
				}
			}
		} catch (ExtractionException | IOException e) {
			e.printStackTrace();
		}

		return playbackUrl;
	}
}

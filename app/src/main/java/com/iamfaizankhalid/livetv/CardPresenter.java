package com.iamfaizankhalid.livetv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.TitleView;

public class CardPresenter extends Presenter {
	private CardClickListener cardClickListener;

	public void setCardClickListener(CardClickListener listener) {
		cardClickListener = listener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, Object item) {
		Video video = (Video) item;
		BaseCardView cardView = (BaseCardView) viewHolder.view;


		// Set card title and content using attributes in XML
		TitleView titleView = cardView.findViewById(R.id.title);
		titleView.setTitle(video.getTitle());

		TextView contentTextView = cardView.findViewById(R.id.content);
		contentTextView.setText(video.getDescription());

		cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Handle card click here
				if (cardClickListener != null) {
					Video clickedVideo = (Video) item;
					Log.d("CardClick", "Clicked on video: " + clickedVideo.getTitle());

					// Notify the listener about the card click
					cardClickListener.onCardClicked(clickedVideo);
				}
			}
		});

	}

	@Override
	public void onUnbindViewHolder(ViewHolder viewHolder) {
		// Clean up resources as needed
	}

}

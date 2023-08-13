package com.iamfaizankhalid.livetv;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.TitleView;

import android.widget.TextView;

public class CardPresenter extends Presenter {

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
            }
        });
    }


    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        // Clean up resources as needed
    }

}

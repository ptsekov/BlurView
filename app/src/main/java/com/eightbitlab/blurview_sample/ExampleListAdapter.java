package com.eightbitlab.blurview_sample;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class ExampleListAdapter extends RecyclerView.Adapter<ExampleListAdapter.Holder> {

    private static final int ITEMS_COUNT = 64;
    private LayoutInflater inflater;

    ExampleListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        ViewGroup thumbFrameView = itemView.findViewById(R.id.thumb_frame);
        BlurView blurView = itemView.findViewById(R.id.blur);
        setupBlur(blurView, thumbFrameView);
        itemView.setOnClickListener(v -> {
            itemView.setScaleX(itemView.getScaleX() == 1.0f ? 1.139f : 1.0f);
            itemView.setScaleY(itemView.getScaleY() == 1.0f ? 1.139f : 1.0f);
//            setupBlur(blurView, thumbFrameView);
        });
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return ITEMS_COUNT;
    }

    private void setupBlur(BlurView blurView, ViewGroup rootView) {
        blurView.setupWith(rootView, new RenderScriptBlur(blurView.getContext()))
                .setBlurRadius(0.7f);
    }

    static class Holder extends RecyclerView.ViewHolder {
        Holder(View itemView) {
            super(itemView);
        }
    }
}

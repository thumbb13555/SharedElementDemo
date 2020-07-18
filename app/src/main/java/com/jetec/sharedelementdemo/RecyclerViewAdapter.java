package com.jetec.sharedelementdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    int[] images;
    public OnImageClick onImageClick;

    /**
     * 使點擊到的資訊傳輸到Activity
     */
    public void ItemClick(OnImageClick onImageClick) {
        this.onImageClick = onImageClick;
    }

    public RecyclerViewAdapter(int[] images) {
        this.images = images;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_Image);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.imageView.setImageDrawable(holder.itemView.getResources().getDrawable(images[position]));
        /**偵測點擊了item*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClick.onImageClick(images[position], holder.imageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    /**
     * 設置interface,使點擊到的item資料傳輸至外部Activity
     */
    interface OnImageClick {
        void onImageClick(int imageId, ImageView imageView);
    }
}

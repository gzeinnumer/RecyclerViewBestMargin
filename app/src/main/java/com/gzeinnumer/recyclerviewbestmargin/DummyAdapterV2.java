package com.gzeinnumer.recyclerviewbestmargin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DummyAdapterV2 extends RecyclerView.Adapter<DummyAdapterV2.MyHolder> {

    int layout;
    int size = 20;
    OnItemClickListener onItemClickListener;
    Context context;

    public DummyAdapterV2(int layout, int size, OnItemClickListener onItemClickListener) {
        this.layout = layout;
        this.size = size;
        this.onItemClickListener = onItemClickListener;
    }

    public DummyAdapterV2(int layout, OnItemClickListener onItemClickListener) {
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), GblVariabel.anim));
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(position);
        });
        IntConverterHelper helper = new IntConverterHelper(context);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();
        int t = 32; //out
        int h = 16; //out
        int m = 10; //top-bottom
        int l = m/2; //center
        if (position == 0) {
            layoutParams.setMargins(helper.intToDp(h), helper.intToDp(t), helper.intToDp(h), helper.intToDp(l));
            holder.cardView.setLayoutParams(layoutParams);
        } else if (position == size-1){
            layoutParams.setMargins(helper.intToDp(h), helper.intToDp(l), helper.intToDp(h), helper.intToDp(t));
            holder.cardView.setLayoutParams(layoutParams);
        } else {
            layoutParams.setMargins(helper.intToDp(h), helper.intToDp(l), helper.intToDp(h), helper.intToDp(l));
            holder.cardView.setLayoutParams(layoutParams);
        }
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

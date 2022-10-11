package com.example.recycleview;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder>{

    LinkedList<Button> buttons = new LinkedList<Button>();
    int count;

    public myadapter(LinkedList<Button> buttons, int count){
        this.buttons = buttons;
        this.count = count;
    }

    @NonNull
    @Override
    public myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.re, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);



        }

        void setData(int position){

        }

    }

    public class Gridline extends RecyclerView.ItemDecoration{

        private int mSpanCount;//橫數目數量
        private int mRowSpacing;//行間距
        private int mColumSpacing;//列間距

        public Gridline (int spanCount, int rowSpacing, int columSpacing) {
            this.mSpanCount = spanCount;
            this.mRowSpacing = rowSpacing;
            this.mColumSpacing = columSpacing;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int colum = position % mSpanCount;

            //列間距
            outRect.left = mColumSpacing;

            //如果position > 行數, 說明不是在第一行, 則不指定行高, 其他行的上間距為 top=mRowSpacing
            if(position >= mSpanCount) {
                outRect.top = mRowSpacing; // item top
            }

        }
    }

}



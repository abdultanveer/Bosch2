package com.example.bosch;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContentRVAdapter extends RecyclerView.Adapter<ContentRVAdapter.ContentVH> {
Cursor mCursor;
int colIndexBody ; //index of column name
    public ContentRVAdapter(Cursor cursor) {
        mCursor = cursor;
         colIndexBody = mCursor.getColumnIndexOrThrow("body"); //index of column name

    }

    @NonNull
    @Override
    public ContentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout_item,parent,false);
        return new ContentVH(inflatedRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentVH holder, int position) {
        mCursor.moveToPosition(position);
        holder.tvRowItem.setText(mCursor.getString(colIndexBody));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    class  ContentVH extends RecyclerView.ViewHolder{
        TextView tvRowItem;
        public ContentVH(@NonNull View itemView) {
            super(itemView);
            tvRowItem = itemView.findViewById(R.id.tvRowItem);
        }
    }
}

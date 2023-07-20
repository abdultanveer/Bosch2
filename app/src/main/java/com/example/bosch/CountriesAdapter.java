package com.example.bosch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesVHolder> {
    public static String TAG = CountriesAdapter.class.getSimpleName();
    String[] mCountries;
    public CountriesAdapter(String[] countries) {
        mCountries = countries;
    }

    @NonNull
    @Override
    public CountriesVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"arvind bought a row plank from market and reserving in the holder");
        View rowPlank = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new CountriesVHolder(rowPlank);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesVHolder holder, int position) {
        Log.i(TAG,"keerthana is writing -- "+mCountries[position]+"-position is"+position);
        holder.rowTextView.setText(mCountries[position]);

    }

    @Override
    public int getItemCount() {
        Log.i(TAG,"abhishek counted -- "+mCountries.length);

        return mCountries.length;
    }

    class CountriesVHolder extends RecyclerView.ViewHolder{
    TextView rowTextView;
        public CountriesVHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG,"varsha received row plank");

            rowTextView = itemView.findViewById(R.id.tvRow);
        }
    }
}

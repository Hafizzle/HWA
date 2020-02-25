package com.hafizzle.huntwiseapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.hafizzle.huntwiseapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mDates = new ArrayList<>();
    private ArrayList<String> mMinTemps = new ArrayList<>();
    private ArrayList<String> mMaxTemps = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> dates, ArrayList<String> minTemps, ArrayList<String> maxTemps ) {
        mDates = dates;
        mMinTemps = minTemps;
        mMaxTemps = maxTemps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_cardview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.date.setText(mDates.get(position));
        holder.minTemp.setText(mMinTemps.get(position));
        holder.maxTemp.setText(mMaxTemps.get(position));

        /*
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView date;
        TextView minTemp;
        TextView maxTemp;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            minTemp = itemView.findViewById(R.id.minTemp);
            maxTemp = itemView.findViewById(R.id.maxTemp);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
package io.github.coffeegerm.materiallogbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import io.github.coffeegerm.materiallogbook.R;
import io.github.coffeegerm.materiallogbook.model.EntryItem;

/**
 * Created by David Yarzebinski on 6/25/2017.
 * <p>
 * Adapter used for listFragment
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.holder> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.US);
    private List<EntryItem> mEntryItemList;
    private LayoutInflater inflater;

    public ListAdapter(List<EntryItem> entryItemList, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.mEntryItemList = entryItemList;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(holder mHolder, int position) {
        EntryItem item = mEntryItemList.get(position);
        String formattedDate = dateFormat.format(item.getDate());
        String formattedTime = timeFormat.format(item.getDate());
        mHolder.tvDate.setText(formattedDate);
        mHolder.tvTime.setText(formattedTime);
        mHolder.tvBloodGlucose.setText(String.valueOf(item.getGlucose()));
        mHolder.tvCarbohydrates.setText(String.valueOf(item.getCarbohydrates()));
        mHolder.tvInsulin.setText(String.valueOf(item.getInsulin()));
    }

    @Override
    public int getItemCount() {
        return mEntryItemList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        private TextView tvDate;
        private TextView tvTime;
        private TextView tvBloodGlucose;
        private TextView tvInsulin;
        private TextView tvCarbohydrates;

        public holder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvBloodGlucose = (TextView) itemView.findViewById(R.id.tv_blood_glucose);
            tvInsulin = (TextView) itemView.findViewById(R.id.tv_insulin);
            tvCarbohydrates = (TextView) itemView.findViewById(R.id.tv_carbs);
        }
    }
}
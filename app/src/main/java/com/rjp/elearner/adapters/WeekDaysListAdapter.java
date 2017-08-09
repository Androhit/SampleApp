package com.rjp.elearner.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rjp.elearner.R;
import com.rjp.elearner.beans.WeeksBean;
import com.rjp.elearner.beans.WeeksDaysBean;

import java.util.ArrayList;

/**
 * Created by Rohit on 5/6/2016.
 */
public class WeekDaysListAdapter extends RecyclerView.Adapter<WeekDaysListAdapter.MyViewHolder> {

    private ArrayList<WeeksDaysBean> taskList;
    private ArrayList<WeeksDaysBean> arraylist;
    private Context mContext;
    private int[] clr;
    private int pos = 0;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvDay,tvDesc,tvStatus;

        public MyViewHolder(View view)
        {
            super(view);
            tvDay = (TextView) view.findViewById(R.id.tvDay);
            tvDesc = (TextView) view.findViewById(R.id.tvDesc);
            tvStatus = (TextView) view.findViewById(R.id.tvStatus);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public WeekDaysListAdapter(Context cont, ArrayList<WeeksDaysBean> arrList) {
        this.taskList = arrList;
        this.arraylist = new ArrayList<WeeksDaysBean>();
        this.arraylist.addAll(arrList);
        this.mContext = cont;
        this.clr = new int[]{R.color.md_brown_400,R.color.md_deep_orange_400,R.color.md_green_400,R.color.md_indigo_400,R.color.md_green_400,R.color.md_light_green_400,R.color.md_pink_400};
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.week_days_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final WeeksDaysBean objStud = taskList.get(position);

        pos = position;
        if(position>clr.length)
        {
            pos = 0;
        }

        holder.tvDay.setText(objStud.getDay());
        holder.tvDesc.setText(objStud.getDesc());
        holder.tvStatus.setText(objStud.getComplete_status()==0?"OPEN":"PENDING");
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    // Filter Class
    /*public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        taskList.clear();
        if (charText.length() == 0) {
            taskList.addAll(arraylist);
        } else {
            for (NoticeBean wp : arraylist) {
                if (wp.getCir_date().toLowerCase(Locale.getDefault())
                        .contains(charText)|| wp.getCircular_title().toLowerCase(Locale.getDefault())
                        .contains(charText) || wp.getCir_date().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    taskList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }*/

}
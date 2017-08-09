package com.rjp.elearner.adapters;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.transition.TransitionManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rjp.elearner.R;
import com.rjp.elearner.beans.WeeksBean;
import com.rjp.elearner.beans.WeeksDaysBean;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Rohit on 5/6/2016.
 */
public class WeekListAdapter extends RecyclerView.Adapter<WeekListAdapter.MyViewHolder> {

    private ArrayList<WeeksBean> taskList;
    private ArrayList<WeeksBean> arraylist;
    private Context mContext;
    private int[] clr;
    private int pos = 0;
    private int mExpandedPosition = 0;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvWeek,tvDesc,tvDays,tvStatus;
        public RelativeLayout layMain;
        public RecyclerView rvList;

        public MyViewHolder(View view)
        {
            super(view);
            tvWeek = (TextView) view.findViewById(R.id.tvWeek);
            tvDesc = (TextView) view.findViewById(R.id.tvDesc);
            tvDays = (TextView) view.findViewById(R.id.tvDays);
            tvStatus = (TextView) view.findViewById(R.id.tvStatus);
            layMain = (RelativeLayout) view.findViewById(R.id.layMain);
            rvList = (RecyclerView) view.findViewById(R.id.rvList);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public WeekListAdapter(Context cont, ArrayList<WeeksBean> arrList) {
        this.taskList = arrList;
        this.arraylist = new ArrayList<WeeksBean>();
        this.arraylist.addAll(arrList);
        this.mContext = cont;
        this.clr = new int[]{R.color.md_brown_400,R.color.md_deep_orange_400,R.color.md_green_400,R.color.md_indigo_400,R.color.md_green_400,R.color.md_light_green_400,R.color.md_pink_400};
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weeks_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final WeeksBean objStud = taskList.get(position);

        pos = position;
        if(position>clr.length)
        {
            pos = 0;
        }

        holder.tvWeek.setText(objStud.getName());
        holder.tvDesc.setText(objStud.getDesc());
        holder.tvDays.setText("DAYS : "+objStud.getNo_of_days());
        holder.tvStatus.setText(objStud.getNo_of_days().equals("OPEN")?"OPEN":"PENDING");
        holder.layMain.setBackgroundColor(mContext.getResources().getColor(clr[pos]));

        ArrayList<WeeksDaysBean> arr = new ArrayList<>();

        WeeksDaysBean obj = new WeeksDaysBean();
        obj.setDesc("Basic Concepts of English Language");
        obj.setDay("First");
        obj.setComplete_status(0);
        arr.add(obj);
        obj = new WeeksDaysBean();
        obj.setDesc("Basic Concepts of English Language");
        obj.setDay("Second");
        obj.setComplete_status(0);
        arr.add(obj);
        obj = new WeeksDaysBean();
        obj.setDesc("Basic Concepts of English Language");
        obj.setDay("Third");
        obj.setComplete_status(0);
        arr.add(obj);

        WeekDaysListAdapter adapter = new WeekDaysListAdapter(mContext,arr);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        holder.rvList.setLayoutManager(mLayoutManager);
        holder.rvList.setItemAnimator(new DefaultItemAnimator());
        holder.rvList.setAdapter(adapter);

        final boolean isExpanded = position==mExpandedPosition;
        holder.rvList.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                TransitionManager.beginDelayedTransition(holder.rvList);
                notifyDataSetChanged();
            }
        });
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
package com.rjp.elearner.adapters;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rjp.elearner.R;
import com.rjp.elearner.beans.WeeksBean;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Rohit on 5/6/2016.
 */
public class WeekListAdapter extends RecyclerView.Adapter<WeekListAdapter.MyViewHolder> {

    private ArrayList<WeeksBean> taskList;
    private ArrayList<WeeksBean> arraylist;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvSubject,tvCredit,tvSessionPlan,tvTimeTable;
        public LinearLayout layMain;

        public MyViewHolder(View view)
        {
            super(view);
            tvSubject = (TextView) view.findViewById(R.id.tvPSubject);
            tvCredit = (TextView) view.findViewById(R.id.tvPCredit);
            tvSessionPlan = (TextView) view.findViewById(R.id.tvPSessPlan);
            tvTimeTable = (TextView) view.findViewById(R.id.tvPTimetable);
            layMain = (LinearLayout)view.findViewById(R.id.layMain);

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
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weeks_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final WeeksBean objStud = taskList.get(position);

        holder.tvSubject.setText(objStud.getId());
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
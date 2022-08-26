package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.Transliterator;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {
    todayFragment main=new todayFragment();
    Context context;
    ArrayList<PostPojo> arrdata;
    ItemClickListener mitemClickListener;
   final String[] month={"00","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    RecyclerAdapter(Context context, ArrayList<PostPojo> arrdata,ItemClickListener itemClickListener){
        this.context=context;
        this.arrdata=arrdata;
        this.mitemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.recyclercard,parent,false);
       viewHolder viewHolder=new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.task.setText(arrdata.get(position).getDescription());
       String md= arrdata.get(position).getScheduledDate().substring(4,8);
       holder.date.setText(month[Integer.parseInt(md.substring(0,2))]+" "+md.substring(2));

        if(arrdata.get(position).getStatus().equalsIgnoreCase("COMPLETED")){
            holder.box.setChecked(true);
            holder.box.setEnabled(false);
            holder.task.setTextColor(Color.parseColor("#d4d5d5"));
        }
        else{
            holder.box.setChecked(false);
        }

        holder.itemView.setOnClickListener(view -> {
            mitemClickListener.onItemClick(arrdata.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    public interface ItemClickListener{
        void onItemClick(PostPojo details);
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView task,date;
        CheckBox box;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            task=itemView.findViewById(R.id.task);
            date=itemView.findViewById(R.id.date);
            box=itemView.findViewById(R.id.box);
        }
    }


}

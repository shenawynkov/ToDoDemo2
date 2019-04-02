package com.example.shenawynkov.tododemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.shenawynkov.tododemo.data.TodoEntity;
import com.example.shenawynkov.tododemo.dbBackground.Tasks;
import com.example.shenawynkov.tododemo.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<TodoEntity> mDataset;
    private  Context context;
    Tasks.UpdateTask updateTask;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CheckBox checkBox;
        public MyViewHolder(CheckBox v) {
            super(v);
            checkBox = v;
        }
    }

    public MyAdapter(  Context context) {
        mDataset = new ArrayList<>();
        this.context=context;
    }
 public void setData(List<TodoEntity> data)
 {
mDataset.clear();
mDataset.addAll(data);
     notifyDataSetChanged();
 }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        CheckBox v = (CheckBox) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.checkBox.setText(mDataset.get(position).getTodoString());
        holder.checkBox.setChecked(mDataset.get(position).todoFinished);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TodoEntity entity=(mDataset.get(position));

                entity.setTodoFinished(isChecked);
                updateTask=new Tasks().new UpdateTask(context);

                updateTask.execute(entity);


            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {


        return mDataset.size();
    }
}
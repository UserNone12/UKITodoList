package com.vvibu.todolist_3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder>{
    Context context ;
    List<ToDo> list;

    public ToDoAdapter(Context context, List<ToDo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvname.setText(list.get(position).getNamaToDo());
        if (list.get(position).getStatusToDo().equals("0")){
            holder.tvstatus.setText("Belum Selesai");
        } else {
            holder.tvstatus.setText("Clear");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityEditTodo.class);
                intent.putExtra("ID", list.get(position).getIdToDo());
                intent.putExtra("Nama", list.get(position).getNamaToDo());
                intent.putExtra("Status", list.get(position).getStatusToDo());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname, tvstatus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView)itemView.findViewById(R.id.tvname);
            tvstatus = (TextView)itemView.findViewById(R.id.tvstatus);

        }
    }
}

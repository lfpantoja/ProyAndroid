package com.example.lista;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> nameList;

    public  MyAdapter(List<String> list){
        nameList = list;

    }


    private void remove(int position) {
        nameList.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override // Recorremos la lista y modificamos los valores de textview
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String name = nameList.get(position);
        holder.textView.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            remove(position);
        } });

    }

    @Override
    public int getItemCount() {
        if(nameList==null){
            return 0;
        }else{
            return  nameList.size();
        }

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;


        public  MyViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
}

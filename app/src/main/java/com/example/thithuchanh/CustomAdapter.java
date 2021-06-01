package com.example.thithuchanh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    List<User> mUsers;
    onClickListener listener;

    public CustomAdapter(List<User> users,onClickListener listener1) {
        mUsers = users;
        listener = listener1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CustomAdapter.ViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.muser = user;
        holder.tvName.setText(user.getName());
        holder.tvAge.setText(user.getAge());
        holder.tvDepart.setText(user.getDepartment());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setList(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAge, tvDepart;
        User muser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName_main);
            tvAge = itemView.findViewById(R.id.tvAge_main);
            tvDepart = itemView.findViewById(R.id.tvDepart_main);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.ClickItem(muser);
                }
            });
        }

    }
}

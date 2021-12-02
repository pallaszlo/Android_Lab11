package ro.sapi.retrofitapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.CustomViewHolder> {

    private List<Todo> dataList;
    private Context context;

    public TodoAdapter(Context context,List<Todo> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView title, userId, completed;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            title = mView.findViewById(R.id.title2);
            userId = mView.findViewById(R.id.userId);
            completed = mView.findViewById(R.id.completed);
        }
    }

    @NonNull
    @Override
    public TodoAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.todo_item, parent, false);
        return new TodoAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.CustomViewHolder holder, int position) {
        holder.userId.setText(dataList.get(position).getUserId().toString());
        holder.title.setText(dataList.get(position).getTitle());
        holder.completed.setText(dataList.get(position).getCompleted().toString());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

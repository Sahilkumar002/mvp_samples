package devil.mvplogin.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import devil.mvplogin.R;
import devil.mvplogin.models.retrofit.pojos.Posts;

/**
 * Created by devil on 3/23/18.
 */

public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.PostHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Posts> list;

    public PostsListAdapter(Context mContext, List<Posts> list) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }

    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(mLayoutInflater.inflate(R.layout.row_posts, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.tvPost.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        TextView tvPost;

        public PostHolder(View itemView) {
            super(itemView);
            tvPost = itemView.findViewById(R.id.tvPost);
        }
    }

}

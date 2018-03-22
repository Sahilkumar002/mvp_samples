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
import devil.mvplogin.models.Users;

/**
 * Created by devil on 3/22/18.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UserHolder> {

    private Context mContext;
    private List<Users> list;
    private LayoutInflater mLayoutInflater;

    public UsersListAdapter(Context mContext, List<Users> list) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }

    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(mLayoutInflater.inflate(R.layout.row_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public UserHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvUserName);
        }
    }
}

package devil.mvplogin.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import devil.mvplogin.R;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.utils.GeneralFunctions;
import devil.mvplogin.views.activities.HomeActivity;
import devil.mvplogin.views.fragments.UserPostsFragment;

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

    @NonNull
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
        @BindView(R.id.tvUserName) TextView textView;

        UserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.findViewById(R.id.btnPost).setOnClickListener(view -> openPostFragment(getAdapterPosition()));
        }
    }

    private void openPostFragment(int adapterPosition) {
        GeneralFunctions.addFragment(((HomeActivity) mContext).getFragmentManager(),
                UserPostsFragment.newInstance(list.get(adapterPosition).getId()), "Users Post",
                R.id.flHolder);
    }
}

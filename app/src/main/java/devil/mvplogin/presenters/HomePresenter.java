package devil.mvplogin.presenters;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

import devil.mvplogin.models.BaseInteractor;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.models.retrofit.OnResponseCallBack;
import devil.mvplogin.models.retrofit.RestClient;
import devil.mvplogin.utils.ApplicationGlobal;
import devil.mvplogin.viewInterfaces.HomeView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private BaseInteractor<List<Users>> interactor;

    private DatabaseReference databaseReference;
    private List<Users> usersList = new ArrayList<>();

    @Override
    public void attachView(HomeView view) {
        super.attachView(view);
        interactor = new BaseInteractor<>();
        usersList = new ArrayList<>();
        databaseReference = ApplicationGlobal.getDatabaseInstance().getReference("User Login");
    }


    public void loadUsers() {
        getView().showDialog();

        // Firebase Database
            usersList.clear();
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    getView().dismissDialog();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Users users = snapshot.getValue(Users.class);
                        if (!usersList.toString().contains(users.getName())) {
                            usersList.add(users);
                        }
                    }
                    getView().updateList(usersList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    getView().dismissDialog();
                    getView().showMessage("Error");
                }
            });
//        disposable.add(interactor.getDisposable(RestClient.getClient().getUsers(), new OnResponseCallBack() {
//            @Override
//             void onSuccess(Response<?> response) {
//                getView().dismissDialog();
//                try { getView()
//                    if (response.code() == 200 && response.body() != null) {
//                        getView().updateList((List<Users>) response.body());
//                    } else {
//                        getView().showMessage("API Error");
//                    }
//                } catch (Exception e) {
//                    getView().showMessage(e.getLocalizedMessage());
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                getView().dismissDialog();
//                getView().showMessage(t.getLocalizedMessage());
//            }
//        }));

//        interactor.getRetrofitCall(RestClient.getClient().getUsers(), new OnResponseCallBack() {
//            @Override
//            public void onSuccess(Response<?> response) {
//                getView().dismissDialog();
//                try {
//                    if (response.code() == 200 && response.body() != null) {
//                        getView().updateList((List<?>) response.body());
//                    } else {
//                        getView().showMessage("API Error");
//                    }
//                } catch (Exception e) {
//                    getView().showMessage(e.getLocalizedMessage());
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                getView().dismissDialog();
//                getView().showMessage(t.getLocalizedMessage());
//            }
//        });
    }

}

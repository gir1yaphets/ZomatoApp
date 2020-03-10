package com.example.zomatoapp.viewModel;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.zomatoapp.activities.HomeActivity;
import com.example.zomatoapp.helper.SharePreHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import static com.example.zomatoapp.utils.StaticValues.SHARE_PRE_KEY_UUID;

public class LoginViewModel extends AndroidViewModel {
    private static final String TAG = LoginViewModel.class.getName();

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private FirebaseAuth auth;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        auth = FirebaseAuth.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void onSignIn(View view) {
        if (email.getValue() == null || password.getValue() == null) {
            Toast.makeText(getApplication(), "Please input valid email and password.", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email.getValue(), password.getValue())
                .addOnCompleteListener(getApplication().getMainExecutor(), (task) -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = auth.getCurrentUser();
                        SharePreHelper.putString(getApplication(), SHARE_PRE_KEY_UUID, user.getUid());

                        navigateToHomeActivity();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(getApplication(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void onSignUp(View view) {
        if (email.getValue() == null || password.getValue() == null) {
            Toast.makeText(getApplication(), "Please input valid email and password.", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email.getValue(), password.getValue())
                .addOnCompleteListener(getApplication().getMainExecutor(),
                        (task) -> {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();

                                Toast.makeText(getApplication(), "Authentication Successful!.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplication(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
    }

    public void onSkip(View view) {
        navigateToHomeActivity();
    }

    private void navigateToHomeActivity() {
        Intent intent = new Intent(getApplication(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }
}

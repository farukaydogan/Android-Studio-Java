package com.example.farukfinal.ui.logout;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farukfinal.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutFragment extends Fragment {

    FirebaseAuth mAuth;


    public static LogoutFragment newInstance() {
        return new LogoutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Intent intent= new Intent(getActivity(), com.example.farukfinal.SplashScreen.class);
        startActivity(intent);
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }


}
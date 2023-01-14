package com.example.farukfinal.ui.groupAddMember;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farukfinal.R;

public class GroupAddMemberFragment extends Fragment {

    private GroupAddMemberViewModel mViewModel;

    public static GroupAddMemberFragment newInstance() {
        return new GroupAddMemberFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_group_add_member, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GroupAddMemberViewModel.class);
        // TODO: Use the ViewModel
    }

}
package com.example.replicabottomnavigationapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.replicabottomnavigationapp.MainActivity;
import com.example.replicabottomnavigationapp.R;
import com.example.replicabottomnavigationapp.StudentRVadapter;
import com.example.replicabottomnavigationapp.modelclass.Student;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.studentRecycler);

        if(MainActivity.students.isEmpty()) {
            MainActivity.students.add(new Student("Anmol Koirala", "Male", "23", "Nepal"));
            MainActivity.students.add(new Student("Jenna Louise Coleman", "Female", "25", "U.S.A"));
            StudentRVadapter adapter = new StudentRVadapter(MainActivity.students, getContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        }else {
            StudentRVadapter adapter2 = new StudentRVadapter(MainActivity.students, getContext());
            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager2);
            recyclerView.setAdapter(adapter2);
        }




        return root;
    }
}
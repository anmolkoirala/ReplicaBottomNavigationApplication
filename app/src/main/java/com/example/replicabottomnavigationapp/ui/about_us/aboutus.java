package com.example.replicabottomnavigationapp.ui.about_us;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.replicabottomnavigationapp.R;

public class aboutus extends Fragment {

    private AboutusViewModel mViewModel;
    WebView webView;

    public static aboutus newInstance() {
        return new aboutus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(AboutusViewModel.class);
        View root = inflater.inflate(R.layout.aboutus_fragment, container, false);

        webView = root.findViewById(R.id.softwaricasitelink);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://softwarica.edu.np/");

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutusViewModel.class);
        // TODO: Use the ViewModel
    }

}

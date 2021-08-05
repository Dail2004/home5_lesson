package com.example.home5_lesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private String mTitle;
    private String mDescription;
    private int mImage;

    Button next;
    private TextView txtTitle, txtDescription;
    private ImageView itemImage;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String title, String description, int image) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, description);
        args.putInt(ARG_PARAM3, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_PARAM1);
            mDescription = getArguments().getString(ARG_PARAM2);
            mImage = getArguments().getInt(ARG_PARAM3);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        txtTitle = view.findViewById(R.id.text);
        txtDescription = view.findViewById(R.id.text2);
        itemImage = view.findViewById(R.id.image);txtTitle.setText(mTitle);
        txtDescription.setText(mDescription);
        itemImage.setImageResource(mImage);
        return view;
    }
}
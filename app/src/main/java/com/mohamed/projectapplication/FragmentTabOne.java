package com.mohamed.projectapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentTabOne extends Fragment {
    private EditText mFirstName,mLastName,mIdNumber,mYearOfStudy;
    private  RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private Button mButton;
    private ProgressBar mProgressBar;

    private Context mContext = getActivity();

    private String first_name;
    private String last_name;
    private int id;
    private int yearOfStudy;


    public FragmentTabOne() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab_one,container,false);

        mFirstName = view.findViewById(R.id.first_name);
        mLastName = view.findViewById(R.id.last_name);
        mIdNumber = view.findViewById(R.id.id_number);
        mButton = view.findViewById(R.id.getBtn);
        mProgressBar = view.findViewById(R.id.progressBar);
        mYearOfStudy = view.findViewById(R.id.year_of_study);
        mRadioGroup = view.findViewById(R.id.radioGroup);
        mRadioGroup.clearCheck();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mRadioButton = group.findViewById(checkedId);
            }
        });
        int selectedId = mRadioGroup.getCheckedRadioButtonId();
        mRadioButton = view.findViewById(selectedId);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                uploadData();
            }
        });
        return view;
    }

    private void uploadData() {

        if (TextUtils.isEmpty(mFirstName.getText().toString())) {
            Toast.makeText(getActivity(), "First Name cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            first_name = mFirstName.getText().toString();
        }
        if (TextUtils.isEmpty(mLastName.getText().toString())){
            Toast.makeText(getActivity(), "Last Name cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }else {
            last_name = mLastName.getText().toString();
        }
        if (TextUtils.isEmpty(mIdNumber.getText().toString())){
            Toast.makeText(getActivity(), "Id cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }else {
            id = Integer.parseInt(mIdNumber.getText().toString());
        }
        if (TextUtils.isEmpty(mYearOfStudy.getText().toString())){
            Toast.makeText(getActivity(), "Year of Study cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }else {
            yearOfStudy = Integer.parseInt(mYearOfStudy.getText().toString());
        }
        int selectedId =mRadioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(getActivity(), "No Gender has been selected", Toast.LENGTH_SHORT).show();
                        }
                        else {

            mRadioButton = mRadioGroup.findViewById(selectedId);

            // Now display the value of selected item
            // by the Toast message
            String gender = mRadioButton.getText().toString();
            User user = new User(first_name, last_name, gender, id, yearOfStudy);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(getString(R.string.user));
            String uid = myRef.push().getKey();
            myRef.child(uid).setValue(user);
            mProgressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getContext(), "Posted", Toast.LENGTH_SHORT).show();

            mFirstName.setText("");
            mLastName.setText("");
            mIdNumber.setText("");
            mYearOfStudy.setText("");


        }




    }
}

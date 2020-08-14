package com.mohamed.projectapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentTabTwo extends Fragment implements View.OnClickListener {

    private static final String TAG = "FragmentTabTwo";
    private CheckBox android, java, python, angular, reactJs, c, js;
    private List<String> subjects = new ArrayList<>();
    private Button btnSubmit;

    public FragmentTabTwo() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab_two, container, false);
        // initiate views
        android = view.findViewById(R.id.chkAndroid);
        android.setOnClickListener(this);
        java = view.findViewById(R.id.chkJava);
        java.setOnClickListener(this);
        python = view.findViewById(R.id.chkPython);
        python.setOnClickListener(this);
        angular = view.findViewById(R.id.chkAngular);
        angular.setOnClickListener(this);
        reactJs = view.findViewById(R.id.chkReact);
        reactJs.setOnClickListener(this);
        c = view.findViewById(R.id.chkC);
        c.setOnClickListener(this);
        js = view.findViewById(R.id.chkJavaScript);
        js.setOnClickListener(this);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSubmit = view.findViewById(R.id.getBtn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (subjects.size() > 5){
                    Toast.makeText(
                            requireContext(),
                            "Only five selections are needed",
                            Toast.LENGTH_SHORT
                    ).show();
                }else {
                    proceedToSubmit();
                }
            }
        });
    }

    private void proceedToSubmit() {
        Log.d(TAG, "proceedToSubmit: SUBJECTS: " + subjects);
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        switch (v.getId()) {
            case R.id.chkJava:
                if (checked)
                    subjects.add(getString(R.string.java));
                else
                    subjects.remove(getString(R.string.java));
                break;
            case R.id.chkAngular:
                if (checked)
                    subjects.add(getString(R.string.angularjs));
                else
                    subjects.remove(getString(R.string.angularjs));
                break;
                case R.id.chkPython:
                if (checked)
                    subjects.add(getString(R.string.python));
                else
                    subjects.remove(getString(R.string.python));
                break;
                case R.id.chkReact:
                if (checked)
                    subjects.add(getString(R.string.react));
                else
                    subjects.remove(getString(R.string.react));
                break;
                case R.id.chkAndroid:
                if (checked)
                    subjects.add(getString(R.string.android));
                else
                    subjects.remove(getString(R.string.android));
                break;
                case R.id.chkJavaScript:
                if (checked)
                    subjects.add(getString(R.string.javascript));
                else
                    subjects.remove(getString(R.string.javascript));
                break;
                case R.id.chkC:
                if (checked)
                    subjects.add(getString(R.string.c));
                else
                    subjects.remove(getString(R.string.c));
                break;
        }
    }
}

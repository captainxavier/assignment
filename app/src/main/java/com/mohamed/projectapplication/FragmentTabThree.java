package com.mohamed.projectapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragmentTabThree extends Fragment {
    private static final String TAG = "FragmentTabThree";

    private TextView actualAmount,feesPaid,balance;
    private EditText mFees;
    private LinearLayout mLin1,mLin2;
    private Button mButton;

    public FragmentTabThree() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab_three,container,false);
        actualAmount = view.findViewById(R.id.actualFees);
        feesPaid = view.findViewById(R.id.fees_paid);
        mFees = view.findViewById(R.id.paid);
        mButton = view.findViewById(R.id.btn_pay);
        balance = view.findViewById(R.id.balance);
        mLin1 = view.findViewById(R.id.linLayout);
        mLin1.setVisibility(View.VISIBLE);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLin2.setVisibility(View.VISIBLE);
                mLin1.setVisibility(View.INVISIBLE);
                payFees();
            }
        });

        mLin2 = view.findViewById(R.id.linlayout2);
        Integer paidI = 50000;
        Integer actualI = 120000;
        Integer balanceI = actualI-paidI;

        String strPaid = Integer.toString(paidI);
        String strActual = Integer.toString(actualI);
        String strBalance = Integer.toString(balanceI);


//        actualAmount.setText("Actual Fees "+strActual);
//        feesPaid.setText("Fees Paid "+strPaid);
//        balance.setText("Balance "+strBalance);
        return view;
    }

    private void payFees() {
        final int fees;
        if (TextUtils.isEmpty(mFees.getText().toString())){
            Toast.makeText(getActivity(), "Enter Amount", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            fees = Integer.parseInt(mFees.getText().toString());
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(getString(R.string.accounts));
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Accounts accounts = dataSnapshot.getValue(Accounts.class);
                Log.d(TAG, "Value is: " + accounts);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}

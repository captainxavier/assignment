package com.mohamed.projectapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTabThree extends Fragment {

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
        TextView actualAmount = view.findViewById(R.id.actualFees);
        TextView feesPaid = view.findViewById(R.id.fees_paid);
        TextView balance = view.findViewById(R.id.balance);
        Integer paidI = 50000;
        Integer actualI = 120000;
        Integer balanceI = actualI-paidI;

        String strPaid = Integer.toString(paidI);
        String strActual = Integer.toString(actualI);
        String strBalance = Integer.toString(balanceI);


        actualAmount.setText("Actual Fees "+strActual);
        feesPaid.setText("Fees Paid "+strPaid);
        balance.setText("Balance "+strBalance);
        return view;
    }
}

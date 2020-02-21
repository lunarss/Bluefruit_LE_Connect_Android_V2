package com.adafruit.bluefruit.le.connect.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adafruit.bluefruit.le.connect.R;

public class AlertLevelFragment extends ConnectedPeripheralFragment {


    public AlertLevelFragment() {
        // Required empty public constructor
    }

    public static AlertLevelFragment newInstance(@Nullable String singlePeripheralIdentifier) {
        AlertLevelFragment fragment = new AlertLevelFragment();
        fragment.setArguments(createFragmentArgs(singlePeripheralIdentifier));
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alertlevel, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Update ActionBar
        setActionBarTitle(R.string.contact_title);

        // UI
        Context context = getContext();
        if (context != null) {
            TextView CurrentAlertLevel = view.findViewById(R.id.current_alert_level);
            CurrentAlertLevel.setText(MainActivity.alertLevel);

            Button highButton = view.findViewById(R.id.high);
            Button lowButton = view.findViewById(R.id.low);

            highButton.setOnClickListener(view1 -> {
                MainActivity.alertLevel = "High";
                Toast.makeText(context, "Alert Level set to high", Toast.LENGTH_SHORT).show();
                CurrentAlertLevel.setText(MainActivity.alertLevel);
            });

            lowButton.setOnClickListener(view1 -> {
                MainActivity.alertLevel = "Low";
                Toast.makeText(context, "Alert Level set to low", Toast.LENGTH_SHORT).show();
                CurrentAlertLevel.setText(MainActivity.alertLevel);
            });
        }
    }

}

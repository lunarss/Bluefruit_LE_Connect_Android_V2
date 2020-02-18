package com.adafruit.bluefruit.le.connect.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adafruit.bluefruit.le.connect.R;
import com.adafruit.bluefruit.le.connect.utils.KeyboardUtils;

import static android.content.Context.MODE_PRIVATE;


public class ContactFragment extends ConnectedPeripheralFragment {
    private final static String TAG = ContactFragment.class.getSimpleName();


    private String regex = "^[+]?[0-9]{10,13}$";
    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance(@Nullable String singlePeripheralIdentifier) {
        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(createFragmentArgs(singlePeripheralIdentifier));
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Update ActionBar
        setActionBarTitle(R.string.contact_title);

        // UI
        Context context = getContext();
        if (context != null) {
            TextView CurrentContactName = (TextView) view.findViewById(R.id.currentName);
            TextView CurrentContactPhone = (TextView) view.findViewById(R.id.currentPhone);
            CurrentContactName.setText(MainActivity.contact);
            CurrentContactPhone.setText(MainActivity.phone);


            Button updateButton = view.findViewById(R.id.updateButton);
            EditText newName = view.findViewById(R.id.newName);
            EditText newPhone = view.findViewById(R.id.newPhone);

            updateButton.setOnClickListener(view1 -> {
                if (!newName.getText().toString().isEmpty()) {
                    if (newPhone.getText().toString().matches(regex)) {

                        MainActivity.contact = newName.getText().toString();
                        MainActivity.phone = newPhone.getText().toString();
                        CurrentContactName.setText(MainActivity.contact);
                        CurrentContactPhone.setText(MainActivity.phone);

                    } else {
                        Toast.makeText(context, "New phone number is invalid", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "New contact name is invalid", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



}

package com.example.alareencenter.MENU;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.alareencenter.MainActivity;
import com.example.alareencenter.R;
import com.example.alareencenter.Register;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogOut#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogOut extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LogOut() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogOut.
     */
    // TODO: Rename and change types and number of parameters
    public static LogOut newInstance(String param1, String param2) {
        LogOut fragment = new LogOut();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_out, container, false);
    }



    Button logout;
    AlertDialog.Builder alertDialog ;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(String.valueOf(getContext().getApplicationContext()));
                startActivity(i);
            }
        },200000);



        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Al Areen Center ");
        alertDialog.setMessage("Are you sure you want to exit");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                getActivity().finish();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = alertDialog.create();
        dialog.show();


    }
}


package com.vvibu.todolist_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragmentadd extends Fragment {

    EditText edtnama;
    Button btnadd;
    DatabaseHelper myDb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_add_to_do, container, false);

        edtnama = v.findViewById(R.id.edtNama);
        btnadd = v.findViewById(R.id.btnAdd);
        myDb = new DatabaseHelper(getActivity());

        //untuk menset button ketika dipencet
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (edtnama.getText().equals("")) {
                    edtnama.setError("Isi La");
                } else {
                    boolean isInsert = myDb.insertData(edtnama.getText().toString(), "0");
                    if (isInsert) {
                        Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Not Updated", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                }
            }
        });

        return v ;


        }

    }
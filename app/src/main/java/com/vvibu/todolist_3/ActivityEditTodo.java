package com.vvibu.todolist_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityEditTodo extends AppCompatActivity {
    //mendeklarasikan
    DatabaseHelper myDb;
    EditText edtnama;
    CheckBox cbclear;
    Button btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_todo);

        //inisialisasi
        edtnama = findViewById(R.id.edtNama1);
        cbclear = findViewById(R.id.cbclear);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        myDb = new DatabaseHelper(this);

        edtnama.setText(getIntent().getStringExtra("Nama"));
        if (getIntent().getStringExtra("Status").equals("0")) {
            cbclear.setChecked(false);
        } else {
            cbclear.setChecked(true);
        }

        //set button delete ketika di click
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.deleteData(getIntent().getStringExtra("ID"));
                startActivity(new Intent(ActivityEditTodo.this, MainActivity.class));
                finish();
            }
        });

        //set button update ketika diclick
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = "";
                if (cbclear.isChecked()) {
                    status = "1";
                } else {
                    status = "0";
                }

                if (edtnama.getText().equals("")) {
                    edtnama.setError("Isi La");
                } else {
                    String id = getIntent().getStringExtra("ID");
                    boolean isUpdate = myDb.updateData(edtnama.getText().toString(), status, id);
                    if (isUpdate) {
                        Toast.makeText(ActivityEditTodo.this, "Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ActivityEditTodo.this, "Not Updated", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(ActivityEditTodo.this, MainActivity.class));
                    finish();
                }
            }
        });

    }
}
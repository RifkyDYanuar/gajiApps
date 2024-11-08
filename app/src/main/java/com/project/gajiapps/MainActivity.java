package com.project.gajiapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private EditText txtNama;
    private TextView Nama, Status, Golongan, Gaji;
    private RadioGroup Grup;
    private RadioButton Gol1, Gol2;
    private CheckBox Menikah, BMenikah;
    private Button BtnGenerate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtNama = findViewById(R.id.nama);
        Grup = findViewById(R.id.grup);
        Gol1 = findViewById(R.id.gol1);
        Gol2 = findViewById(R.id.gol2);
        Menikah = findViewById(R.id.menikah);
        BMenikah = findViewById(R.id.belum);
        BtnGenerate = findViewById(R.id.generate);
        Nama = findViewById(R.id.namatext);
        Status = findViewById(R.id.statustext);
        Golongan = findViewById(R.id.golongantext);
        Gaji = findViewById(R.id.gajipokok);



        BtnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    new MaterialAlertDialogBuilder(MainActivity.this)
                            .setTitle("Generate")
                            .setMessage("Apakah data sudah bener ?")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    generate();

                                }
                            })
                            .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();


            }
        });



    }

    private void generate(){
        String nama = txtNama.getText().toString();
        double gaji = 0;


        if (nama.isEmpty()){
            Toast.makeText(this, "Nama Harus diisi", Toast.LENGTH_SHORT).show();
        }else {
            Nama.setText(nama);
        }
        int pilih = Grup.getCheckedRadioButtonId();
        if (pilih == Gol1.getId()) {
            Golongan.setText("Golongan 1");
            gaji = 2500000;
            Gaji.setText("Rp "+(int) gaji);
        } else if (pilih == Gol2.getId()) {
            Golongan.setText("Golongan 2");
            gaji = 2000000;
            Gaji.setText("Rp "+(int) gaji);
        }

        if (Menikah.isChecked()) {
            Status.setText("Menikah");
           double gapok = gaji + 500000;
            Gaji.setText("Rp "+(int) gapok);
        } else if (BMenikah.isChecked()) {
            Status.setText("Belum Menikah");
            double gapok = gaji + 500000;

            Gaji.setText("Rp "+(int) gapok);

        }


    }
}
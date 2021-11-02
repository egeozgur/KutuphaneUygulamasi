package com.example.ders23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kitapEkle_Activity extends AppCompatActivity {

    private EditText kitapid, kitapadi,kitapkodu;
    private Button kitapKaydet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_ekle);

        kitapid = findViewById(R.id.txt_kitap_id);
        kitapadi = findViewById(R.id.txt_kitap_adi);
        kitapkodu = findViewById(R.id.txt_kitap_kodu);

        kitapKaydet = findViewById(R.id.kitap_btn);

        kitapKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kid = Integer.parseInt(kitapid.getText().toString());
                String kadi = kitapadi.getText().toString();
                String kkodu = kitapkodu.getText().toString();

                Kitap kitap = new Kitap();
                kitap.setId(kid);
                kitap.setKitapad(kadi);
                kitap.setKitapkodu(kkodu);

                MainActivity.veritabanim.myDao().kitapEkle(kitap);
                Toast.makeText(kitapEkle_Activity.this, "Kitap Kayıt Edildi...", Toast.LENGTH_SHORT).show();

                kitapid.setText("");
                kitapadi.setText("");
                kitapkodu.setText("");

                Intent intent = new Intent(kitapEkle_Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
package com.br.escola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtN1, edtN2;
    TextView txtM, txtSit;
    LinearLayout layResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtN1 = findViewById(R.id.edtN1);
        edtN2 = findViewById(R.id.edtN2);
        txtM = findViewById(R.id.txtM);
        txtSit = findViewById(R.id.txtSit);
        layResult = findViewById(R.id.LayResult);
    }

    public void calcular(View view) {
        boolean ok = true;
        if (edtN1.getText().toString().trim().isEmpty()){
            ok = false;
            edtN1.setError(getString(R.string.msgErro));
        }
        if (edtN2.getText().toString().trim().isEmpty()){
            ok = false;
            edtN2.setError(getString(R.string.msgErro));
        }
        if (ok) {

            //Fazendo a conta
            float n1 = Float.parseFloat(edtN1.getText().toString());
            float n2 = Float.parseFloat(edtN2.getText().toString());
            float m = (n1 + n2) / 2;
            // Resultado Média
            txtM.setText(String.format("%.1f", m));
            // Resultado Situação
            if (m < 5) {
                //reprovado
                txtSit.setText(getString(R.string.strStitRp));
                txtSit.setTextColor(getResources().getColor(R.color.corReprovado));
            } else if (m < 7) {
                //recuperação
                txtSit.setText(getString(R.string.strSitRc));
                txtSit.setTextColor(getResources().getColor(R.color.corRecuperacao));
            } else {
                //aprovado
                txtSit.setText(getString(R.string.strsSitAp));
                txtSit.setTextColor(getResources().getColor(R.color.corAprovado));
            }
        }
    }
}
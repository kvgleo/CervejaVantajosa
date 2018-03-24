package com.example.leonardo.calculadoracerveja;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println();
    }

    public void resposta(View v){

        EditText preco1 = (EditText) findViewById(R.id.etPreco1);
        EditText ml1 = (EditText) findViewById(R.id.etMl1);
        EditText preco2 = (EditText) findViewById(R.id.etPreco2);
        EditText ml12 = (EditText) findViewById(R.id.etMl2);
        AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);

        try {


        float x1 = Float.parseFloat(preco1.getText().toString().replace(",",".")); // converter edit text pra float e caso haver virgulas subistitui por ponto (padrão java numero decimal)
        float y1 = Float.parseFloat(ml1.getText().toString().replace(",","."));
        float x2 = Float.parseFloat(preco2.getText().toString().replace(",","."));
        float y2 = Float.parseFloat(ml12.getText().toString().replace(",","."));

        if (check(x1,x2,y1,y2) == x1){ //caso retorne o valor da cerveja 1, será a resposta
            janela.setTitle(getString(R.string.result)); //pegar a string que exibe o texto de acordo com o local
            janela.setMessage( getString(R.string.win1));
            janela.setNeutralButton("OK", null);
            janela.show();
        }
        if (check(x1,x2,y1,y2) == y1){
            janela.setTitle(getString(R.string.result));
            janela.setMessage( getString(R.string.win2));
            janela.setNeutralButton("OK", null);
            janela.show();
        }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),getString(R.string.error), Toast.LENGTH_LONG).show(); //caso der erro, um toast é exibido
        }

    }

    private float check(float x1, float x2, float y1, float y2){ //função que pega os valores realiza o calculo e retorna um dos preços das cervejas comparadas

        float conta1= x1/x2;
        float conta2= y1/y2;

        if (conta1>conta2)
            return y1;
        if (conta2> conta1)
            return x1;

        return 0;
    }
}

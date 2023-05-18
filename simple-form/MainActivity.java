package com.example.validacao_de_dados_func;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //criar as referências do xml para a activity main

    EditText nomeTxt;
    EditText sexoTxt;
    EditText enderecoTxt;
    EditText enderecoTxt3;
    EditText enderecoTxt4;
    EditText enderecoTxt2;
    EditText enderecoTxt5;
    EditText telefoneTxt;
    EditText datanascimentoTxt;
    EditText salarioTxt;
    EditText profissaoTxt;
    Button btnCadastra;
    boolean validou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomeTxt = findViewById(R.id.nomeTxt);
        sexoTxt = findViewById(R.id.sexoTxt);
        enderecoTxt = findViewById(R.id.enderecoTxt);
        enderecoTxt2 = findViewById(R.id.enderecoTxt2);
        enderecoTxt3 = findViewById(R.id.enderecoTxt3);
        enderecoTxt4 = findViewById(R.id.enderecoTxt4);
        enderecoTxt5 = findViewById(R.id.enderecoTxt5);
        telefoneTxt = findViewById(R.id.telefoneTxt);
        datanascimentoTxt = findViewById(R.id.datanascimentoTxt);
        salarioTxt = findViewById(R.id.salarioTxt);
        profissaoTxt = findViewById(R.id.profissaoTxt);
        btnCadastra = findViewById(R.id.btnCadastra);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Validação do cadastro

        btnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Método para validar os dados a ser armazenados

                validou = checandoDados();
                if (validou){
                    Toast.makeText(MainActivity.this,"Dados armazenados!",Toast.LENGTH_SHORT).show();
                } else {Toast.makeText(MainActivity.this,"Não deixe nenhum dado em branco!!",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Método para não deixar os campos em branco
    private boolean checandoDados() {
        if (TextUtils.isEmpty(nomeTxt.getText().toString())) {
            nomeTxt.setError("*Preencha este campo*");
            nomeTxt.requestFocus();
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Método de validar o sexo

        if (!TextUtils.equals(sexoTxt.getText().toString(), "M") && !TextUtils.equals(sexoTxt.getText().toString(), "F")) {
            sexoTxt.setError("Preencha apenas com 'M' ou 'F'");
            return false;
        } else {
            sexoTxt.setError(null);
        }

        if (TextUtils.isEmpty(sexoTxt.getText().toString())) {
            sexoTxt.setError("*Preencha o campo em branco*");
            sexoTxt.requestFocus();
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Método de validação do Endereço

        if (TextUtils.isEmpty(enderecoTxt.getText().toString())) {
            enderecoTxt.setError("*Preencha este campo*");
            enderecoTxt.requestFocus();
            return false;
        }
        //bairro
        if (TextUtils.isEmpty(enderecoTxt2.getText().toString())) {
            enderecoTxt2.setError("*Preencha este campo*");
            enderecoTxt2.requestFocus();
            return false;
        }
        //cep
        if (TextUtils.isEmpty(enderecoTxt4.getText().toString())) {
            enderecoTxt4.setError("*Preencha este campo*");
            enderecoTxt4.requestFocus();
            return false;
        }
        //cidade - uf
        if (TextUtils.isEmpty(enderecoTxt3.getText().toString())) {
            enderecoTxt3.setError("*Preencha este campo*");
            enderecoTxt3.requestFocus();
            return false;
        }
        //número
        if (TextUtils.isEmpty(enderecoTxt5.getText().toString())) {
            enderecoTxt5.setError("*Preencha este campo*");
            enderecoTxt5.requestFocus();
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Método de validação do Telefone
        if (telefoneTxt.getText().toString().length() != 11) {
            telefoneTxt.setError("Preencha com um telefone de 11 dígitos");
            return false;
        } else {
            telefoneTxt.setError(null);
        }

        if (TextUtils.isEmpty(telefoneTxt.getText().toString())) {
            telefoneTxt.setError("*Preencha este campo*");
            telefoneTxt.requestFocus();
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Método para validar a data de nascimento
        // Converter o texto do campo de entrada em uma data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date dataNascimento = null;
        try {
            dataNascimento = sdf.parse(datanascimentoTxt.getText().toString());
        } catch (ParseException e) { //O ANDROID STUDIO CONVERTEU ISSO SOZINHO!!
            e.printStackTrace();
        }

        // Verificar se a data foi convertida com sucesso
        if (dataNascimento == null) {
            datanascimentoTxt.setError("Data de nascimento inválida");
            return false;
        }

        // Obter a data atual com biblioteca Calendar
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        // Definir a data mínima como 01/01/1900
        Calendar minCal = Calendar.getInstance();
        minCal.set(1900, 0, 1);

        // Definir a data máxima como a data atual
        Calendar maxCal = Calendar.getInstance();
        maxCal.set(ano, mes, dia);

        // Verificar se a data está dentro do intervalo permitido
        if (dataNascimento.before(minCal.getTime()) || dataNascimento.after(maxCal.getTime())) {
            datanascimentoTxt.setError("A data deve estar entre 01/01/1900 e a data atual");
            return false;
        } else {
            datanascimentoTxt.setError(null);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // Método para validar o salário
        String salarioFunc = salarioTxt.getText().toString().trim();

        if (salarioFunc.isEmpty()) {salarioTxt.setError("Informe um valor para o salário");
            return false;
        }

        double salario = Double.parseDouble(salarioFunc);

        if (salario <= 0) {
            salarioTxt.setError("O salário deve ser maior que zero");
            return false;
        } else {
            salarioTxt.setError(null);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // Método para validar a profissão
        if (TextUtils.isEmpty(profissaoTxt.getText().toString())) {
            profissaoTxt.setError("*Preencha este campo*");
            profissaoTxt.requestFocus();
            return false;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        //se estiver tudo certo retorna o TRUE
        return true;
    }
}
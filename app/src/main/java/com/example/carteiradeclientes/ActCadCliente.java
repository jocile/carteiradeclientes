package com.example.carteiradeclientes;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.regex.Pattern;

public class ActCadCliente extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEndereco;
    private EditText edtEmail;
    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNome     = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtEmail    = (EditText)findViewById(R.id.edtEmail);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_cliente, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void validaCampos(){

        boolean res = false;

        String nome     = edtNome.getText().toString();
        String endereco = edtEndereco.getText().toString();
        String email    = edtEmail.getText().toString();
        String telefone = edtTelefone.getText().toString();

        if (res = isCampoVazio(nome)){
            edtNome.requestFocus();
        }else if (res = isCampoVazio(endereco)){
            edtEndereco.requestFocus();
        }else if (res = !isEmailValido(email)){
            edtEmail.requestFocus();
        }else if (res = isCampoVazio(telefone)){
            edtTelefone.requestFocus();
        }

        if (res){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.message_capos_invalidos_brancos);
            dlg.setNeutralButton(R.string.lbl_ok, null);
            dlg.show();
        }

    }

    private boolean isCampoVazio(String valor){

        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
        return resultado;
    }

    private boolean isEmailValido(String email){

        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return resultado;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.action_ok:

                validaCampos();
                //Toast.makeText(this, "Botão OK Selecionado", Toast.LENGTH_SHORT).show();

                break;

            case R.id.action_cancelar:

                //Toast.makeText(this, "Botão Cancelar Selecionado", Toast.LENGTH_SHORT).show();
                finish();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
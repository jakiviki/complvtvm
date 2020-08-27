package com.example.complvtvm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogLogin extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //creamos el inflador
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // creamos el edificio , jejeje
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // creamos la vista con el inflador
        View viewDialog = inflater.inflate(R.layout.dialog_login,null);

        // accedemos a las vistas del layout
        final EditText texto = viewDialog.findViewById(R.id.edtx_login);
        Button ok = viewDialog.findViewById(R.id.btn_ok_login);
        Button cancelar = viewDialog.findViewById(R.id.btn_cancelar_login);

        // decidimos las funciones para la vista
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        /////////////////importante esta es la contraseña de el admin////////////////
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (texto.getText().toString().equals("adminCarmelo")){
                    Intent intent = new Intent(getContext(),HomeCarmeloActivity.class);
                    startActivity(intent);
                    dismiss();
                }else {
                    Toast.makeText(getContext(),"Acceso denegado",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // usamos el constructor  para construir el edificio
        builder.setView(viewDialog).setMessage("Introduce la contraseña");






        return builder.create();
    }
}

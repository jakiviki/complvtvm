package com.example.complvtvm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogCarmelo extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // ahora llamariamos a .setMesange .setTitle del Alert.builder
        // pero en vez de eso vamos a inflar mi layout y asi podemos usarlo como objetos java

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        // 2 creamos un inflador de xml
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // creamos la vista
        View dialogView = inflater.inflate(R.layout.dialog_carmelo,null);

        // accedemos a los objetos de la vista
        final EditText editText = dialogView.findViewById(R.id.edtx_dialog_carmelo);
        Button btnCancelar = (Button) dialogView.findViewById(R.id.btn_cancelar_login);
        Button btnOk = (Button) dialogView.findViewById(R.id.button_dialog_añadir);

        builder.setView(dialogView)
                .setMessage("Añade un horario");


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(!editText.getText().toString().isEmpty()){
                        HomeCarmeloActivity nuevoActivity = (HomeCarmeloActivity) getActivity();
                        nuevoActivity.nuevoHorario(editText.getText().toString());
                        dismiss();
                    }else {
                        Toast.makeText(getContext(),"Introduce un horario",Toast.LENGTH_LONG).show();
                    }


                //////////////mensajes ////////////////
            }
        });


        return builder.create();
    }
}



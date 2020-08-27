package com.example.complvtvm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogAforo extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // ahora llamariamos a .setMesange .setTitle del Alert.builder
        // pero en vez de eso vamos a inflar mi layout y asi podemos usarlo como objetos java

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2 creamos un inflador de xml
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // creamos la vista
        View dialogView = inflater.inflate(R.layout.dialog_aforo,null);
        // accedemos a los objetos de la vista
        final EditText editText = dialogView.findViewById(R.id.edt_dialog_aforo);
        final String aforo = editText.getText().toString();
        Button btnCancelar = (Button) dialogView.findViewById(R.id.btn_dialog_aforo_cancel);
        Button btnOk = (Button) dialogView.findViewById(R.id.btn_dialog_aforo_ok);

        builder.setView(dialogView)
                .setMessage("Añade el aforo");


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //HomeCarmeloActivity nuevoHorario = new HomeCarmeloActivity();
                HomeCarmeloActivity nuevoActivity = (HomeCarmeloActivity) getActivity();
                nuevoActivity.nuevoAforo(editText.getText().toString());

                Log.i("complu","valor del nuevo aforCarmelo es de: "+nuevoActivity);
                dismiss();
            }
        });

        return builder.create();
    }
}

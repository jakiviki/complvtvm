package com.example.complvtvm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.fragment.app.DialogFragment;

public class DialogEliminar extends DialogFragment {




    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        // construimos el builder y usamos sus metodos para los mensaje
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.Eliminar);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                /// aqui tengo que hacer que elimine el horario
                // creamos el objeto de la clase de carmelo que es la que contiene la lista a borrar
                HomeCarmeloActivity nuevoActivity = (HomeCarmeloActivity) getActivity();

                nuevoActivity.eliminarShared();
                nuevoActivity.eliminarHorario();

                Log.i("complu"," dialog el valor de i en el dialog es "+i);
                dismiss();


            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("eliminar","valor de i en el dialog "+i);
                dismiss();
            }
        });

        return builder.create();
    }
}

package com.example.proyectofinal.interfaces;

import android.util.Log;
import android.view.View;

import java.io.Serializable;

public interface Comunicacion extends Serializable {

    void setotro(int otro, View view);
    void setotroEd(int otro, View view);
    void setotroEl(int otro, View view);

}

package com.decroly.vetapp;

import model.Propietario;
import model.SQLAcessVetDaw;
import model.SQLDatabaseManager;

import java.util.List;

public class mainTest {
    public static void main(String[] args) {

        SQLAcessVetDaw VideoDawData = new SQLAcessVetDaw();

        List<Propietario> names = VideoDawData.getPropietarios();

        for (Propietario prop : names) {
            System.out.println(prop);
        }


        //Creamos el producto
        Propietario po = new Propietario("Juan","Pérezzz","15345678A","600123456","Calle Falsa 1234","juan1@mail.com");
        int response = VideoDawData.insertPropietario(po);
        System.out.println("Se han insertado " + response + " elementos");



    }

}

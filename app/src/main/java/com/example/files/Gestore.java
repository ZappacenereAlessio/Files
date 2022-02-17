package com.example.files;

import android.content.Context;
import android.util.Log;

import androidx.arch.core.internal.SafeIterableMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gestore {
    public String leggiFile(String nomeFile, Context c) {

        StringBuilder sb = new StringBuilder();
        String testoDaRestituire;

        try {

            BufferedReader fileDaLeggere = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            while ((testoDaRestituire = fileDaLeggere.readLine()) != null) {
                sb.append(testoDaRestituire + "\n");

            }
        } catch (FileNotFoundException e) {
            Log.e("Gestore", "Errore file inesistente");
        } catch (IOException e) {
            Log.e("Gestore", "Impossibile leggere il file");
        }
        return sb.toString();

    }

    public String scriviFile(String nomeFile, Context c) {

        String esito;
        FileOutputStream file;

        String testoDaScrivere = "Questo è il testo che voglio scrivere";

        try {

            file = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            file.write(testoDaScrivere.getBytes());
            file.close();

            esito = "File scritto correttamente";

        } catch (FileNotFoundException e) {
            esito = "File non trovato!!";
        } catch (IOException e) {
            esito = "Impossibile scrivere il file!!";
        }
        return esito;
    }

}

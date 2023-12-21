package org.example;

import org.example.model.domain.Envio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvioLoader {

    public List<Envio> loadEnviosFromFile(String filePath) {
        List<Envio> envios=new ArrayList<>();

        try (BufferedReader reader=new BufferedReader(new FileReader("files/envio.txt"))) {
            String line=reader.readLine();

            while (line != null) {
                String[] fields=line.split(";");
                Envio envio=createEnvioFromFields(fields);
                envios.add(envio);
                line=reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return envios;
    }

    private Envio createEnvioFromFields(String[] fields) {
        try {
            if (fields.length < 4) {
                throw new IllegalArgumentException("Número insuficiente de campos para criar um Envio.");
            }

            Envio.TipoEnvio tipoEnvio=parseTipoEnvio(fields[3]);
            return new Envio(parseDate(fields[0]), fields[1], fields[2], tipoEnvio);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Envio.TipoEnvio parseTipoEnvio(String tipoEnvioString) {
        try {
            return Envio.TipoEnvio.valueOf(tipoEnvioString);
        } catch (IllegalArgumentException e) {
            System.err.println("TipoEnvio inválido: " + tipoEnvioString);
            return Envio.TipoEnvio.CONTAS_A_PAGAR;
        }

    }
}

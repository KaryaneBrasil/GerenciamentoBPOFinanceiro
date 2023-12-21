package org.example.loader;

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
    public static List<Envio> loadEnviosFromFile(String filePath) {
        List<Envio> envios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Envio envio = new Envio();

                envio.setData(parseDate(dados[0]));
                envio.setResponsavel(dados[1]);
                envio.setObservacao(dados[2]);
                envio.setTipoEnvio(Envio.TipoEnvio.valueOf(dados[3]));

                envios.add(envio);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return envios;
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }
}

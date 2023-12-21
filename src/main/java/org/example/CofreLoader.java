package org.example.loader;

import org.example.model.domain.Cofre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CofreLoader {
    public static List<Cofre> loadCofresFromFile(String filePath) {
        List<Cofre> cofres = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Cofre cofre = new Cofre();


                cofre.setDataFechamento(parseDate(dados[0]));
                cofre.setResponsavelFechamento(dados[1]);
                cofre.setRelatorioFechamento(dados[2]);
                cofre.setObservacoes(dados[3]);

                cofres.add(cofre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return cofres;
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }
}

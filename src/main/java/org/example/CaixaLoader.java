package org.example;

import org.example.model.domain.Caixa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaixaLoader {

    public List<Caixa> loadCaixasFromFile(String filePath) {
        List<Caixa> caixas=new ArrayList<>();

        try (BufferedReader reader=new BufferedReader(new FileReader("files/caixa.txt"))) {
            String line=reader.readLine();

            while (line != null) {
                String[] fields=line.split(";");
                Caixa caixa=createCaixaFromFields(fields);
                caixas.add(caixa);
                line=reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return caixas;
    }

    private Caixa createCaixaFromFields(String[] fields) {
        return new Caixa(parseDate(fields[0]), fields[1], fields[2], fields[3]);
    }

    private Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

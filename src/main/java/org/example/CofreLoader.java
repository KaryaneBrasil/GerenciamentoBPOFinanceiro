package org.example;

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

    public List<Cofre> loadCofresFromFile(String filePath) {
        List<Cofre> cofres=new ArrayList<>();

        try (BufferedReader reader=new BufferedReader(new FileReader("files/cofre.txt"))) {
            String line=reader.readLine();

            while (line != null) {
                String[] fields=line.split(";");
                Cofre cofre=createCofreFromFields(fields);
                cofres.add(cofre);
                line=reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cofres;
    }

    private Cofre createCofreFromFields(String[] fields) {
        try {
            if (fields.length < 4) {
                throw new IllegalArgumentException("Número insuficiente de campos para criar um Cofre.");
            }

            return new Cofre(parseDate(fields[0]), fields[1], fields[2], fields[3]);
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
}

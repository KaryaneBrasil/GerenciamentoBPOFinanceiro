package org.example;

import org.example.model.domain.Documento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentoLoader {

    public List<Documento> loadDocumentosFromFile(String filePath) {
        List<Documento> documentos=new ArrayList<>();

        try (BufferedReader reader=new BufferedReader(new FileReader("files/documento.txt"))) {
            String line=reader.readLine();

            while (line != null) {
                String[] fields=line.split(";");
                Documento documento=createDocumentoFromFields(fields);
                documentos.add(documento);
                line=reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return documentos;
    }

    private Documento createDocumentoFromFields(String[] fields) {
        try {
            if (fields.length < 4) {
                throw new IllegalArgumentException("Número insuficiente de campos para criar um Documento.");
            }

            return new Documento(fields[0], fields[1], parseDate(fields[2]), fields[3]);
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

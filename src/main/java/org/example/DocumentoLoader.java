package org.example.loader;

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
    public static List<Documento> loadDocumentosFromFile(String filePath) {
        List<Documento> documentos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Documento documento = new Documento();


                documento.setTipoDocumento(dados[0]);
                documento.setArquivo(dados[1]);
                documento.setDataEnvio(parseDate(dados[2]));
                documento.setObservacoes(dados[3]);


                documentos.add(documento);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return documentos;
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Ajuste conforme o formato da sua data
        return dateFormat.parse(dateString);
    }
}

package org.example.loader;

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
    public static List<Caixa> loadCaixasFromFile(String filePath) {
        List<Caixa> caixas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Caixa caixa = new Caixa();


                caixa.setDataFechamento(parseDate(dados[0]));
                caixa.setResponsavelFechamento(dados[1]);
                caixa.setRelatorioFechamento(dados[2]);
                caixa.setObservacoes(dados[3]);

                caixas.add(caixa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return caixas;
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }
}

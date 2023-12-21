package org.example;

import org.example.model.domain.Empresa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaLoader {

    public List<Empresa> loadEmpresasFromFile(String filePath) {
        List<Empresa> empresas=new ArrayList<>();

        try (BufferedReader reader=new BufferedReader(new FileReader("files/empresa.txt"))) {
            String line=reader.readLine();

            while (line != null) {
                String[] fields=line.split(";");
                Empresa empresa=createEmpresaFromFields(fields);
                empresas.add(empresa);
                line=reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return empresas;
    }

    private Empresa createEmpresaFromFields(String[] fields) {
        try {
            if (fields.length < 6) {
                throw new IllegalArgumentException("Número insuficiente de campos para criar uma Empresa.");
            }

            return new Empresa(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

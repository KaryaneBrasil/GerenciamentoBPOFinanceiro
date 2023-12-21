package org.example.loader;

import org.example.model.domain.Empresa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaLoader {
    public List<Empresa> loadEmpresasFromFile(String filePath) {
        List<Empresa> empresas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Empresa empresa = new Empresa();

                empresa.setRazaoSocial(dados[0]);
                empresa.setNomeFantasia(dados[1]);
                empresa.setSigla(dados[2]);
                empresa.setCnpj(dados[3]);
                empresa.setEndereco(dados[4]);
                empresa.setEmail(dados[5]);

                empresas.add(empresa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empresas;
    }
}

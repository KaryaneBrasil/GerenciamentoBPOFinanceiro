package org.example.loader;

import org.example.model.domain.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteLoader {
    public static List<Cliente> loadEmpresasFromFile(String filePath) {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Cliente cliente = new Cliente();

                cliente.setNome(dados[0]);
                cliente.setCpf(dados[1]);
                cliente.setEndereco(dados[2]);
                cliente.setEmail(dados[3]);

                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}

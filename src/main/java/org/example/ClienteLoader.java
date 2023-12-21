package org.example;

import org.example.model.domain.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteLoader {

    public List<Cliente> loadClientesFromFile(String filePath) {
        List<Cliente> clientes=new ArrayList<>();

        try (BufferedReader reader=new BufferedReader(new FileReader("files/cliente.txt"))) {
            String line=reader.readLine();

            while (line != null) {
                String[] fields=line.split(";");
                Cliente cliente=createClienteFromFields(fields);
                clientes.add(cliente);
                line=reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    private Cliente createClienteFromFields(String[] fields) {
        try {
            return new Cliente(fields[0], fields[1], fields[2], fields[3]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
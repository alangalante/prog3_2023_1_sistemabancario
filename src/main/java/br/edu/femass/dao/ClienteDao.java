package br.edu.femass.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.femass.model.Cliente;

public class ClienteDao {
    private File arquivo = new File("clientes.json");
    private ObjectMapper objectMapper = new ObjectMapper();

    public void gravar(Cliente cliente) throws StreamWriteException, IOException {
       List<Cliente> clientes = buscar();
       clientes.add(cliente);

       objectMapper.writerWithDefaultPrettyPrinter().writeValue(arquivo, clientes);
    }

    public void excluir(Cliente cliente) throws StreamWriteException, IOException {
        List<Cliente> clientes = buscar();
        clientes.remove(cliente);
 
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(arquivo, clientes);       
    }

    public List<Cliente> buscar() throws DatabindException {
        try {
            return objectMapper.readValue(arquivo, new TypeReference<List<Cliente>>(){});
        } catch (IOException ex) {
            return new ArrayList<Cliente>();
        }
    }
}

package com.example.cursospring.services;

import com.example.cursospring.domain.Category;
import com.example.cursospring.domain.Client;
import com.example.cursospring.repository.ClientRepository;
import com.example.cursospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    public Client findClientById(Integer id){

        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException("Object not found for id: " + id
                + ".Type: " + Category.class.getName()));
    }

    public List<Client> findAll(){

        List<Client> clients = clientRepository.findAll();
        return clients;
    }

}

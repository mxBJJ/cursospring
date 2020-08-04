package com.example.cursospring.services;

import com.example.cursospring.domain.Client;
import com.example.cursospring.domain.Client;
import com.example.cursospring.dto.ClientDTO;
import com.example.cursospring.repository.ClientRepository;
import com.example.cursospring.services.exception.DataIntegrityViolationException;
import com.example.cursospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ClientRepository clientRepository;

    public Client findClientsById(Integer id){

        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException("Object not found for id: " + id
                + ".Type: " + Client.class.getName()));
    }

    public List<Client> findAll(){

        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public Client update(Client obj){
        Client newObject = findClientsById(obj.getId());
        updateData(newObject,obj);

        return clientRepository.save(obj);
    }

    public Client insert(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    public void delete(Integer id){
       findClientsById(id);

        try{
            clientRepository.deleteById(id);
        }catch(DataIntegrityViolationException exception){
            throw new DataIntegrityViolationException("Can't delete client.");
        }
    }

    public Page<Client> findPage(
            Integer page, Integer linesPerPage,
            String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return clientRepository.findAll(pageRequest);

    }

    public Client fromDto(ClientDTO clientDTO){
        return new Client(clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getEmail(),
                null, null, passwordEncoder.encode(clientDTO.getPassword()));
    }

    private void updateData(Client newObj, Client obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}

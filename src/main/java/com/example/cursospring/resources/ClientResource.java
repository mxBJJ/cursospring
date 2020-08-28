package com.example.cursospring.resources;

import com.example.cursospring.domain.Client;
import com.example.cursospring.domain.Client;
import com.example.cursospring.domain.Client;
import com.example.cursospring.dto.ClientDTO;
import com.example.cursospring.dto.ClientDTO;
import com.example.cursospring.dto.ClientNewDTO;
import com.example.cursospring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClientResource {

    @Autowired
    public ClientService clientService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClientById(@PathVariable Integer id){

        Client client = clientService.findClientsById(id);
        return ResponseEntity.ok().body(client);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAllClients(){

        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok().body(clients);
    }

    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    public ResponseEntity<Page<ClientDTO>> getClients(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ){

        Page<Client> categories = clientService.findPage(page,linesPerPage,orderBy,direction);
        Page<ClientDTO> clientDTOS = categories.map(obj -> new ClientDTO(obj));
        return ResponseEntity.ok().body(clientDTOS);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClientNewDTO clientDTO){
        Client client = clientService.fromDto(clientDTO);
        client = clientService.insert(client);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateClient(@PathVariable Integer id
            , @RequestBody ClientNewDTO clientNewDTO){
        Client client = clientService.fromDto(clientNewDTO);
        client.setId(id);
        clientService.update(client);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

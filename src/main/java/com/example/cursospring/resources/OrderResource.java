package com.example.cursospring.resources;

import com.example.cursospring.domain.Order;
import com.example.cursospring.services.OrderService;
import com.example.cursospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/pedidos")
public class OrderResource {

    @Autowired
    public OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Order order = orderService.findById(id);

        if(order == null){
            throw new ObjectNotFoundException("No results found for id: " + id);
        }

        return ResponseEntity.ok().body(order);
    }
}

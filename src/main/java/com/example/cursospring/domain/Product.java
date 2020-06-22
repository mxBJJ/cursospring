package com.example.cursospring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   private Double price;
   private String name;

   @JsonBackReference
   @ManyToMany
   @JoinTable(name = "produto_categoria",
           joinColumns = @JoinColumn(name = "produto_id"),
           inverseJoinColumns = @JoinColumn(name = "categoria_id")
   )
   private List<Category> categories = new ArrayList<>();

   @OneToMany(mappedBy = "orderItemPK.product")
    private Set<OrderItem> orderItems = new HashSet<>();

    public Product() {
    }

    public Product(Integer id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public List<Order> getOrders(){
        List<Order> orderList = new ArrayList<>();

        for (OrderItem x : orderItems){
            orderList.add(x.getOrder());
        }
        return orderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

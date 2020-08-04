package com.example.cursospring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class  Order implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @JsonFormat(pattern="dd/MM/yyyy HH:mm")
        private Date time;

        @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
        private Payment payment;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private Client client;

        @ManyToOne
        @JoinColumn(name = "adress_delivery_id")
        private Adress deliveryAdress;


        @OneToMany(mappedBy = "orderItemPK.order")
        private Set<OrderItem> orderItems = new HashSet<>();

        public Order() {
        }

        public Order(Integer id, Date time, Payment payment, Client client, Adress deliveryAdress) {
                this.id = id;
                this.time = time;
                this.payment = payment;
                this.client = client;
                this.deliveryAdress = deliveryAdress;
        }


        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Date getTime() {
                return time;
        }

        public void setTime(Date time) {
                this.time = time;
        }

        public Payment getPayment() {
                return payment;
        }

        public void setPayment(Payment payment) {
                this.payment = payment;
        }

        public Client getClient() {
                return client;
        }

        public void setClient(Client client) {
                this.client = client;
        }

        public Adress getDeliveryAdress() {
                return deliveryAdress;
        }

        public void setDeliveryAdress(Adress deliveryAdress) {
                this.deliveryAdress = deliveryAdress;
        }

        public Set<OrderItem> getOrderItems() {
                return orderItems;
        }

        public void setOrderItems(Set<OrderItem> orderItems) {
                this.orderItems = orderItems;
        }
}


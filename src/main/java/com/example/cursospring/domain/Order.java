package com.example.cursospring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Order implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Date time;

        @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
        private Payment payment;

        private Client client;

        private Adress deliveryAdress;


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
}


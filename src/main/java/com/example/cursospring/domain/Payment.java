package com.example.cursospring.domain;

import com.example.cursospring.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

        @Id
        private Integer id;

        private PaymentStatus paymentStatus;

        @JsonBackReference
        @OneToOne
        @JoinColumn(name = "order_id")
        @MapsId
        private Order order;


        public Payment() {
        }

        public Payment(Integer id, PaymentStatus paymentStatus, Order order) {
                this.id = id;
                this.paymentStatus = paymentStatus;
                this.order = order;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public PaymentStatus getPaymentStatus() {
                return paymentStatus;
        }

        public void setPaymentStatus(PaymentStatus paymentStatus) {
                this.paymentStatus = paymentStatus;
        }

        public Order getOrder() {
                return order;
        }

        public void setOrder(Order order) {
                this.order = order;
        }
}

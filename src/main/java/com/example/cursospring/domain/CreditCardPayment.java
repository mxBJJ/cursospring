package com.example.cursospring.domain;

import com.example.cursospring.domain.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment{

    private Integer numberOfPayments;

    public CreditCardPayment() {
    }

    public CreditCardPayment(Integer id, PaymentStatus paymentStatus, Order order, Integer numberOfPayments) {
        super(id, paymentStatus, order);
        this.numberOfPayments = numberOfPayments;
    }

    public Integer getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(Integer numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }
}

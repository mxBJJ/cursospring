package com.example.cursospring.domain;

import com.example.cursospring.domain.enums.PaymentStatus;

import java.util.Date;

public class BankSlipPayment extends Payment{

    private Date dueDate;
    private Date payday;


    public BankSlipPayment() {
    }

    public BankSlipPayment(Integer id, PaymentStatus paymentStatus, Order order, Date dueDate, Date payday) {
        super(id, paymentStatus, order);
        this.dueDate = dueDate;
        this.payday = payday;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPayday() {
        return payday;
    }

    public void setPayday(Date payday) {
        this.payday = payday;
    }
}

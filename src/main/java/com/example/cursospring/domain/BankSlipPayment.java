package com.example.cursospring.domain;

import com.example.cursospring.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class BankSlipPayment extends Payment{

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dueDate;

    @JsonFormat(pattern="dd/MM/yyyy")
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

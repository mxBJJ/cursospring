package com.example.cursospring.domain.enums;

public enum PaymentStatus {

    PENDENTE(1, "PENDENTE"),
    QUITADO(2,"QUITADO"),
    CANCELADO(3, "CANCELADO");

    private Integer cod;
    private String description;


    PaymentStatus(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public PaymentStatus toEnum(){
        if(cod == null){
            return null;
        }

        for(PaymentStatus x : PaymentStatus.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + cod);
    }
}

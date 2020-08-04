package com.example.cursospring.dto;

import com.example.cursospring.domain.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClientDTO implements Serializable {

    private Integer id;

    @NotEmpty
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres.")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório.")
    @Email
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório.")
    private String password;

    public ClientDTO(Client client){
        id = client.getId();
        name = client.getName();
        email = client.getEmail();
        password = client.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

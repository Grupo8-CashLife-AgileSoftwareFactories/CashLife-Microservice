package com.cashlife.financial_information_microservice.finantialEducation.interfaces.rest.resources;

public class PreguntaResource {

    private Long id;
    private String texto;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
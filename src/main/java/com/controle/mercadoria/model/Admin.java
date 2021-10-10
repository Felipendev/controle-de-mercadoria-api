//package com.controle.mercadoria.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;
//
//@Entity
//@Data
//public class Admin {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotEmpty
//    @Column(unique = true)
//    private String userName;
//    @NotEmpty
//    @JsonIgnore
//    private String password;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//}

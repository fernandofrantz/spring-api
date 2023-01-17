package com.springboot.api.models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "users" )
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @Column( name="name", nullable=false )
    private String name;

    @Column( name="cpf", nullable=false )
    private String cpf;

    @Column( name="created_at", nullable=false )
    private Date created_at;
    
    @Column( name="updated_at", nullable=true )
    private Date updated_at;
}

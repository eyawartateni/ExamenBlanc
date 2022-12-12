package com.example.wartatenieya.entities;

import javafx.geometry.Pos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;
    private String login;
    private  String password;
    @Enumerated(EnumType.STRING)
    private Poste poste;
    @OneToOne(mappedBy = "responsable")
    private Zone zone;


}

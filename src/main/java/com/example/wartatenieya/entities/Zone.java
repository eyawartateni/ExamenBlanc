package com.example.wartatenieya.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String ref;
    private float dimension;
    @ManyToOne
    private Parking parking;
    @OneToMany
    private Set<Personnel> gardes;
    @OneToOne
    private Personnel responsable;
}

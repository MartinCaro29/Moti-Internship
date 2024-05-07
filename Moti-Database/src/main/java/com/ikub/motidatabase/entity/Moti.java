package com.ikub.motidatabase.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name= "moti")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Moti {

    @Id
    @Column(name="matje_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matje_id;
    @Column(name="qyteti")
    private String qyteti;
    @Column(name="dita")
    private String dita;
    @Column(name="temperatura")
    private int temperatura;
    @Column(name="lageshtia")
    private int lageshtia;







}


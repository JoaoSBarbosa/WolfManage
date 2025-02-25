package com.joaobarbosadev.WolfManage.core.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(unique = true)
    private String email;
    @Column(name = "telefone")
    private String phone;
    @Column(name = "endereco")
    private String address;
    @Column(name = "cidade")
    private String city;
    @Column(name = "uf")
    private String state;
    @Column(name = "cep")
    private String zip;
    @Column(name = "pais")
    private String country;
    @Column(name = "bairro")
    private String neighbourhood;
}

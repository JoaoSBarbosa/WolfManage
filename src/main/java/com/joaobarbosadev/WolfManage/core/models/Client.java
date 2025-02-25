package com.joaobarbosadev.WolfManage.core.models;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.joaobarbosadev.WolfManage.core.abstractions.Auditable;
import com.joaobarbosadev.WolfManage.core.enums.Country;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Client extends Auditable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100, nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(name = "telefone", length = 11, nullable = false, unique = true)
    private String phone;
    @Column(name = "endereco")
    private String address;
    @Column(name = "cidade")
    private String city;
    @Column(name = "uf", length = 2)
    private String state;
    @Column(name = "cep")
    private String zip;
    @Column(name = "pais")
    @Enumerated(EnumType.STRING)
    private Country country = Country.BRAZIL;
    @Column(name = "bairro")
    private String neighbourhood;
}

package br.eti.scheffer.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parameters")
public class Parameters implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "parameters_seq")
    @SequenceGenerator(name = "parameters_seq", sequenceName = "parameters_seq", allocationSize = 1)
    private Long id;

    @Column(name = "smtp", nullable=false, length=255)
    private String smtp;

    @Column(name = "port", nullable=false)
    private Integer port;

    @Column(name = "address_from", nullable=false, length=255)
    private String addressFrom;

    @Column(name = "username", nullable=false, length=255)
    private String username;

    @Column(name = "password", nullable=false, length=255)
    private String password;

    @JsonIgnore
    @Embedded
    private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();



}

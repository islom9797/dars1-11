
package org.islom.dars111.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp date;

    @ManyToOne
    private WareHouse warehouse;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Currency currency;

    private  String factureNumber;

    @Column(unique=true,nullable=false)
    private String code;

}

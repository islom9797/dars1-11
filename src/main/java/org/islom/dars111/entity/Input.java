
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
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp date;

    @ManyToOne
    private WareHouse warehouse;

    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Currency currency;

    private  String factureNumber;

    @Column(unique=true,nullable=false)
    private String code;

}

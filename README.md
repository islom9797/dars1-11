
<body>
<h2>Bu Yerda agar biror Entity ABstract class bo'lib undan qolgan classlar vorislik olsa Bu superclasslarni @MappedSuperClass deb elon qilishmiz zarur </h2>

<code>
package org.islom.dars111.entity.template;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass

public class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean active=true;
}
</code>
 

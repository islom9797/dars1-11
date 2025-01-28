
<body>
<p>Bu Yerda agar biror Entity ABstract class bo'lib undan qolgan classlar vorislik olsa Bu superclasslarni<b> @MappedSuperClass</b> deb elon qilishmiz zarur </p>

<pre>
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
</pre>
 <em>Va shu abstrat classni ishlatish uchun BIz  <b>@EqualsAndHashCode(callSuper=true)</b> ni ishlatishimiz kerak shunda u superclassni chaqirib ishlatadi </em>
<pre>
    <code>
        package org.islom.dars111.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.islom.dars111.entity.template.AbsEntity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Category extends AbsEntity {
  @ManyToOne
    private Category parentCategory;
}
    </code>
</pre>

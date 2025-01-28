



<body>
   <p>Bu orqali agar ikki fieldlar birgalikda unique bo'lsa ishlatilinadi</p>
<pre> <code>@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"corpName","address_street","address_homeNumber"}))</code>code></pre><br>

    <p><b>@Entity(name = "users") </b>Bu orqali Biz Entityni ismini conflict berishi mumkin bo'lsa yoki o'zgartirishni xohlasak ishlatamiz</p>
<p>Bu Yerda agar biror Entity ABstract class bo'lib undan qolgan classlar vorislik olsa Bu superclasslarni<b> @MappedSuperClass</b> deb elon qilishmiz zarur </p><br>

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
 <p>Va shu abstrat classni ishlatish uchun BIz  <b>@EqualsAndHashCode(callSuper=true)</b> ni ishlatishimiz kerak shunda u superclassni chaqirib ishlatadi </p><br>
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

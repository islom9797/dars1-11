package org.islom.dars111.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.islom.dars111.entity.template.AbsEntity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Product extends AbsEntity {
    @ManyToOne(optional=false)
    private Category category;

    @OneToOne
    private  Attachment attachment;

    private  String code;
    @ManyToOne(optional=false)
    private  Measurement measurement;

}

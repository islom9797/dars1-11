package org.islom.dars111.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.islom.dars111.entity.template.AbsEntity;
@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class WareHouse extends AbsEntity {
}

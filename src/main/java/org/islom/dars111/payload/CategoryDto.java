package org.islom.dars111.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CategoryDto {
    private String name;
    private Integer parentCategoryId;
}

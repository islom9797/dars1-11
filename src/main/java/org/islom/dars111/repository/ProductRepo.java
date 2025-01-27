package org.islom.dars111.repository;

import org.islom.dars111.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    boolean exitsByNameAndCategoryId(String name, int categoryId);
}

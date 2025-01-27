package org.islom.dars111.repository;

import org.islom.dars111.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    boolean existsByName(String name);
}
package org.islom.dars111.service;

import org.islom.dars111.entity.Attachment;
import org.islom.dars111.entity.Category;
import org.islom.dars111.entity.Measurement;
import org.islom.dars111.entity.Product;
import org.islom.dars111.payload.ProductDto;
import org.islom.dars111.payload.Result;
import org.islom.dars111.repository.AttachmentRepo;
import org.islom.dars111.repository.CategoryRepo;
import org.islom.dars111.repository.MeasurementRepository;
import org.islom.dars111.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo;

    CategoryRepo categoryRepo;
    AttachmentRepo attachmentRepo;
    MeasurementRepository measurementRepo;

    public Result addroduct(ProductDto productDto) {

        boolean exitsByNameAndCategoryId = productRepo.exitsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());

        if (exitsByNameAndCategoryId) {
            return new Result("Bunday Mahsuulot Bunday Kategoriyada Mavjud", false);
        }

        Optional<Category> categoryRepoById = categoryRepo.findById(productDto.getCategoryId());
        if (!categoryRepoById.isPresent()) {
            return new Result("Bunday Kategoriya Mavjud Emas", false);
        }

        Optional<Attachment> getPhotoId = attachmentRepo.findById(productDto.getPhotoId());
        if (!getPhotoId.isPresent()) {
            return new Result("Bunday rasm Mavjud Emas", false);
        }
        Optional<Measurement> measurementRepoById = measurementRepo.findById(productDto.getMeasurementId());

        if (!measurementRepoById.isPresent()) {
            return new Result("Bunday Measurement Mavjud Emas", false);
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(categoryRepoById.get());
        product.setMeasurement(measurementRepoById.get());
        product.setAttachment(getPhotoId.get());
        productRepo.save(product);
        return new Result("saqlandi", true);


    }
}

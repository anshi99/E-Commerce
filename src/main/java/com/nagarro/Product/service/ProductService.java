package com.nagarro.Product.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.Product.dao.FileDataRepository;
import com.nagarro.Product.model.FileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nagarro.Product.dao.Productdao;
import com.nagarro.Product.model.Products;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private Productdao repo;

    @Autowired
    private FileDataRepository fileDataRepository;

    @Autowired
    ObjectMapper objMapper;


    private final String FOLDER_PATH="C:/Users/anshikaagarwal/Downloads/ngregistration (2)/ngregistration/src/assets/images/";

    public List<Products> fetchProductList() { return repo.findAll();}


    public Products saveProductsToDB(Products products) {return repo.save(products);}


    public Optional<Products> fetchProductById(int id) {return repo.findById(id);}


    public  List<Products> fetchProducts(int id, String name,String brand ) {
        List<Products> result1=null;
        List<Products> result2=null;
        List<Products> result3=null;
        result1= repo.findByBrand(brand);
        result2= repo.findByName(name);
        result3=result2;
        result3.addAll(result1);
        return  result3;
    }

    public List<Products> fetchProductByBrand(String brand) {

        return repo.findByBrand(brand);
    }

    public List<Products> fetchByIdOrNameOrBrand(int id,String name,String brand){
        return repo.findByIdOrNameOrBrand(id, name, brand);
    }

    public List<Products> fetchByIdAndNameAndBrand(int id,String name,String brand){
        return repo.findByIdAndNameAndBrand(id, name, brand);
    }

    public List<Products> fetchProductByName(String name) {

        return repo.findByName(name);
    }




    public String uploadImageToFileSystem(MultipartFile file,String brand, int price,String productName,String productCode, String description) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        System.out.println("Anshikakkk");

       Products products=fileDataRepository.save(Products.builder()
               .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .brand(brand)
                .productCode(productCode)
                .description(description)
                .price(price)
                .productName(productName)
                .build());

        System.out.println("Agarwal");
        file.transferTo(new File(filePath));

        if (products != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }


//    public String uploadImage(MultipartFile file){
//        repo.save(Products.builder()
//                .name(name: file.getOriginalFilename())
//                .type(type: file.getContentType())
//                .imagedata(imagedata:file.getBytes()).build)
//    }



    public String searchProductsById(int id) throws JsonProcessingException {

        Optional<Products> products = repo.findById(id);
        Products product = products.get();
        System.out.println(products);

        String actualProduct = objMapper.writeValueAsString(product);
        System.out.println(actualProduct);
        return actualProduct;
    }

    public String pricefilter(int id, String productName ,
                              String brandName , String productCode ,
                              String min , String max ) throws JsonProcessingException {

        List<Products>products = repo.findPriceByIdAndBrandAndName(id,productName,
                brandName,productCode ,
                Integer.parseInt(min),Integer.parseInt(max));

            return objMapper.writeValueAsString(products);

    }


}

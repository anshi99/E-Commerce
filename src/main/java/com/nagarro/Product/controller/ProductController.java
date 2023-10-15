package com.nagarro.Product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagarro.Product.model.Serviceability;
import com.nagarro.Product.service.ServiceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import com.nagarro.Product.service.ProductService;
import com.nagarro.Product.model.Products;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    ServiceabilityService serviceabilityService;


    @GetMapping("/getproductlist")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Products> fetchProductList() {
        List<Products> products = new ArrayList<Products>();
        //logic to fetch data from database
        products = service.fetchProductList();
        return products;
    }

    @PostMapping("/addproducts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Products saveProduct(@RequestBody Products products) {

        return service.saveProductsToDB(products);
    }

    @GetMapping("/getproductbyid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Products fetchProductById(@PathVariable int id) {

        return service.fetchProductById(id).get();
    }

    @GetMapping("/getproductbyname/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Products> fetchProductByName(@PathVariable String name) {

        return service.fetchProductByName(name);
    }

    @GetMapping("/getproductbybrand/{brand}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Products> fetchProductByBrand(@PathVariable String brand) {

        return service.fetchProductByBrand(brand);
    }

    @Nullable
    @GetMapping("/fetchproduct/{id}/{name}/{brand}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Products> fetchProduct(@PathVariable int id, @PathVariable String name, @PathVariable String brand) {
        //public List<Products> fetchProduct(@RequestBody Products searchProduct){
        //return service.fetchProducts(id, name,brand);
        return service.fetchByIdOrNameOrBrand(id, name, brand);
        //return service.fetchByIdOrNameOrBrand(searchProduct.getId(),searchProduct.getName(), searchProduct.getBrand());
        //return service.fetchByIdAndNameAndBrand(id, name, brand);
    }


    @GetMapping("/getproductbyid")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String findProductsById(@RequestParam String id) throws IOException {

        return service.searchProductsById(Integer.parseInt(id));
    }


    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("file") MultipartFile file, @RequestParam String brand, @RequestParam int price, @RequestParam String productName, @RequestParam String productCode, @RequestParam String description) throws IOException {
        String uploadImage = service.uploadImageToFileSystem(file, brand, price, productName, productCode, description);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/bypincode")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String findDaysByPincode(@RequestParam String pincode) throws IOException {

        return serviceabilityService.searchDaysByPinCode(Integer.parseInt(pincode));
    }


    @GetMapping("/pricefilter")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String getPricefilter(@RequestParam int id, @RequestParam String productName ,
                                 @RequestParam String brandName ,@RequestParam String productCode ,
                                 @RequestParam String min ,@RequestParam String max ) throws JsonProcessingException {


        return service.pricefilter(id,productName ,brandName ,productCode,min ,max);
    }
}



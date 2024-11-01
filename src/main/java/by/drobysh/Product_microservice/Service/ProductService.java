package by.drobysh.Product_microservice.Service;

import by.drobysh.Product_microservice.Service.Dto.CreateProductDto;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException;
}

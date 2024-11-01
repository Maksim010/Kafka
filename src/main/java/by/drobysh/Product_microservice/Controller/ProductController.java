package by.drobysh.Product_microservice.Controller;

import by.drobysh.Product_microservice.Service.Dto.CreateProductDto;
import by.drobysh.Product_microservice.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());


    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductDto createProductDto){
        String productId= null;
        try {
            productId = productService.createProduct(createProductDto);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(new Date(), e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}

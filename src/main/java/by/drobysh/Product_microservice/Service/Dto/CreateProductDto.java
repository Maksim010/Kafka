package by.drobysh.Product_microservice.Service.Dto;

import java.math.BigDecimal;

public class CreateProductDto {
    private String title;
    private BigDecimal price;
    private Integer quantity;




    public CreateProductDto() {
    }

    public CreateProductDto(String title, BigDecimal price, Integer quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package by.drobysh.Product_microservice.Service;

import by.drobysh.Product_microservice.Service.Dto.CreateProductDto;

import by.drobysh.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class ImplProductService implements ProductService{
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    public ImplProductService(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException {
        //TODO save to db
        String productId= UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent=new ProductCreatedEvent(productId,createProductDto.getTitle(),
                createProductDto.getPrice(),createProductDto.getQuantity());

        SendResult<String,ProductCreatedEvent> result=kafkaTemplate
                .send("product-created-event-topic",productCreatedEvent).get();

        LOGGER.info("Topic : {}",result.getRecordMetadata().topic());
        LOGGER.info("Partition : {}",result.getRecordMetadata().partition());
        LOGGER.info("Offset : {}",result.getRecordMetadata().offset());


        LOGGER.info("Return : {}",productId);

        return productId;
    }
}

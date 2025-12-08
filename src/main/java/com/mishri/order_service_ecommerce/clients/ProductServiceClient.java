package com.mishri.order_service_ecommerce.clients;

import com.mishri.order_service_ecommerce.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
    private final RestTemplate restTemplate;

    ProductServiceClient(RestTemplate _restTemplate){
        this.restTemplate = _restTemplate;
    }

    public ProductDTO getProductById(Long productId){

        String url = "http://localhost:8080/api/v1/ecommerce/product/" + productId;

        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url,ProductDTO.class);

        return response.getBody();
    }
}

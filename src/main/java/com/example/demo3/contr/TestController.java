package com.example.demo3.contr;


import com.example.demo3.model.Card;
import com.example.demo3.model.Transfer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getAll")
    public ResponseEntity getCards() {
        List<Card> cards = restTemplate.getForObject("http://localhost:8080/transfer/all", List.class);
        System.out.println(cards);
        return ResponseEntity.ok(cards);
    }


    @GetMapping("/testId/{id}")
    public ResponseEntity getCardById(@PathVariable int id) {
        Card card = restTemplate.getForObject("http://localhost:8080/card/id/" + id, Card.class);
        System.out.println(card);
        log.info(">>>id {}", id);
        return ResponseEntity.ok(card);
    }

  /*  @GetMapping("/transfer")
    public boolean transfer() {

        Transfer transfer = new Transfer();
        transfer.setCash(500);
        transfer.setSenderNumber("7777878654543456");
        transfer.setGetterNumber("7777878654243456");

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<Transfer> httpEntity = new HttpEntity<>(transfer, httpHeaders);
            ResponseEntity<Transfer> responseEntity = restTemplate.exchange("http://localhost:8080/transfer/add", HttpMethod.POST, httpEntity, Transfer.class);
            return responseEntity.getStatusCode() == HttpStatus.OK;

        } catch (RestClientResponseException exception) {
            if (exception.getRawStatusCode() == HttpStatus.PAYMENT_REQUIRED.value()) {
                log.warn(">>>error on balance:");
                return false;
            }
            log.warn(">>> status {} response body {}", exception.getRawStatusCode(), exception.getResponseBodyAsString());
            return false;

        }*/
//            log.error(exception.getMessage());
//            return ResponseEntity
//                    .status(exception.getRawStatusCode())
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(exception.getResponseBodyAsString());
//        }


    @GetMapping("/sign")
    public ResponseEntity sign_up() {

        Card card = new Card();
        card.setBalance(66666);
        card.setExpirationDate(new Date());
        card.setHolderName("dfdfdfdfdf");
        card.setNumber("1768878987656543");


        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<Card> httpEntity = new HttpEntity<>(card, httpHeaders);
            ResponseEntity<Transfer> responseEntity = restTemplate.exchange("http://localhost:8080/card/sign", HttpMethod.POST, httpEntity, Transfer.class);
            return responseEntity;

        } catch (RestClientResponseException exception) {
            log.error(">>>" + exception.getMessage() + ":");
            return ResponseEntity
                    .status(exception.getRawStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(exception.getResponseBodyAsString());

        }
    }


    @GetMapping("/t")
    public ResponseEntity transfer() {
        Transfer transfer = new Transfer();
        transfer.setCash(222);
        transfer.setSenderNumber("7777878654543456");
        transfer.setGetterNumber("7777878654243456");


        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<Transfer> httpEntity = new HttpEntity<>(transfer, httpHeaders);
            ResponseEntity<Transfer> responseEntity = restTemplate.exchange("http://localhost:8080/transfer/add", HttpMethod.POST, httpEntity, Transfer.class);
            return responseEntity;

        } catch (RestClientResponseException exception) {
            log.error(">>>" + exception.getMessage() + ":");
            return ResponseEntity
                    .status(exception.getRawStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(exception.getResponseBodyAsString());

        }
    }

//    @GetMapping("/up/{id}")
//    public ResponseEntity update(@PathVariable int id) {
//        try {
//
//            Card card = restTemplate.getForObject("http://localhost:8080/card/id/" + id, Card.class);
//            card.setId(id);
//            card.setHolderName("David");
//            card.setNumber("3332343433332333");
//            card.setExpirationDate(new Date());
//            card.setBalance(9000);
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//            HttpEntity<Card> httpEntity = new HttpEntity<>(card, httpHeaders);
//            ResponseEntity<Card> responseEntity = restTemplate.exchange("http://localhost:8080/card/up/" + id, HttpMethod.PUT, httpEntity, Card.class);
//            return responseEntity;
//        } catch (RestClientResponseException e) {
//            log.error(">>>message: " + e.getMessage() + ":" + " status " + e.getRawStatusCode() + ":" + " response " + e.getResponseBodyAsString());
//            log.error(">>>headers " + e.getResponseHeaders());
//            return ResponseEntity
//                    .status(e.getRawStatusCode())
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(e.getResponseBodyAsString());
//        }
//    }

    @GetMapping("/del/{id}")
    public ResponseEntity del(@PathVariable int id) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("deletePressingServerPath", "http://localhost:8080/card/del/" + id);
            HttpEntity<Card> httpEntity = new HttpEntity<>(httpHeaders);

            restTemplate.exchange("http://localhost:8080/card/del/" + id, HttpMethod.DELETE, httpEntity, Card.class);
            return ResponseEntity.noContent().build();
        } catch (RestClientResponseException e) {
            log.error(">>>message: " + e.getMessage() + ":" + " status " + e.getRawStatusCode() + ":" + " response " + e.getResponseBodyAsString());
            log.error(">>>headers " + e.getResponseHeaders());
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getResponseBodyAsString());

        }
    }
}
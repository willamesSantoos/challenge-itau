package br.com.willamessantos.challenge_itau.controllers;

import br.com.willamessantos.challenge_itau.dto.StatisticResponse;
import br.com.willamessantos.challenge_itau.dto.TransactionRequest;
import br.com.willamessantos.challenge_itau.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/transaction")
    private ResponseEntity<Void> create(@RequestBody TransactionRequest request) {

        service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/transaction")
    private ResponseEntity<Void> delete() {

        service.delete();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/statistic")
    private ResponseEntity<StatisticResponse> viewStatistic() {

        StatisticResponse response = service.viewStatistic();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

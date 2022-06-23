package com.example.demo.controllers;

import com.example.demo.models.Operator;
import com.example.demo.repositories.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("operators")
public class OperatorController {

    private final OperatorRepository repo;

    @Autowired
    public OperatorController(OperatorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public HttpEntity<HashMap> get_all_operators() {
        HashMap r = new HashMap();
        List<Operator> list_operators = repo.findAll();
        List respons = new ArrayList<>();
        for (Operator operator : list_operators) {
            HashMap tmp = new HashMap();
            tmp.put("id", operator.getId());
            tmp.put("name", operator.getName());
            tmp.put("service_provider", operator.getService_provider());
            respons.add(tmp);
        }
        r.put("data", respons);
        return ResponseEntity.status(HttpStatus.OK).body(r);
    }

    @PostMapping
    public HttpEntity<HashMap> create_operator(@RequestBody Operator operator) {
        HashMap response_body = new HashMap();
        Operator exists = repo.findOperatorByName(operator.getName());
        if (exists != null) {
            response_body.put("response", "Operator Already Exists !");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response_body);
        } else {
            response_body.put("response", "Operator Has Been Created");
            repo.save(operator);
            return ResponseEntity.status(HttpStatus.CREATED).body(response_body);
        }
    }

}

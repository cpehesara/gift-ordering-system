package com.example.demo.controller;

import com.example.demo.model.Toy;
import com.example.demo.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/toys")
@CrossOrigin("http://localhost:3000")
public class ToyController {
    @Autowired
    private ToyService service;

    @GetMapping("/getToys")
    public List<Toy> getAllToys(){
        return service.getAllToys();
    }

    @GetMapping("/getToy/{toyid}")
    public Toy getToy(@PathVariable String toyid){
        return service.getToyByID(toyid);
    }

    @PostMapping("/saveToy")
    public Toy createToy(@RequestBody Toy toy) {
        return service.createToy(toy);
    }

    @PutMapping("/updateToy/{toyid}")
    public Toy updateToy(@RequestBody Toy toy){
        return service.updateToy(toy);
    }

    @DeleteMapping("/deleteToy")
    public boolean deleteBranch(@RequestBody Toy toy){
        return service.deleteToy(toy);
    }
}

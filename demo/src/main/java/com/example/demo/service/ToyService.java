package com.example.demo.service;

import com.example.demo.model.Toy;
import com.example.demo.repository.ToyRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ToyService {

    @Autowired
    private ToyRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Toy> getAllToys() {
        return repository.findAll();
    }

    public Toy getToyByID(String toyid){
        Toy toy = repository.getToyByID(toyid);
        return modelMapper.map(toy, Toy.class);
    }

    public Toy createToy(Toy toy){
        repository.save(modelMapper.map(toy,Toy.class));
        return toy;
    }

    public Toy updateToy(Toy toy){
        repository.save(modelMapper.map(toy,Toy.class));
        return toy;
    }

    public boolean deleteToy(Toy toy){
        repository.delete(modelMapper.map(toy,Toy.class));
        return true;
    }
}

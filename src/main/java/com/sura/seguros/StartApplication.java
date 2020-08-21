package com.sura.seguros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sura.seguros.entity.Categoria;
import com.sura.seguros.repository.CategoriaRepository;

@SpringBootApplication
public class StartApplication implements CommandLineRunner 
{

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private CategoriaRepository repository;

    public static void main(String[] args) 
    {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) 
    {

        log.info("StartApplication...");

        repository.save(new Categoria("Java"));
        repository.save(new Categoria("Node"));
        repository.save(new Categoria("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));

    }

}
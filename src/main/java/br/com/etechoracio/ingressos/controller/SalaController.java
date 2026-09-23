package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Filme;
import br.com.etechoracio.ingressos.entity.Sala;
import br.com.etechoracio.ingressos.repositories.SalaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;


    public SalaController(SalaRepository salaRepository){
        this.salaRepository = salaRepository;
    }


    // Buscar todas as Salas
    @GetMapping
    public List<Sala> buscarTodos(){return salaRepository.findAll();}



    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id){
        var sala = salaRepository.findById(id);
        if(sala.isPresent())
            return ResponseEntity.ok(sala.get());
        return ResponseEntity.notFound().build();
    }

    // Salvar Sala
    @PostMapping
    public ResponseEntity<Sala> cadastrar(@RequestBody Sala sala){
        sala = salaRepository.save(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }






}




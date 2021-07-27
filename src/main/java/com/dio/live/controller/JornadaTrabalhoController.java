package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public JornadaTrabalho  createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaTrabalhoService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadById(@PathVariable("idJornada") Long idJornada) throws  Exception{
        return ResponseEntity.ok(jornadaTrabalhoService.getById(idJornada).orElseThrow(() -> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.updateJornada(jornadaTrabalho);
    }


    @DeleteMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> deleteJornadById(@PathVariable("idJornada") Long idJornada) throws  Exception{

       try{
           jornadaTrabalhoService.deleteJornada(idJornada);
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
         return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }

}

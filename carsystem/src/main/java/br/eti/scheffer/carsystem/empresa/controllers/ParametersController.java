package br.eti.scheffer.carsystem.empresa.controllers;

import br.eti.scheffer.carsystem.empresa.dtos.ParametersDto;
import br.eti.scheffer.core.entities.Parameters;
import br.eti.scheffer.carsystem.empresa.services.ParametersService;
import br.eti.scheffer.core.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RequestMapping("/parameters")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class ParametersController {

    @Autowired
    private ParametersService parametersService;

    @GetMapping
    public ResponseEntity<Parameters> load(){
        Response<Parameters> response = new Response<>();
        response.setData(this.parametersService.loadParameters());
        return ResponseEntity.ok(response.getData());
    }

    @PostMapping
    public ResponseEntity<Parameters> save(@Valid @RequestBody ParametersDto dto){
        log.info(dto.toString());
        Response<Parameters> response = new Response<>();
        response.setData(this.parametersService.save(dto));
        return ResponseEntity.ok(response.getData());
    }

    @PutMapping
    public ResponseEntity<Parameters> update(@Valid @RequestBody ParametersDto dto){
        Response<Parameters> response = new Response<>();
        response.setData(this.parametersService.update(dto));
        return ResponseEntity.ok(response.getData());
    }

}

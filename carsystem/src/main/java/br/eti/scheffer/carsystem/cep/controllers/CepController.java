package br.eti.scheffer.carsystem.cep.controllers;

import br.eti.scheffer.carsystem.cep.model.Cep;
import br.eti.scheffer.carsystem.cep.services.CepService;
import br.eti.scheffer.core.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/cep")
@CrossOrigin(origins = "*")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<Response<Cep>> findCep(@PathVariable("cep") String cep){
        Response<Cep> response = new Response<>();
        response.setData(this.cepService.findCep(cep));
        return ResponseEntity.ok(response);
    }

}

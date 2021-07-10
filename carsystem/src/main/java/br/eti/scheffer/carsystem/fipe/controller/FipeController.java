package br.eti.scheffer.carsystem.fipe.controller;


import br.eti.scheffer.carsystem.fipe.model.*;
import br.eti.scheffer.carsystem.fipe.services.FipeService;
import br.eti.scheffer.core.utils.About;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/fipe")
@RestController
public class FipeController {

    @Autowired
    private FipeService fipeService;

    @GetMapping
    public String getAbout(){
        return About.getAbout("Consulta Tabela Fipe");
    }

    @GetMapping(value = "/referencia")
    public ResponseEntity<List<Referencia>> ListReferencia() {
        return ResponseEntity.ok(this.fipeService.listReferencia());

    }

    // http://localhost:8080/gateway/fipe/marcas/tipo/1/referencia/266
    @GetMapping(value = "/marcas/{tipo}/{referencia}")
    public ResponseEntity<List<Marcas>> listMarcas(@PathVariable("tipo") String tipo,
                                                   @PathVariable("referencia") String referencia
    ) {
        return ResponseEntity.ok(this.fipeService.listMarcas(tipo,referencia));
    }

    // http://localhost:8080/modelos/1/266/3
    @GetMapping(value = "/modelos/{tipo}/{referencia}/{marca}")
    public ResponseEntity<List<Modelos>> listModelos(@PathVariable("tipo") String tipo,
                                                     @PathVariable("referencia") String referencia,
                                                     @PathVariable("marca") String marca) {
        return ResponseEntity.ok(this.fipeService.listModelos(tipo, referencia, marca));
    }

    //http://localhost:8080/anomodelo/1/266/3/5
    @GetMapping(value = "/anomodelo/{tipo}/{referencia}/{marca}/{modelo}")
    public ResponseEntity<List<AnoModelo>> listAnoModelo(@PathVariable("tipo") String tipo,
                                                         @PathVariable("referencia") String referencia,
                                                         @PathVariable("marca") String marca,
                                                         @PathVariable("modelo") String modelo) {
        return ResponseEntity.ok(this.fipeService.listAnoModelo(tipo, referencia, marca, modelo));
    }

    //http://localhost:8080/modeloano/1/266/3/5/1999-1
    @GetMapping(value = "/modeloano/{tipo}/{referencia}/{marca}/{modelo}/{ano}")
    public ResponseEntity<List<AnoModelo>> listaModeloByAno(@PathVariable("tipo") String tipo,
                                                            @PathVariable("referencia") String referencia,
                                                            @PathVariable("marca") String marca,
                                                            @PathVariable("modelo") String modelo,
                                                            @PathVariable("ano") String ano) {
        return ResponseEntity.ok(this.fipeService.listaModeloEAno(tipo, referencia, marca, modelo, ano));
    }

    //http://localhost:8080/veiculo/1/266/3/5/1999-1/1
    @GetMapping(value = "/veiculo/{tipo}/{referencia}/{marca}/{modelo}/{ano}/{tipoconsulta}")
    public ResponseEntity<Veiculo> veiculo(@PathVariable("tipo") String tipo,
                                           @PathVariable("referencia") String referencia,
                                           @PathVariable("marca") String marca,
                                           @PathVariable("modelo") String modelo,
                                           @PathVariable("ano") String ano,
                                           @PathVariable("tipoconsulta") String tipoConsulta) {

        return ResponseEntity.ok(this.fipeService.findVeiculo(tipo, referencia, marca, modelo, ano, tipoConsulta));
    }

    @GetMapping(value = "/codigofipe")
    public ResponseEntity<List<VeiculoAnoCombustivel>> findVeiculoCodigoFipe() {
        return ResponseEntity.ok(this.fipeService.findVeiculoCodigoFipe("1", "266", "009171-5"));
    }
}


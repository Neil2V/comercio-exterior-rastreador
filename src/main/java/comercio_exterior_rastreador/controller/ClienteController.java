package comercio_exterior_rastreador.controller;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/listadoClientes")
    public ResponseEntity<Flux<Cliente>> listaClientes(){
        return new ResponseEntity<>(clienteService.listaClientes(), HttpStatus.OK);
    }
    @PostMapping(path = "/registrar")
    public ResponseEntity<Mono<Cliente>> registrarCliene(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.saveCliente(cliente), HttpStatus.OK);
    }
}

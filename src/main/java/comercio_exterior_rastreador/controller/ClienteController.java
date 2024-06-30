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
    public ResponseEntity<Mono<Cliente>> registrarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.saveCliente(cliente), HttpStatus.OK);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Mono<Cliente>> actualizarCliene(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.updateCliente(cliente), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{idCliente}")
    public Mono<ResponseEntity<Cliente>> eliminar(@PathVariable("idCliente") Integer idCliente){
        return clienteService.deleteCliente(idCliente)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }
}

package hotelSaver.com.hotelSaver.web.controllers;

import hotelSaver.com.hotelSaver.service.interfaces.ClienteService;
import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/apiClientes/v1")
@RestController
public class ClientsController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/createClient")
    ResponseEntity<ClienteDTO> createClient(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.createClient(clienteDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getClient/{documento}")
    ResponseEntity<ClienteDTO> getClient(@PathVariable("documento")Long documento){
        return new ResponseEntity<>(clienteService.getClient(documento), HttpStatus.OK);
    }
}

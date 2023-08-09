package hotelSaver.com.hotelSaver.web.controllers;

import hotelSaver.com.hotelSaver.service.interfaces.ClienteService;
import hotelSaver.com.hotelSaver.web.dto.ClientDtoRequest;
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
    ResponseEntity<ClientDtoRequest> createClient(@RequestBody ClientDtoRequest clienteDTO){
        return new ResponseEntity<>(clienteService.createClient(clienteDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getClient/{documento}")
    ResponseEntity<ClientDtoRequest> getClient(@PathVariable("documento")Long documento){
        return new ResponseEntity<>(clienteService.getClient(documento), HttpStatus.OK);
    }

    @PutMapping("/updateClient")
    ResponseEntity<ClientDtoRequest> updateClient(@RequestBody ClientDtoRequest clientDtoRequest){
        return new ResponseEntity<>(clienteService.updateClient(clientDtoRequest), HttpStatus.OK);
    }

    @DeleteMapping("deleteClient/{documento}")
    ResponseEntity<HttpStatus> deleteClient(@PathVariable("documento")Long documento){
        return new ResponseEntity<>(clienteService.deleteClient(documento), HttpStatus.NO_CONTENT);
    }
}

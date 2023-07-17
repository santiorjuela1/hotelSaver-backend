package hotelSaver.com.hotelSaver.web.controllers;

import hotelSaver.com.hotelSaver.service.interfaces.UserService;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(name = "/apiUsers/v1")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    ResponseEntity<UserDTO> createUsuario(@RequestBody UserDTO userDTO){
        return new
                ResponseEntity<>(userService.createUsuario(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{documento}")
    ResponseEntity<UserDTO> getUsuario(@PathVariable("documento") Long documento){
        return new
                ResponseEntity<>(userService.getUsuario(documento), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{documento}")
    ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("documento") Long documento){
        return new
                ResponseEntity<>(userService.deleteUsuario(documento), HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    ResponseEntity<UserDTO> updateUsuario(@RequestBody UserDTO userDTO){
        return new
                ResponseEntity<>(userService.updateUsuario(userDTO), HttpStatus.NO_CONTENT);
    }

}

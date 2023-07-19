package hotelSaver.com.hotelSaver.web.controllers;

import hotelSaver.com.hotelSaver.service.interfaces.HotelService;
import hotelSaver.com.hotelSaver.web.dto.HotelDTO;
import hotelSaver.com.hotelSaver.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/apiHotels/v1")
@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/createHotel")
    ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO){
        return new
                ResponseEntity<>(hotelService.createHotel(hotelDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getHotel/{id}")
    ResponseEntity<HotelDTO> getUsuario(@PathVariable("id")String id){
        return new
                ResponseEntity<>(hotelService.getHotel(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteHotel/{id}")
    ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id")String id){
        return new
                ResponseEntity<>(hotelService.deleteHotel(id), HttpStatus.OK);
    }

    @PutMapping("/updateHotel")
    ResponseEntity<HotelDTO> updateUsuario(@RequestBody HotelDTO hotelDTO){
        return new
                ResponseEntity<>(hotelService.updateHotel(hotelDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllHotels")
    ResponseEntity<List<HotelDTO>> getAllHotels(){
        return new
                ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.ACCEPTED);
    }
}

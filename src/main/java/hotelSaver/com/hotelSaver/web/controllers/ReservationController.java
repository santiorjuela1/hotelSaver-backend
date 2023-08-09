package hotelSaver.com.hotelSaver.web.controllers;


import hotelSaver.com.hotelSaver.service.interfaces.ReservationService;
import hotelSaver.com.hotelSaver.web.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/apiReservations/v1")
@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/createReservation")
    ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO){
        return new
                ResponseEntity<>(reservationService.createReservation(reservationDTO),HttpStatus.CREATED);
    }
    
    @GetMapping("/getReservation/{documento}/{tipoDocumento}/{hotelID}")
    ResponseEntity<ReservationDTO> getReservation(@PathVariable("documento")Long documento,
                                            @PathVariable("tipoDocumento")String tipoDocumento,
                                            @PathVariable("hotelID") String hotelID) {
        return new ResponseEntity<>(reservationService.getReservation(documento, tipoDocumento, hotelID), HttpStatus.OK);
    }

    @DeleteMapping("/deleteReservation/{documento}/{tipoDocumento}/{hotelID}")
    ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("documento")Long documento,
                                             @PathVariable("tipoDocumento")String tipoDocumento,
                                             @PathVariable("hotelID") String hotelID) {
        return new
                ResponseEntity<>(
                        reservationService.deleteReservation(documento, tipoDocumento,hotelID ),
                        HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateReservation")
    ResponseEntity<ReservationDTO> updateUsuario(@RequestBody ReservationDTO reservationDTO){
        return new
                ResponseEntity<>(reservationService.updateReservation(reservationDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllByHotelID/{hotelID}")
    ResponseEntity<List<ReservationDTO>> getAllByHotelID(@PathVariable("hotelID")String hotelID){
        return new ResponseEntity<>(reservationService.findAllByHotelID(hotelID), HttpStatus.ACCEPTED);
    }

    @GetMapping("getAllByUserDocumento/{documento}")
    ResponseEntity<List<ReservationDTO>> getAllByUserDocumento(@PathVariable("documento")Long documento){
        return new ResponseEntity<>(reservationService.findAllByUserDocumento(documento), HttpStatus.ACCEPTED);
    }
}

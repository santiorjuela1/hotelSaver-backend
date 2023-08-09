package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.configurations.mapper.ClientMapper;
import hotelSaver.com.hotelSaver.model.entities.*;
import hotelSaver.com.hotelSaver.model.repositories.ClientRepository;
import hotelSaver.com.hotelSaver.model.repositories.ReservationRepository;
import hotelSaver.com.hotelSaver.service.interfaces.ClienteService;
import hotelSaver.com.hotelSaver.web.dto.ClientDtoRequest;
import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import hotelSaver.com.hotelSaver.web.exceptions.types.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClienteService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientMapper clientMapper;

    @Override
    public ClientDtoRequest createClient(ClientDtoRequest clienteDTO) {

        UserID userID = new UserID(clienteDTO.getDocumentoUser(), clienteDTO.getTipoDocumentoUser());
        ReservationID reservationID = new ReservationID(userID, clienteDTO.getHotelID());

        ReservationEntity reservationEntity = reservationRepository.findById(reservationID)
                .orElseThrow(() -> new NotFoundException("Id not found!"));

        ClienteEntity clienteEntity = clientMapper.toClienteEntity(clienteDTO);
        clienteEntity.setReservationEntity(reservationEntity);

        clienteEntity = clientRepository.save(clienteEntity);

        return clientMapper.toClientDtoRequest(clienteEntity);
    }

    @Override
    public ClientDtoRequest getClient(Long documento) {
        ClienteEntity clienteEntity = clientRepository.findById(documento)
                .orElseThrow(() -> new NotFoundException("Cliente not found!"));

        return clientMapper.toClientDtoRequest(clienteEntity);
    }

    @Override
    public HttpStatus deleteClient(Long documento) {
        ClienteEntity clienteEntity = clientRepository.findById(documento)
                .orElseThrow(() -> new NotFoundException("Cliente not found!"));

        clientRepository.delete(clienteEntity);

        return HttpStatus.NO_CONTENT;
    }

    @Override
    public ClientDtoRequest updateClient(ClientDtoRequest clienteDTO) {

        ClienteEntity clienteEntity = clientRepository.findById(clienteDTO.getDocumento())
                .orElseThrow(() -> new NotFoundException("Id was not found"));

        ClienteEntity clienteEntity1 = clientMapper.toClienteEntity(clienteDTO);

        clientRepository.save(clienteEntity1);

        return clientMapper.toClientDtoRequest(clienteEntity1);
    }


}

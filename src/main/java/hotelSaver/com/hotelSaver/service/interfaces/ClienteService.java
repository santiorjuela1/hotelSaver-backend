package hotelSaver.com.hotelSaver.service.interfaces;


import hotelSaver.com.hotelSaver.web.dto.ClientDtoRequest;
import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import org.springframework.http.HttpStatus;

public interface ClienteService {
    ClientDtoRequest createClient(ClientDtoRequest clienteDTO);
    ClientDtoRequest getClient(Long documento);
    HttpStatus deleteClient(Long documento);
    ClientDtoRequest updateClient(ClientDtoRequest clienteDTO);
}

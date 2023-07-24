package hotelSaver.com.hotelSaver.service.interfaces;


import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import org.springframework.http.HttpStatus;

public interface ClienteService {
    ClienteDTO createClient(ClienteDTO clienteDTO);
    ClienteDTO getClient(Long documento);
    HttpStatus deleteClient(Long documento);
    ClienteDTO updateClient(ClienteDTO clienteDTO);
}

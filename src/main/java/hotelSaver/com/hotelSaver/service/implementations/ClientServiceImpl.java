package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.model.entities.ClienteEntity;
import hotelSaver.com.hotelSaver.model.repositories.ClientRepository;
import hotelSaver.com.hotelSaver.service.interfaces.ClienteService;
import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import org.aspectj.asm.IModelFilter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClienteService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ClienteDTO createClient(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity =  clientRepository.save(modelMapper.map(clienteDTO, ClienteEntity.class));
        return modelMapper.map(clienteEntity, ClienteDTO.class);
    }

    @Override
    public ClienteDTO getClient(Long documento) {
        return null;
    }

    @Override
    public HttpStatus deleteClient(Long documento) {
        return null;
    }

    @Override
    public ClienteDTO updateClient(ClienteDTO clienteDTO) {
        return null;
    }
}

package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.ClientRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Client;
import com.isdbbros.realestate.service.super_classes.config.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.isdbbros.realestate.RealEstateApplication.getCurrentUsername;
import static com.isdbbros.realestate.constants.enums.OperationStatus.FAILURE;
import static com.isdbbros.realestate.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Response storeData(Client data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            clientRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Client>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, clientRepository.findAll(pageable));
    }

    @Override
    public Response<Client> getById(Long id) {
        Client client = clientRepository.findById(id).orElse(new Client());
        return new Response<>(SUCCESS, null, client);
    }

    @Override
    public Response delete(Long id) {
        clientRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Client data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Client data) {
//        boolean clientnameExists;
//        if (data.hasId()) {
//            clientnameExists = clientRepository.existsByClientname(data.getClientname(), data.getId());
//        } else {
//            clientnameExists = clientRepository.existsByClientname(data.getClientname());
//        }
//        return clientnameExists ? "Failed to register. Client already exists" : null;
        return null;
    }

}

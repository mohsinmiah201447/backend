package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.ClientApplicationRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.ClientApplication;
import com.isdbbros.realestate.service.super_classes.data.ClientApplicationService;
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
public class ClientApplicationServiceImpl implements ClientApplicationService {

    private final ClientApplicationRepository clientApplicationRepository;

    @Override
    public Response storeData(ClientApplication data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            clientApplicationRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<ClientApplication>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, clientApplicationRepository.findAll(pageable));
    }

    @Override
    public Response<ClientApplication> getById(Long id) {
        ClientApplication carRentPayment = clientApplicationRepository.findById(id).orElse(new ClientApplication());
        return new Response<>(SUCCESS, null, carRentPayment);
    }

    @Override
    public Response delete(Long id) {
        clientApplicationRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(ClientApplication data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(ClientApplication data) {
//        boolean carRentPaymentnameExists;
//        if (data.hasId()) {
//            carRentPaymentnameExists = clientApplicationRepository.existsByClientApplicationname(data.getClientApplicationname(), data.getId());
//        } else {
//            carRentPaymentnameExists = clientApplicationRepository.existsByClientApplicationname(data.getClientApplicationname());
//        }
//        return carRentPaymentnameExists ? "Failed to register. ClientApplication already exists" : null;
        return null;
    }

}

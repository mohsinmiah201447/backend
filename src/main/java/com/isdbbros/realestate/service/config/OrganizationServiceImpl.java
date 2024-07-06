package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.OrganizationRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Organization;
import com.isdbbros.realestate.service.super_classes.config.OrganizationService;
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
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    @Override
    public Response storeData(Organization data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            organizationRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }
    @Override
    public Response<Page<Organization>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, organizationRepository.findAll(pageable));
    }

    @Override
    public Response<Organization> getById(Long id) {
        Organization client = organizationRepository.findById(id).orElse(new Organization());
        return new Response<>(SUCCESS, null, client);
    }

    @Override
    public Response delete(Long id) {
        organizationRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Organization data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Organization data) {
//        boolean clientnameExists;
//        if (data.hasId()) {
//            clientnameExists = organizationRepository.existsByOrganizationname(data.getOrganizationname(), data.getId());
//        } else {
//            clientnameExists = organizationRepository.existsByOrganizationname(data.getOrganizationname());
//        }
//        return clientnameExists ? "Failed to register. Organization already exists" : null;
        return null;
    }

}

package com.isdbbros.realestate.service.data;

import static com.isdbbros.realestate.constants.enums.OperationStatus.FAILURE;
import static com.isdbbros.realestate.constants.enums.OperationStatus.SUCCESS;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isdbbros.realestate.dao.data.ContactRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.Contact;
import com.isdbbros.realestate.model.data.Contact;
import com.isdbbros.realestate.service.super_classes.data.ContactService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Response storeData(Contact data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            contactRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Contact>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, contactRepository.findAll(pageable));
    }

    @Override
    public Response<Contact> getById(Long id) {
        Contact contact = contactRepository.findById(id).orElse(new Contact());
        return new Response<>(SUCCESS, null, contact);
    }

    @Override
    public Response delete(Long id) {
        contactRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    private String getCurrentUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentUsername'");
    }

    @Override
    public String validate(Contact data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Contact data) {
//        boolean carRentPaymentnameExists;
//        if (data.hasId()) {
//            carRentPaymentnameExists = ContactRepository.existsByContactname(data.getContactname(), data.getId());
//        } else {
//            carRentPaymentnameExists = ContactRepository.existsByContactname(data.getContactname());
//        }
//        return carRentPaymentnameExists ? "Failed to register. Contact already exists" : null;
        return null;
    }

}

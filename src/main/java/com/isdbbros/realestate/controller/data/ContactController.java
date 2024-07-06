package com.isdbbros.realestate.controller.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.CarRentPayment;
import com.isdbbros.realestate.model.data.Contact;
import com.isdbbros.realestate.service.super_classes.data.ContactService;
import com.isdbbros.realestate.utils.PageUtil;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContactController implements CrudController<Contact, Long> {

private final ContactService contactService;

@Override
    public ResponseEntity<Response> storeData(Contact data) {
        Response response = contactService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Contact>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Contact>> response = contactService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Contact>> getOne(Long id) {
        Response<Contact> response =contactService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = contactService.delete(id);
        return ResponseEntity.ok(response);
    }

}

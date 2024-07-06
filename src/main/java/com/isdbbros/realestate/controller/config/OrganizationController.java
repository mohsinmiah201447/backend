package com.isdbbros.realestate.controller.config;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Organization;
import com.isdbbros.realestate.service.super_classes.config.OrganizationService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("organization/")
public class OrganizationController implements CrudController<Organization, Long> {
    private final OrganizationService organizationService;

    @Override
    public ResponseEntity<Response> storeData(Organization data) {
        Response response = organizationService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Organization>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Organization>> response = organizationService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Organization>> getOne(Long id) {
        Response<Organization> response = organizationService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = organizationService.delete(id);
        return ResponseEntity.ok(response);
    }
}

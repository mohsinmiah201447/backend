package com.isdbbros.realestate.controller.auth;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.auth.Permission;
import com.isdbbros.realestate.service.super_classes.auth.PermissionService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("permission/")
public class PermissionController implements CrudController<Permission, Long> {
    private final PermissionService permissionService;

    @Override
    public ResponseEntity<Response> storeData(Permission data) {
        Response response = permissionService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Permission>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Permission>> response = permissionService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Permission>> getOne(Long id) {
        Response<Permission> response = permissionService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = permissionService.delete(id);
        return ResponseEntity.ok(response);
    }
}

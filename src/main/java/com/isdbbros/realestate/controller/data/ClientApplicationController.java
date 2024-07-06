package com.isdbbros.realestate.controller.data;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.ClientApplication;
import com.isdbbros.realestate.service.super_classes.data.ClientApplicationService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("clientapplication/")
public class ClientApplicationController implements CrudController<ClientApplication, Long> {
    private final ClientApplicationService ClientApplicationService;

    @Override
    public ResponseEntity<Response> storeData(ClientApplication data) {
        Response response = ClientApplicationService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<ClientApplication>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<ClientApplication>> response = ClientApplicationService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<ClientApplication>> getOne(Long id) {
        Response<ClientApplication> response = ClientApplicationService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = ClientApplicationService.delete(id);
        return ResponseEntity.ok(response);
    }
}

package com.isdbbros.realestate.controller.data;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.CommissionRequisition;
import com.isdbbros.realestate.service.super_classes.data.CommissionRequisitionService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("commission-requisition/")
public class CommissionRequisitionController implements CrudController<CommissionRequisition, Long> {
    private final CommissionRequisitionService commissionRequisitionService;

    @Override
    public ResponseEntity<Response> storeData(CommissionRequisition data) {
        Response response = commissionRequisitionService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<CommissionRequisition>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<CommissionRequisition>> response = commissionRequisitionService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<CommissionRequisition>> getOne(Long id) {
        Response<CommissionRequisition> response = commissionRequisitionService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = commissionRequisitionService.delete(id);
        return ResponseEntity.ok(response);
    }
}

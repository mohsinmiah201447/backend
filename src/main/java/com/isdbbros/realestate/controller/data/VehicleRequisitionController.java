package com.isdbbros.realestate.controller.data;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.VehicleRequisition;
import com.isdbbros.realestate.service.super_classes.data.VehicleRequisitionService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("vehicle-requisition/")
public class VehicleRequisitionController implements CrudController<VehicleRequisition, Long> {
    private final VehicleRequisitionService vehicleRequisitionService;

    @Override
    public ResponseEntity<Response> storeData(VehicleRequisition data) {
        Response response = vehicleRequisitionService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<VehicleRequisition>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<VehicleRequisition>> response = vehicleRequisitionService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<VehicleRequisition>> getOne(Long id) {
        Response<VehicleRequisition> response = vehicleRequisitionService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = vehicleRequisitionService.delete(id);
        return ResponseEntity.ok(response);
    }
}

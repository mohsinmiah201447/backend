package com.isdbbros.realestate.controller.data;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.CarRentPayment;
import com.isdbbros.realestate.service.super_classes.data.CarRentPaymentService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("car-rent-payment/")
public class CarRentPaymentController implements CrudController<CarRentPayment, Long> {
    private final CarRentPaymentService carRentPaymentService;

    @Override
    public ResponseEntity<Response> storeData(CarRentPayment data) {
        Response response = carRentPaymentService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<CarRentPayment>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<CarRentPayment>> response = carRentPaymentService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<CarRentPayment>> getOne(Long id) {
        Response<CarRentPayment> response = carRentPaymentService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = carRentPaymentService.delete(id);
        return ResponseEntity.ok(response);
    }
}

package com.isdbbros.realestate.controller.config;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.PaymentConfig;
import com.isdbbros.realestate.service.super_classes.config.PaymentConfigService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("payment-config/")
public class PaymentConfigController implements CrudController<PaymentConfig, Long> {
    private final PaymentConfigService paymentConfigService;

    @Override
    public ResponseEntity<Response> storeData(PaymentConfig data) {
        Response response = paymentConfigService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<PaymentConfig>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<PaymentConfig>> response = paymentConfigService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<PaymentConfig>> getOne(Long id) {
        Response<PaymentConfig> response = paymentConfigService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = paymentConfigService.delete(id);
        return ResponseEntity.ok(response);
    }
}

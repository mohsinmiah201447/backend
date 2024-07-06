package com.isdbbros.realestate.controller.config;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.PaymentMedia;
import com.isdbbros.realestate.service.super_classes.config.PaymentMediaService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("payment-media/")
public class PaymentMediaController implements CrudController<PaymentMedia, Long> {
    private final PaymentMediaService paymentMediaService;

    @Override
    public ResponseEntity<Response> storeData(PaymentMedia data) {
        Response response = paymentMediaService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<PaymentMedia>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<PaymentMedia>> response = paymentMediaService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<PaymentMedia>> getOne(Long id) {
        Response<PaymentMedia> response = paymentMediaService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = paymentMediaService.delete(id);
        return ResponseEntity.ok(response);
    }
}

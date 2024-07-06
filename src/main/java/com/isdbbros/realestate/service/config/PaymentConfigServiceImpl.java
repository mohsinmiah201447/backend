package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.PaymentConfigRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.PaymentConfig;
import com.isdbbros.realestate.service.super_classes.config.PaymentConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.isdbbros.realestate.RealEstateApplication.getCurrentUsername;
import static com.isdbbros.realestate.constants.enums.OperationStatus.FAILURE;
import static com.isdbbros.realestate.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class PaymentConfigServiceImpl implements PaymentConfigService {

    private final PaymentConfigRepository paymentConfigRepository;

    @Override
    public Response storeData(PaymentConfig data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            paymentConfigRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<PaymentConfig>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, paymentConfigRepository.findAll(pageable));
    }

    @Override
    public Response<PaymentConfig> getById(Long id) {
        PaymentConfig paymentConfig = paymentConfigRepository.findById(id).orElse(new PaymentConfig());
        return new Response<>(SUCCESS, null, paymentConfig);
    }

    @Override
    public Response delete(Long id) {
        paymentConfigRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(PaymentConfig data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(PaymentConfig data) {
//        boolean branchnameExists;
//        if (data.hasId()) {
//            branchnameExists = paymentConfigRepository.existsByPaymentConfigname(data.getPaymentConfigname(), data.getId());
//        } else {
//            branchnameExists = paymentConfigRepository.existsByPaymentConfigname(data.getPaymentConfigname());
//        }
//        return branchnameExists ? "Failed to register. PaymentConfig already exists" : null;
        return null;
    }

}

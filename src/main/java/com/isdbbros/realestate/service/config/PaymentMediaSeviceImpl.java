package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.PaymentMediaRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.PaymentMedia;
import com.isdbbros.realestate.service.super_classes.config.PaymentMediaService;
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
public class PaymentMediaSeviceImpl implements PaymentMediaService {

    private final PaymentMediaRepository paymentMediaRepository;

    @Override
    public Response storeData(PaymentMedia data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            paymentMediaRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<PaymentMedia>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, paymentMediaRepository.findAll(pageable));
    }

    @Override
    public Response<PaymentMedia> getById(Long id) {
        PaymentMedia branch = paymentMediaRepository.findById(id).orElse(new PaymentMedia());
        return new Response<>(SUCCESS, null, branch);
    }

    @Override
    public Response delete(Long id) {
        paymentMediaRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(PaymentMedia data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(PaymentMedia data) {
//        boolean branchnameExists;
//        if (data.hasId()) {
//            branchnameExists = paymentMediaRepository.existsByPaymentMedianame(data.getPaymentMedianame(), data.getId());
//        } else {
//            branchnameExists = paymentMediaRepository.existsByPaymentMedianame(data.getPaymentMedianame());
//        }
//        return branchnameExists ? "Failed to register. PaymentMedia already exists" : null;
        return null;
    }
}

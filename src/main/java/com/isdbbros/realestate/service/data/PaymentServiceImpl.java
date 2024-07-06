package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.PaymentRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.Payment;
import com.isdbbros.realestate.service.super_classes.data.PaymentService;
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
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Response storeData(Payment data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            paymentRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Payment>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, paymentRepository.findAll(pageable));
    }

    @Override
    public Response<Payment> getById(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(new Payment());
        return new Response<>(SUCCESS, null, payment);
    }

    @Override
    public Response delete(Long id) {
        paymentRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Payment data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Payment data) {
//        boolean paymentnameExists;
//        if (data.hasId()) {
//            paymentnameExists = paymentRepository.existsByPaymentname(data.getPaymentname(), data.getId());
//        } else {
//            paymentnameExists = paymentRepository.existsByPaymentname(data.getPaymentname());
//        }
//        return paymentnameExists ? "Failed to register. Payment already exists" : null;
        return null;
    }

}

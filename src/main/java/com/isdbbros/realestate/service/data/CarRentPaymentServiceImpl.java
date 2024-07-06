package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.CarRentPaymentRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.CarRentPayment;
import com.isdbbros.realestate.service.super_classes.data.CarRentPaymentService;
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
public class CarRentPaymentServiceImpl implements CarRentPaymentService {

    private final CarRentPaymentRepository carRentPaymentRepository;

    @Override
    public Response storeData(CarRentPayment data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            carRentPaymentRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<CarRentPayment>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, carRentPaymentRepository.findAll(pageable));
    }

    @Override
    public Response<CarRentPayment> getById(Long id) {
        CarRentPayment carRentPayment = carRentPaymentRepository.findById(id).orElse(new CarRentPayment());
        return new Response<>(SUCCESS, null, carRentPayment);
    }

    @Override
    public Response delete(Long id) {
        carRentPaymentRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(CarRentPayment data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(CarRentPayment data) {
//        boolean carRentPaymentnameExists;
//        if (data.hasId()) {
//            carRentPaymentnameExists = carRentPaymentRepository.existsByCarRentPaymentname(data.getCarRentPaymentname(), data.getId());
//        } else {
//            carRentPaymentnameExists = carRentPaymentRepository.existsByCarRentPaymentname(data.getCarRentPaymentname());
//        }
//        return carRentPaymentnameExists ? "Failed to register. CarRentPayment already exists" : null;
        return null;
    }

}

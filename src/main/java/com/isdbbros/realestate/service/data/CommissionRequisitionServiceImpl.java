package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.CommissionRequisitionRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.CommissionRequisition;
import com.isdbbros.realestate.service.super_classes.data.CommissionRequisitionService;
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
public class CommissionRequisitionServiceImpl implements CommissionRequisitionService {

    private final CommissionRequisitionRepository commissionRequisitionRepository;

    @Override
    public Response storeData(CommissionRequisition data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            commissionRequisitionRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<CommissionRequisition>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, commissionRequisitionRepository.findAll(pageable));
    }

    @Override
    public Response<CommissionRequisition> getById(Long id) {
        CommissionRequisition carRentPayment = commissionRequisitionRepository.findById(id).orElse(new CommissionRequisition());
        return new Response<>(SUCCESS, null, carRentPayment);
    }

    @Override
    public Response delete(Long id) {
        commissionRequisitionRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(CommissionRequisition data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(CommissionRequisition data) {
//        boolean carRentPaymentnameExists;
//        if (data.hasId()) {
//            carRentPaymentnameExists = commissionRequisitionRepository.existsByCommissionRequisitionname(data.getCommissionRequisitionname(), data.getId());
//        } else {
//            carRentPaymentnameExists = commissionRequisitionRepository.existsByCommissionRequisitionname(data.getCommissionRequisitionname());
//        }
//        return carRentPaymentnameExists ? "Failed to register. CommissionRequisition already exists" : null;
        return null;
    }

}

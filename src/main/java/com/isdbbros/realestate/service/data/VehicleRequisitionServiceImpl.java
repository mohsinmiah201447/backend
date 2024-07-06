package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.VehicleRequisitionRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.VehicleRequisition;
import com.isdbbros.realestate.service.super_classes.data.VehicleRequisitionService;
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
public class VehicleRequisitionServiceImpl implements VehicleRequisitionService {

    private final VehicleRequisitionRepository vehicleRequisitionRepository;

    @Override
    public Response storeData(VehicleRequisition data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            vehicleRequisitionRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<VehicleRequisition>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, vehicleRequisitionRepository.findAll(pageable));
    }

    @Override
    public Response<VehicleRequisition> getById(Long id) {
        VehicleRequisition vehicleRequisition = vehicleRequisitionRepository.findById(id).orElse(new VehicleRequisition());
        return new Response<>(SUCCESS, null, vehicleRequisition);
    }

    @Override
    public Response delete(Long id) {
        vehicleRequisitionRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(VehicleRequisition data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(VehicleRequisition data) {
//        boolean vehicleRequisitionnameExists;
//        if (data.hasId()) {
//            vehicleRequisitionnameExists = vehicleRequisitionRepository.existsByVehicleRequisitionname(data.getVehicleRequisitionname(), data.getId());
//        } else {
//            vehicleRequisitionnameExists = vehicleRequisitionRepository.existsByVehicleRequisitionname(data.getVehicleRequisitionname());
//        }
//        return vehicleRequisitionnameExists ? "Failed to register. VehicleRequisition already exists" : null;
        return null;
    }

}

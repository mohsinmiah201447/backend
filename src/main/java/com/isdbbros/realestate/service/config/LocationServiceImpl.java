package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.LocationRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Location;
import com.isdbbros.realestate.service.super_classes.config.LocationService;
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
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Response storeData(Location data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            locationRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Location>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, locationRepository.findAll(pageable));
    }

    @Override
    public Response<Location> getById(Long id) {
        Location location = locationRepository.findById(id).orElse(new Location());
        return new Response<>(SUCCESS, null, location);
    }

    @Override
    public Response delete(Long id) {
        locationRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Location data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Location data) {
//        boolean locationnameExists;
//        if (data.hasId()) {
//            locationnameExists = locationRepository.existsByLocationname(data.getLocationname(), data.getId());
//        } else {
//            locationnameExists = locationRepository.existsByLocationname(data.getLocationname());
//        }
//        return locationnameExists ? "Failed to register. Location already exists" : null;
        return null;
    }

}

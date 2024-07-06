package com.isdbbros.realestate.controller.config;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Location;
import com.isdbbros.realestate.service.super_classes.config.LocationService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("location/")
public class LocationController implements CrudController<Location, Long> {
    private final LocationService locationService;

    @Override
    public ResponseEntity<Response> storeData(Location data) {
        Response response = locationService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Location>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Location>> response = locationService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Location>> getOne(Long id) {
        Response<Location> response = locationService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = locationService.delete(id);
        return ResponseEntity.ok(response);
    }
}

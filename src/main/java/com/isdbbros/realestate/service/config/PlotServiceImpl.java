package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.PlotRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Plot;
import com.isdbbros.realestate.service.super_classes.config.PlotService;
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
public class PlotServiceImpl implements PlotService {

    private final PlotRepository plotRepository;

    @Override
    public Response storeData(Plot data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            plotRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Plot>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, plotRepository.findAll(pageable));
    }

    @Override
    public Response<Plot> getById(Long id) {
        Plot plot = plotRepository.findById(id).orElse(new Plot());
        return new Response<>(SUCCESS, null, plot);
    }

    @Override
    public Response delete(Long id) {
        plotRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Plot data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Plot data) {
//        boolean plotnameExists;
//        if (data.hasId()) {
//            plotnameExists = plotRepository.existsByPlotname(data.getPlotname(), data.getId());
//        } else {
//            plotnameExists = plotRepository.existsByPlotname(data.getPlotname());
//        }
//        return plotnameExists ? "Failed to register. Plot already exists" : null;
        return null;
    }

}

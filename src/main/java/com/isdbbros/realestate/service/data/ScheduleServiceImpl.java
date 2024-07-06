package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.ScheduleRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.Schedule;
import com.isdbbros.realestate.service.super_classes.config.ScheduleService;
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
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Response storeData(Schedule data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            scheduleRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Schedule>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, scheduleRepository.findAll(pageable));
    }

    @Override
    public Response<Schedule> getById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(new Schedule());
        return new Response<>(SUCCESS, null, schedule);
    }

    @Override
    public Response delete(Long id) {
        scheduleRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Schedule data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Schedule data) {
//        boolean schedulenameExists;
//        if (data.hasId()) {
//            schedulenameExists = scheduleRepository.existsBySchedulename(data.getSchedulename(), data.getId());
//        } else {
//            schedulenameExists = scheduleRepository.existsBySchedulename(data.getSchedulename());
//        }
//        return schedulenameExists ? "Failed to register. Schedule already exists" : null;
        return null;
    }

}

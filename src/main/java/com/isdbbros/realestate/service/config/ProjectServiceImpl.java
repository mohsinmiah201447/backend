package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.ProjectRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Project;
import com.isdbbros.realestate.service.super_classes.config.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Override
    public Response storeData(Project data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            projectRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Project>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, projectRepository.findAll(pageable));
    }

    @Override
    public Response<Project> getById(Long id) {
        Project plot = projectRepository.findById(id).orElse(new Project());
        return new Response<>(SUCCESS, null, plot);
    }

    @Override
    public Response delete(Long id) {
        projectRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Project data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Project data) {
//        boolean plotnameExists;
//        if (data.hasId()) {
//            plotnameExists = projectRepository.existsByProjectname(data.getProjectname(), data.getId());
//        } else {
//            plotnameExists = projectRepository.existsByProjectname(data.getProjectname());
//        }
//        return plotnameExists ? "Failed to register. Project already exists" : null;
        return null;
    }

}

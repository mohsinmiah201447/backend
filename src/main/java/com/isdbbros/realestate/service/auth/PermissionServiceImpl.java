package com.isdbbros.realestate.service.auth;

import com.isdbbros.realestate.dao.auth.PermissionRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.auth.Permission;
import com.isdbbros.realestate.service.super_classes.auth.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public Response storeData(Permission data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            permissionRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Permission>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, permissionRepository.findAll(pageable));
    }

    @Override
    public Response<Permission> getById(Long id) {
        Permission role = permissionRepository.findById(id).orElse(new Permission());
        return new Response<>(SUCCESS, null, role);
    }

    @Override
    public Response delete(Long id) {
        permissionRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Permission data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Permission data) {
//        boolean rolenameExists;
//        if (data.hasId()) {
//            rolenameExists = permissionRepository.existsByPermissionname(data.getPermissionname(), data.getId());
//        } else {
//            rolenameExists = permissionRepository.existsByPermissionname(data.getPermissionname());
//        }
//        return rolenameExists ? "Failed to register. Permission already exists" : null;
        return null;
    }

}

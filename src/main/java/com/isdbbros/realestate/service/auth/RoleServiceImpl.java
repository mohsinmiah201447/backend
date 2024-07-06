package com.isdbbros.realestate.service.auth;

import com.isdbbros.realestate.RealEstateApplication;
import com.isdbbros.realestate.dao.auth.RoleRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.auth.Role;
import com.isdbbros.realestate.service.super_classes.auth.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.isdbbros.realestate.RealEstateApplication.*;
import static com.isdbbros.realestate.constants.enums.OperationStatus.FAILURE;
import static com.isdbbros.realestate.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Response storeData(Role data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            roleRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Role>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, roleRepository.findAll(pageable));
    }

    @Override
    public Response<Role> getById(Long id) {
        Role role = roleRepository.findById(id).orElse(new Role());
        return new Response<>(SUCCESS, null, role);
    }

    @Override
    public Response delete(Long id) {
        roleRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Role data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Role data) {
//        boolean rolenameExists;
//        if (data.hasId()) {
//            rolenameExists = roleRepository.existsByRolename(data.getRolename(), data.getId());
//        } else {
//            rolenameExists = roleRepository.existsByRolename(data.getRolename());
//        }
//        return rolenameExists ? "Failed to register. Role already exists" : null;
        return null;
    }

}

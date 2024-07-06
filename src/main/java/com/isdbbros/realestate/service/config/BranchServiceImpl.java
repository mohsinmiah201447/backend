package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.BranchRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Branch;
import com.isdbbros.realestate.service.super_classes.config.BranchService;
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
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public Response storeData(Branch data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            branchRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Branch>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, branchRepository.findAll(pageable));
    }

    @Override
    public Response<Branch> getById(Long id) {
        Branch branch = branchRepository.findById(id).orElse(new Branch());
        return new Response<>(SUCCESS, null, branch);
    }

    @Override
    public Response delete(Long id) {
        branchRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Branch data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Branch data) {
//        boolean branchnameExists;
//        if (data.hasId()) {
//            branchnameExists = branchRepository.existsByBranchname(data.getBranchname(), data.getId());
//        } else {
//            branchnameExists = branchRepository.existsByBranchname(data.getBranchname());
//        }
//        return branchnameExists ? "Failed to register. Branch already exists" : null;
        return null;
    }

}

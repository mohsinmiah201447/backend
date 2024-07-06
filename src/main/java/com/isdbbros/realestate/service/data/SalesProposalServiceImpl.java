package com.isdbbros.realestate.service.data;

import com.isdbbros.realestate.dao.data.SalesProposalRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.SalesProposal;
import com.isdbbros.realestate.service.super_classes.data.SalesProposalService;
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
public class SalesProposalServiceImpl implements SalesProposalService {

    private final SalesProposalRepository salesProposalRepository;

    @Override
    public Response storeData(SalesProposal data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            salesProposalRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<SalesProposal>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, salesProposalRepository.findAll(pageable));
    }

    @Override
    public Response<SalesProposal> getById(Long id) {
        SalesProposal salesProposal = salesProposalRepository.findById(id).orElse(new SalesProposal());
        return new Response<>(SUCCESS, null, salesProposal);
    }

    @Override
    public Response delete(Long id) {
        salesProposalRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(SalesProposal data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(SalesProposal data) {
//        boolean salesProposalnameExists;
//        if (data.hasId()) {
//            salesProposalnameExists = salesProposalRepository.existsBySalesProposalname(data.getSalesProposalname(), data.getId());
//        } else {
//            salesProposalnameExists = salesProposalRepository.existsBySalesProposalname(data.getSalesProposalname());
//        }
//        return salesProposalnameExists ? "Failed to register. SalesProposal already exists" : null;
        return null;
    }

}

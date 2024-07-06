package com.isdbbros.realestate.controller.data;

import com.isdbbros.realestate.controller.super_classes.CrudController;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.data.SalesProposal;
import com.isdbbros.realestate.service.super_classes.data.SalesProposalService;
import com.isdbbros.realestate.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("sales-proposal/")
public class SalesProposalController implements CrudController<SalesProposal, Long> {
    private final SalesProposalService salesProposalService;

    @Override
    public ResponseEntity<Response> storeData(SalesProposal data) {
        Response response = salesProposalService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<SalesProposal>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<SalesProposal>> response = salesProposalService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<SalesProposal>> getOne(Long id) {
        Response<SalesProposal> response = salesProposalService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = salesProposalService.delete(id);
        return ResponseEntity.ok(response);
    }
}

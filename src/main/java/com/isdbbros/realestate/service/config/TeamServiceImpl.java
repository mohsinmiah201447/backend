package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.TeamRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Team;
import com.isdbbros.realestate.service.super_classes.config.TeamService;
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
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Response storeData(Team data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            teamRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Team>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, teamRepository.findAll(pageable));
    }

    @Override
    public Response<Team> getById(Long id) {
        Team team = teamRepository.findById(id).orElse(new Team());
        return new Response<>(SUCCESS, null, team);
    }

    @Override
    public Response delete(Long id) {
        teamRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Team data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Team data) {
//        boolean teamnameExists;
//        if (data.hasId()) {
//            teamnameExists = teamRepository.existsByTeamname(data.getTeamname(), data.getId());
//        } else {
//            teamnameExists = teamRepository.existsByTeamname(data.getTeamname());
//        }
//        return teamnameExists ? "Failed to register. Team already exists" : null;
        return null;
    }

}

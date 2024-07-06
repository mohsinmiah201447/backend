package com.isdbbros.realestate.service.super_classes.auth;

import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.auth.Role;
import com.isdbbros.realestate.service.super_classes.CrudService;

public interface RoleService extends CrudService<Role, Long> {

    Response storeData(Role data);

}

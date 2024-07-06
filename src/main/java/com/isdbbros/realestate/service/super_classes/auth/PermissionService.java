package com.isdbbros.realestate.service.super_classes.auth;

import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.auth.Permission;
import com.isdbbros.realestate.model.auth.Role;
import com.isdbbros.realestate.service.super_classes.CrudService;

public interface PermissionService extends CrudService<Permission, Long> {

    Response storeData(Permission data);

}

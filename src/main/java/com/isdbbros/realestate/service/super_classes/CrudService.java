package com.isdbbros.realestate.service.super_classes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import com.isdbbros.realestate.dto.Response;

@Transactional
public interface CrudService<E, I> {

    @NonNull
    Response storeData(@NonNull E data);

    @NonNull
    Response<Page<E>> getAll(@NonNull Pageable pageable);

    @NonNull
    Response<E> getById(@NonNull I id);

    @NonNull
    Response delete(@NonNull I id);

    @Nullable
    String validate(@NonNull E data);

    @Nullable
    String checkDuplicate(@NonNull E data);
}
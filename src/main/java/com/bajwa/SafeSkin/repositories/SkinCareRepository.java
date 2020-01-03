package com.bajwa.SafeSkin.repositories;

import com.bajwa.SafeSkin.models.SkinCare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinCareRepository extends CrudRepository<SkinCare, Long> {
}

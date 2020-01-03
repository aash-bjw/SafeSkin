package com.bajwa.SafeSkin.repositories;

import com.bajwa.SafeSkin.models.MakeUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeUpRepository extends CrudRepository<MakeUp, Long> {
}

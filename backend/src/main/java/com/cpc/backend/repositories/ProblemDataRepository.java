package com.cpc.backend.repositories;


import com.cpc.backend.models.ProblemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProblemDataRepository  extends JpaRepository<ProblemData, Long> {
    Optional<ProblemData> findProblemDataById(Long id);


}

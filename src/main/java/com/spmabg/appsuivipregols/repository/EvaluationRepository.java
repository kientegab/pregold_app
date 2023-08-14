package com.spmabg.appsuivipregols.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spmabg.appsuivipregols.entity.Evaluation;

@Repository

public interface EvaluationRepository  extends JpaRepository<Evaluation, Long> {
	

}



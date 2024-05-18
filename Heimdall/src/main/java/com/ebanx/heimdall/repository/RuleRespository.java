package com.ebanx.heimdall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebanx.heimdall.model.Rule;

@Repository
public interface RuleRespository extends JpaRepository<Rule, Long>{

    List<Rule> findByPayeeId(Long payeeId);

}
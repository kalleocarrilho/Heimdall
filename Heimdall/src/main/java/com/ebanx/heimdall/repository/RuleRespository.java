package com.ebanx.heimdall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebanx.heimdall.model.Rule;

@Repository
public abstract class RuleRespository implements JpaRepository<Rule, Long>{

    public abstract List<Rule> findByPayeeId(String payeeId);

}
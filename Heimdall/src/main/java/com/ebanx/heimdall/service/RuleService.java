package com.ebanx.heimdall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebanx.heimdall.model.Rule;
import com.ebanx.heimdall.repository.RuleRespository;
import jakarta.annotation.Resource;

@Service
public class RuleService {

    public List<Rule> listRulesByPayeeId(String payeeId) {
        return respository.findByPayeeId(payeeId);
    }

    @Resource
    private RuleRespository respository;

}

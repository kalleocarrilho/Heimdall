package com.ebanx.heimdall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebanx.heimdall.controller.request.AddRuleRequest;
import com.ebanx.heimdall.model.Rule;
import com.ebanx.heimdall.repository.RuleRespository;
import jakarta.annotation.Resource;

@Service
public class RuleService {

    public List<Rule> listRulesByPayeeId(Long payeeId) {
        return respository.findByPayeeId(payeeId);
    }

    public void createRule(AddRuleRequest request) {
        Rule rule = new Rule(request);
        respository.save(rule);
    }

    @Resource
    private RuleRespository respository;

}

package com.ebanx.heimdall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebanx.heimdall.handlers.CoreBankingHandler;
import com.ebanx.heimdall.handlers.CoreBankingResponse;
import com.ebanx.heimdall.model.Rule;
import jakarta.annotation.Resource;

@Service
public class EvaluationService {

    public void evaluateNotification(Long payeeId) {
        List<Rule> rules = ruleService.listRulesByPayeeId(payeeId);
        CoreBankingResponse handle = coreBankingHandler.handle();
    }

    @Resource
    CoreBankingHandler coreBankingHandler;

    @Resource
    RuleService ruleService;
}

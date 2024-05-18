package com.ebanx.heimdall.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.heimdall.handlers.CoreBankingHandler;
import com.ebanx.heimdall.model.Rule;
import com.ebanx.heimdall.service.EvaluationService;
import com.ebanx.heimdall.service.RuleService;
import jakarta.annotation.Resource;

@RestController
public class HeimdallController {

    @GetMapping("/evaluate")
    public List<Rule> evaluateNotification(Long payeeId) {
        return evaluationService.evaluateNotification(payeeId);
    }

    @GetMapping("/teste")
    public List<Rule> getTeste() {
        return evaluationService.evaluateNotification(1L);
    }

    @Resource
    private EvaluationService evaluationService;

    @Resource
    private CoreBankingHandler coreBankingHandler;

    @Resource
    private RuleService RuleService;

}

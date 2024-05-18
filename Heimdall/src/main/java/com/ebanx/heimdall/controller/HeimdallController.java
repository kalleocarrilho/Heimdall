package com.ebanx.heimdall.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.heimdall.handlers.CoreBankingHandler;
import com.ebanx.heimdall.model.Rule;
import com.ebanx.heimdall.service.RuleService;
import jakarta.annotation.Resource;

@RestController
public class HeimdallController {

    @GetMapping("/evaluate")
    public String evaluateNotification(Long payeeId) {
        List<Rule> rules = RuleService.listRulesByPayeeId(payeeId);

        return rules.stream()
                .map(rule -> rule.getId().toString())
                .collect(Collectors.joining(", "));
    }

    @GetMapping("/teste")
    public void getTeste() {
        coreBankingHandler.handle();
    }

    @Resource
    private CoreBankingHandler coreBankingHandler;

    @Resource
    private RuleService RuleService;

}

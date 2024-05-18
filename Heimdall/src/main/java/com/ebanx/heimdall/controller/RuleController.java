package com.ebanx.heimdall.controller;


import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.heimdall.controller.request.AddRuleRequest;
import com.ebanx.heimdall.service.RuleService;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/rule")
public class RuleController {

    @PostMapping("/create")
    public void createRule(@RequestBody AddRuleRequest request) {
        ruleService.createRule(request);
    }

    @Resource
    private RuleService ruleService;

}

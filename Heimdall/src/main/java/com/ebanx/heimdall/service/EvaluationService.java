package com.ebanx.heimdall.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebanx.heimdall.handlers.CoreBankingHandler;
import com.ebanx.heimdall.handlers.CoreBankingResponse;
import com.ebanx.heimdall.model.Rule;
import jakarta.annotation.Resource;

@Service
public class EvaluationService {

    public List<Rule> evaluateNotification(Long payeeId) {
        CoreBankingResponse handle = coreBankingHandler.handle();

        List<Rule> rules = findRules();

        rules.stream().forEach(rule -> {
            if(!rule.getSecondField().equals(handle.getIsQrCodeSameOwner())) {
                rules.remove(rule);
            }
        });

        return rules;
    }

    private List<Rule> findRules() {
        List<Rule> rules = ruleService.listRulesByPayeeId(1L);

        List<Rule> responseRules = new ArrayList<>();

        for (Rule rule : rules) {
            Field[] fields = CoreBankingResponse.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(rule.getFirstField())) {
                    responseRules.add(rule);
                }
            }
        }
        return responseRules;
    }

    @Resource
    CoreBankingHandler coreBankingHandler;

    @Resource
    RuleService ruleService;
}

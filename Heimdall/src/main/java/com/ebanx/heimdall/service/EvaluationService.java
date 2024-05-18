package com.ebanx.heimdall.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebanx.heimdall.handlers.CoreBankingHandler;
import com.ebanx.heimdall.handlers.CoreBankingResponse;
import com.ebanx.heimdall.handlers.PayHandler;
import com.ebanx.heimdall.handlers.PayResponse;
import com.ebanx.heimdall.model.Rule;
import jakarta.annotation.Resource;

@Service
public class EvaluationService {

    public List<Rule> evaluateNotification(Long payeeId) {
        CoreBankingResponse coreBankingResponse = coreBankingHandler.handle();
        PayResponse payResponse = payHandler.handle();

        List<Rule> rules = findRules(payeeId);
        List<Rule> responseRules = new ArrayList<>();
        rules.forEach(rule -> {
            if (rule.getOperator().equals("==")) {
                if (rule.getSecondField().equals(coreBankingResponse.getIsQrCodeSameOwner())) {
                    responseRules.add(rule);
                }
            } else if (rule.getOperator().equals(">=")){
                Long secondField = Long.valueOf(rule.getSecondField());
                if ((secondField >= payResponse.getSameMerchantTransactions())) {
                    responseRules.add(rule);
                }
            }
        });

        return responseRules;
    }

    private List<Rule> findRules(Long payeeId) {
        List<Rule> rules = ruleService.listRulesByPayeeId(payeeId);
        List<Rule> responseRules = new ArrayList<>();

        for (Rule rule : rules) {
            List<Field> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(CoreBankingResponse.class.getDeclaredFields()));
            fields.addAll(Arrays.asList(PayResponse.class.getDeclaredFields()));
            for (Field field : fields) {
                if (field.getName().equals(rule.getFirstField())) {
                    responseRules.add(rule);
                }
            }
        }
        return responseRules;
    }

    @Resource
    private PayHandler payHandler;

    @Resource
    private CoreBankingHandler coreBankingHandler;

    @Resource
    private RuleService ruleService;
}

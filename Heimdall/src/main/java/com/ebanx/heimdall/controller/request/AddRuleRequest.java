package com.ebanx.heimdall.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddRuleRequest {
    private String firstField;
    private String secondField;
    private String operator;
    private String recommendation;
    private String reason;
    private Long priority;
    private Long payeeId;
}

package com.ebanx.heimdall.model;

import org.springframework.boot.autoconfigure.web.WebProperties;

import com.ebanx.heimdall.controller.request.AddRuleRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rules")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstField;
    private String secondField;
    private String operator;
    private String recommendation;
    private String reason;
    private Long priority;
    private Long payeeId;

    public Rule(AddRuleRequest request) {
        this.firstField = request.getFirstField();
        this.secondField = request.getSecondField();
        this.operator = request.getOperator();
        this.recommendation = request.getRecommendation();
        this.reason = request.getReason();
        this.priority = request.getPriority();
        this.payeeId = request.getPayeeId();
    }

}

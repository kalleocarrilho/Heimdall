package com.ebanx.heimdall.model;

import org.springframework.boot.autoconfigure.web.WebProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstField;
    private String secondField;
    private String operator;
    private String recommendation;
    private String reason;
    private String priority;
    private String payeeId;

}

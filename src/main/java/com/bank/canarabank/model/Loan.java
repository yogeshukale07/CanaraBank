package com.bank.canarabank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name = "loan_number")
    private long loanNumber;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "start_dt")
    private Date startDt;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "total_loan")
    private Double totalLoan;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @Column(name = "outstanding_amount")
    private Double outstandingAmount;
    @Column(name = "created_dt")
    private Date createdDt;


    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalAmount(Double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(Double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }
}

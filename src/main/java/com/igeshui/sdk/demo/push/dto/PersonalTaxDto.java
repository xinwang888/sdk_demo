package com.igeshui.sdk.demo.push.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalTaxDto {
	
	/**
	 * 所属期间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date belongDate;
	
	/**
	 * 所属期间结束
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date belongDateEnd;
	
	/**
	 * 应缴金额
	 */
	private Double taxPayment;
	
	/**
	 * 其他准予扣除项目
	 */
	private Double deduction;
	
	/**
	 * 征收机关
	 */
	private String levyingInstitution;
	
	/**
	 * 缴款单位
	 */
	private String payPerson;
	
	/**
	 * 申报日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date declarationDate;

	public Date getBelongDate() {
		return belongDate;
	}

	public void setBelongDate(Date belongDate) {
		this.belongDate = belongDate;
	}

	public Date getBelongDateEnd() {
		return belongDateEnd;
	}

	public void setBelongDateEnd(Date belongDateEnd) {
		this.belongDateEnd = belongDateEnd;
	}

	public Double getTaxPayment() {
		return taxPayment;
	}

	public void setTaxPayment(Double taxPayment) {
		this.taxPayment = taxPayment;
	}

	public Double getDeduction() {
		return deduction;
	}

	public void setDeduction(Double deduction) {
		this.deduction = deduction;
	}

	public String getLevyingInstitution() {
		return levyingInstitution;
	}

	public void setLevyingInstitution(String levyingInstitution) {
		this.levyingInstitution = levyingInstitution;
	}

	public String getPayPerson() {
		return payPerson;
	}

	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}

	@Override
	public String toString() {
		return "PersonalTaxDto{" +
				"belongDate=" + belongDate +
				", belongDateEnd=" + belongDateEnd +
				", taxPayment=" + taxPayment +
				", deduction=" + deduction +
				", levyingInstitution='" + levyingInstitution + '\'' +
				", payPerson='" + payPerson + '\'' +
				", declarationDate=" + declarationDate +
				'}';
	}
}

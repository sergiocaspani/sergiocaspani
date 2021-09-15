package com.teste.cvc.transfer.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Transfer")
public class TransferData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	int id;
	
	@Column(name = "origin_account")
	int originAccount;
	
	@Column(name = "destiny_account")
	int destinyAccount;
	
	@Column(name = "transfer_value")
	int transferValue;
	
	@Column(name = "tax")
	Double tax;
	 
	@Column(name = "operation_date")	
	LocalDate operationDate;
	  
	@Column(name = "date_tranfer")
	LocalDate dateTranfer;
	
	
	
	private TransferData(int originAccount, int destinyAccount, int transferValue, Double tax, LocalDate operationDate,
			LocalDate dateTranfer) {
		super();
		this.originAccount = originAccount;
		this.destinyAccount = destinyAccount;
		this.transferValue = transferValue;
		this.tax = tax;
		this.operationDate = operationDate;
		this.dateTranfer = dateTranfer;
	}

	public static class TransferDataBuilder {
		private int originAccount;
		private int destinyAccount;
		private int transferValue;
		private Double tax;
		private LocalDate operationDate;
		private LocalDate dateTranfer;
		
		public TransferDataBuilder () {
			
		}
		
		public TransferDataBuilder originAccount(int originAccount) {
			this.originAccount = originAccount;
			return this;
		}
		
		public TransferDataBuilder destinyAccount(int destinyAccount) {
			this.destinyAccount = destinyAccount;
			return this;
		}
		
		public TransferDataBuilder transferValue(int transferValue) {
			this.transferValue = transferValue;
			return this;
		}
		
		public TransferDataBuilder tax(Double tax) {
			this.tax = tax;
			return this;
		}
		
		public TransferDataBuilder operationDate(LocalDate operationDate) {
			this.operationDate = operationDate;
			return this;
		}
		
		public TransferDataBuilder dateTranfer(LocalDate dateTranfer) {
			this.dateTranfer = dateTranfer;
			return this;
		}
		
		public TransferData Builder() {
			return new TransferData(originAccount, destinyAccount, transferValue, tax, operationDate, dateTranfer);
		}
	}
	

}

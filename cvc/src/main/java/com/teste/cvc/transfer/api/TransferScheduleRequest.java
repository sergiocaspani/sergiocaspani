package com.teste.cvc.transfer.api;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TransferScheduleRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("origin_account")
	int originAccount;
	
	@JsonProperty("destiny_account")
	int destinyAccount;
	
	@JsonProperty("transfer_value")
	int transferValue;
	
	@JsonProperty("operation_date")
	LocalDate operationDate;
	

}

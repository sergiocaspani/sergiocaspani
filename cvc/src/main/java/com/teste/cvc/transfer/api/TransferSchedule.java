package com.teste.cvc.transfer.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TransferSchedule {

	@RequestMapping(value="transfer/schedule", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public void transferSchedule(@RequestBody TransferScheduleRequest data);

}

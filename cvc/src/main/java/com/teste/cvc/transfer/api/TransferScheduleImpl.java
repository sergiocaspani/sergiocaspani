package com.teste.cvc.transfer.api;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teste.cvc.transfer.entities.TransferData;
import com.teste.cvc.transfer.repository.ScheduleTransferRepository;

@Component
public class TransferScheduleImpl implements TransferSchedule{

	@Autowired
	ScheduleTransferRepository repository;
	
	@Override
	public void transferSchedule(TransferScheduleRequest data) {
		LocalDate now = LocalDate.now();
		double tax = 0;
		
		try {
			tax = calculateTax(now, data.getOperationDate(), data.getTransferValue());
			TransferData identity =  new TransferData.TransferDataBuilder().
					destinyAccount(data.getDestinyAccount()).
					originAccount(data.getOriginAccount()).
					dateTranfer(now).
					operationDate(data.getOperationDate()).
					tax(tax).
					transferValue(data.getTransferValue()).
					Builder();
			repository.save(identity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}   
		

	}

	private double calculateTax(LocalDate dT, LocalDate dO, double transferValue) throws Exception{
		double tax=0;
		int dayDiff = dO.compareTo(dT);
		
		
       if(dayDiff == 0)
    	   tax = transferValue*0.03+3;
       
       if(dayDiff>=1 && dayDiff<=10)
    	   tax = dayDiff*12;
       
       if(dayDiff>10 && dayDiff<=20)
    	   tax = transferValue*0.08;
       
       if(dayDiff>20 && dayDiff<=30)
    	   tax = transferValue*0.06;
      
       if(dayDiff>30 && dayDiff<=40)
    	   tax = transferValue*0.04;
       
       if(dayDiff>40 && transferValue<100000)
    	   tax = transferValue*0.02;
       
       if(tax == 0)
    	   throw new Exception("Valor de taxa aplicavel não encontrado");
       
       
		return tax;
		
	}
	
}

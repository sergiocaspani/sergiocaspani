package com.teste.cvc.transfer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teste.cvc.transfer.entities.TransferData;

@Repository
public interface ScheduleTransferRepository extends CrudRepository<TransferData, Long>{

}

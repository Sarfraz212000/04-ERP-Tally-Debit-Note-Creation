package com.erp.service;

import java.util.List;

import com.erp.entity.DebitEntity;

public interface DebitService {
	
	public Boolean saveDebit(DebitEntity entity);

	public DebitEntity getById(Integer id);

	public String deleteDebitById(Integer id);

	public DebitEntity updateDebit(DebitEntity entities,Integer debitId);
	
	public List<DebitEntity> findByAllCompanyIdOrUserId(Long companyId,Long userId);
	
	public List<DebitEntity> getAllDebit();


}

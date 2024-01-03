package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.DebitEntity;

public interface DebitRepo  extends JpaRepository<DebitEntity, Integer>{
	
	public List<DebitEntity> findAllByCompanyIdAndUserId(Long companyId,Long userId);

}

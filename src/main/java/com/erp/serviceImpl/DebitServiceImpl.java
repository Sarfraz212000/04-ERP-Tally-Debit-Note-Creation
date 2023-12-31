package com.erp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.entity.DebitEntity;
import com.erp.repository.DebitRepo;
import com.erp.service.DebitService;
@Service
public class DebitServiceImpl implements DebitService{
	
	@Autowired
	private DebitRepo repo;

	@Override
	public Boolean saveDebit(DebitEntity entity) {
		repo.save(entity);
		return true;
	}

	@Override
	public DebitEntity getById(Integer id) {
		Optional<DebitEntity> findById = repo.findById(id);
		
		if (findById.isPresent()) {
			DebitEntity debitEntity = findById.get();
			return debitEntity;
		}
		
		return null;
	}

	@Override
	public String deleteDebitById(Integer id) {
		repo.deleteById(id);
		return "delete successfully";
	}

	@Override
	public DebitEntity updateDebit(DebitEntity entities,Integer debitId) {
		Optional<DebitEntity> optionalDebit = repo.findById(debitId);
		if (optionalDebit.isPresent()) {
			DebitEntity entity = optionalDebit.get();
			BeanUtils.copyProperties(entities, entity);
			entity.setDebitId(debitId);
			return repo.save(entity);
		}
		return null;
		
	}

	@Override
	public List<DebitEntity> findByAllCompanyIdOrUserId(Long companyId, Long userId) {
		return repo.findAllByCompanyIdAndUserId(companyId, userId);
	
	}
	

	@Override
	public List<DebitEntity> getAllDebit() {
		return repo.findAll();
	}

}

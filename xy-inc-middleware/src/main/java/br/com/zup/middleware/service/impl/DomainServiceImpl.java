package br.com.zup.middleware.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.middleware.dao.BaseCrudDAO;
import br.com.zup.middleware.dao.DomainDAO;
import br.com.zup.middleware.service.DomainService;
import br.com.zup.middleware.service.GenericCrudSerivce;
import br.com.zup.model.entities.Domain;
import br.com.zup.model.entities.Field;
import br.com.zup.model.to.DomainDTO;
import br.com.zup.model.to.FieldDTO;

@Service("domainService")
@Transactional
public class DomainServiceImpl extends GenericCrudSerivce<Domain, Integer> implements DomainService {

	@Autowired
	private DomainDAO dao;

	@Override
	public BaseCrudDAO<Domain, Integer> getDAO() {
		return dao;
	}

	public List<DomainDTO> findAllDto() throws ServiceException {

		List<Domain> domains = findAll();
		if (domains == null) {
			return null;
		}

		List<DomainDTO> result = new ArrayList<DomainDTO>();
		DomainDTO dto = null;
		for (Domain item : domains) {

			dto = new DomainDTO(item);
			result.add(dto);
		}

		return result;
	}

	public DomainDTO parseToDTO(Domain domain) throws ServiceException {

		DomainDTO dto = new DomainDTO();

		dto.setId(domain.getId());
		dto.setName(domain.getName());
		dto.setMnemonic(domain.getMnemonic());
		dto.setFields(new HashSet<FieldDTO>());
		FieldDTO fdto = null;
		for (Field field : domain.getFields()) {

			fdto = new FieldDTO();
			fdto.setId(field.getId());
			fdto.setName(field.getName());
			fdto.setType(field.getType());
			dto.getFields().add(fdto);
		}

		return dto;
	}

	public DomainDTO findByPKDto(Integer pk) throws ServiceException {

		Domain domain = findByPK(pk);
		if (domain == null) {
			return null;
		}

		return parseToDTO(domain);
	}

}

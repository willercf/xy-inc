package br.com.zup.middleware.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.middleware.dao.BaseCrudDAO;
import br.com.zup.middleware.dao.RegisterDomainDAO;
import br.com.zup.middleware.service.GenericCrudSerivce;
import br.com.zup.middleware.service.RegisterDomainService;
import br.com.zup.model.entities.RegisterDomain;
import br.com.zup.model.entities.RegisterField;
import br.com.zup.model.to.DomainDTO;
import br.com.zup.model.to.RegisterDomainDTO;
import br.com.zup.model.to.RegisterFieldDTO;

@Service("registerDomainService")
@Transactional
public class RegisterDomainServiceImpl extends GenericCrudSerivce<RegisterDomain, Integer> implements RegisterDomainService {

	@Autowired
	private RegisterDomainDAO dao;

	@Override
	public BaseCrudDAO<RegisterDomain, Integer> getDAO() {
		return dao;
	}

	public List<RegisterDomainDTO> findAllDto() throws ServiceException {

		List<RegisterDomain> registerDomains = findAll();
		if (registerDomains == null) {
			return null;
		}

		List<RegisterDomainDTO> result = new ArrayList<RegisterDomainDTO>();
		RegisterDomainDTO dto = null;
		for (RegisterDomain item : registerDomains) {

			dto = new RegisterDomainDTO(item);
			result.add(dto);
		}

		return result;
	}

	public RegisterDomainDTO findByPKDto(Integer pk) throws ServiceException {

		RegisterDomain registerDomain = findByPK(pk);
		if (registerDomain == null) {
			return null;
		}

		return parseToDTO(registerDomain);
	}

	public RegisterDomainDTO parseToDTO(RegisterDomain registerDomain) throws ServiceException {

		RegisterDomainDTO dto = new RegisterDomainDTO();
		dto.setId(registerDomain.getId());
		dto.setDomain(new DomainDTO(registerDomain.getDomain()));
		dto.setRegisterFields(new HashSet<RegisterFieldDTO>());
		RegisterFieldDTO rfDto = null;
		for (RegisterField registerField : registerDomain.getRegisterFields()) {

			rfDto = new RegisterFieldDTO();
			rfDto.setId(registerField.getId());
			rfDto.setValue(registerField.getValue());
			dto.getRegisterFields().add(rfDto);
		}

		return dto;
	}

}

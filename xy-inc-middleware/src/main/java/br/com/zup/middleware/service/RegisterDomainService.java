package br.com.zup.middleware.service;

import java.util.List;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.model.entities.RegisterDomain;
import br.com.zup.model.to.RegisterDomainDTO;

public interface RegisterDomainService extends BaseCrudService<RegisterDomain, Integer> {

	List<RegisterDomainDTO> findAllDto() throws ServiceException;

	RegisterDomainDTO findByPKDto(Integer pk) throws ServiceException;

	RegisterDomainDTO parseToDTO(RegisterDomain registerDomain) throws ServiceException;
}

package br.com.zup.middleware.service;

import java.util.List;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.model.entities.Domain;
import br.com.zup.model.to.DomainDTO;

public interface DomainService extends BaseCrudService<Domain, Integer> {

	List<DomainDTO> findAllDto() throws ServiceException;

	DomainDTO findByPKDto(Integer pk) throws ServiceException;

	DomainDTO parseToDTO(Domain domain) throws ServiceException;
}

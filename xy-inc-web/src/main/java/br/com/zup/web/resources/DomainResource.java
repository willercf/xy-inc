package br.com.zup.web.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.core.InjectParam;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.middleware.service.DomainService;
import br.com.zup.model.entities.Domain;
import br.com.zup.model.entities.Field;
import br.com.zup.model.to.DomainDTO;

@Path("/domain")
public class DomainResource {

	@InjectParam
	private DomainService domainService;

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DomainDTO> findAll() throws ServiceException {

		return domainService.findAllDto();
	}

	@GET
	@Path("/findByPK/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public DomainDTO findByPK(@PathParam("pk") Integer pk) throws ServiceException {

		return domainService.findByPKDto(pk);
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Integer save(Domain domain) throws ServiceException {

		ensureAssociantion(domain);
		domainService.save(domain);
		return domain.getId();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Domain domain) throws ServiceException {

		ensureAssociantion(domain);
		domainService.update(domain);
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(Domain domain) throws ServiceException {

		ensureAssociantion(domain);
		domainService.delete(domain);
	}

	private void ensureAssociantion(Domain domain) {

		if (domain.getFields() != null) {
			for (Field field : domain.getFields()) {
				if (field.getDomain() == null) {
					field.setDomain(domain);
				}
			}
		}
	}
}

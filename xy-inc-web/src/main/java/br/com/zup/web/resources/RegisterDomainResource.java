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
import br.com.zup.middleware.service.RegisterDomainService;
import br.com.zup.model.entities.RegisterDomain;
import br.com.zup.model.entities.RegisterField;
import br.com.zup.model.to.RegisterDomainDTO;

@Path("/registerDomain")
public class RegisterDomainResource {

	@InjectParam
	private RegisterDomainService registerDomainService;

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RegisterDomainDTO> findAll() throws ServiceException {

		return registerDomainService.findAllDto();
	}

	@GET
	@Path("/findByPK/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterDomainDTO findByPK(@PathParam("pk") Integer pk) throws ServiceException {

		return registerDomainService.findByPKDto(pk);
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Integer save(RegisterDomain registerDomain) throws ServiceException {

		ensureAssociantion(registerDomain);
		registerDomainService.save(registerDomain);
		return registerDomain.getId();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(RegisterDomain registerDomain) throws ServiceException {

		ensureAssociantion(registerDomain);
		registerDomainService.update(registerDomain);
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(RegisterDomain registerDomain) throws ServiceException {

		ensureAssociantion(registerDomain);
		registerDomainService.delete(registerDomain);
	}

	private void ensureAssociantion(RegisterDomain registerDomain) {

		if (registerDomain.getRegisterFields() != null) {
			for (RegisterField rf : registerDomain.getRegisterFields()) {
				if (rf.getRegisterDomain() == null) {
					rf.setRegisterDomain(registerDomain);
				}
			}
		}
	}
}

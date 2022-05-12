package rest;

import java.io.IOException;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;

@Path("/ehdokkaatservice")
public class EhdokkaatService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpalopputyo");
	
	@GET
	@Path("/readehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> readEhdokkaat() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokkaat> list=em.createQuery("select f from Ehdokkaat f").getResultList();		
		em.getTransaction().commit();
		return list;
	}	
	
	@GET
	@Path("/readallehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAllEhdokkaat(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokkaat> list=em.createQuery("select f from Ehdokkaat f").getResultList();		
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/readallehdokkaat.jsp");
		request.setAttribute("ehdokkaatlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@POST
	@Path("/addehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> addEhdokkaat(Ehdokkaat ehdokkaat) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokkaat);//The actual insertion line
		em.getTransaction().commit();
		List<Ehdokkaat> list=readEhdokkaat();		
		return list;
	}
	@PUT
	@Path("/updateehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> updateEhdokkaat(Ehdokkaat ehdokkaat) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat f=em.find(Ehdokkaat.class, ehdokkaat.getEhdokasId());
		if (f!=null) {
			em.merge(ehdokkaat);
		}
		em.getTransaction().commit();
		List<Ehdokkaat> list=readEhdokkaat();		
		return list;
	}	
	@DELETE
	@Path("/deleteehdokkaat/{ehdokasId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> deleteEhdokkaat(@PathParam("ehdokasId") int ehdokasId) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat f=em.find(Ehdokkaat.class, ehdokasId);
		if (f!=null) {
			em.remove(f);
		}
		em.getTransaction().commit();
		List<Ehdokkaat> list=readEhdokkaat();		
		return list;
	}	
	@GET
	@Path("/deleteehdokkaat/{ehdokasId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteEhdokkaatByGet(@PathParam("ehdokasId") int ehdokasId, 
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat f=em.find(Ehdokkaat.class, ehdokasId);
		if (f!=null) {
			em.remove(f);
		}
		em.getTransaction().commit();
		List<Ehdokkaat> list=readEhdokkaat();		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/readehdokkaat.jsp");
		request.setAttribute("ehdokkaatlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@GET
	@Path("/readtoupdateehdokkaat/{ehdokasId}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public void readToUpdateEhdokkaat(@PathParam("ehdokasId") int ehdokasId, @Context HttpServletRequest request,
			@Context HttpServletResponse response

			) {
		
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat f=em.find(Ehdokkaat.class, ehdokasId);
		em.getTransaction().commit();
		
		request.setAttribute("ehdokkaat", f);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ehdokkaattoupdateform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
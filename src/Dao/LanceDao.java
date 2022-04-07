package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.JPAUtil;
import entidades.Lance;

public class LanceDao {
	
	public static void salvar(Lance L) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(L);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Lance L) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(L);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Lance L) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		L = em.find(Lance.class, L.getId());
		em.remove(L);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Lance> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select L from Lance L");
		List<Lance> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	
}

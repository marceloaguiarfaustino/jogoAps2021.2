package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Dao.LanceDao;
import entidades.Lance;

@ManagedBean
public class LanceBean {
	
	private Lance lance = new Lance();
	private List<Lance> lances ;
	
	public String  salvar() {
		LanceDao.salvar(lance);
		lance = new Lance();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Lance Salvo com sucesso!",""));
		return null;
	}
	
	public String editar() {
		LanceDao.editar(lance);
		lance = new Lance();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso,Lance editado com sucesso!", ""));
				
		return null;
	}
	
	public String excluir() {
		try {
		LanceDao.excluir(lance);
		lances.remove(lance);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso! Lance Excluido com sucesso!", ""));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao Excluir o Lance!"));
		}
		return null;
	}
	
	public String gerar() {
		Random r = new Random();
		lance.setV1(r.nextInt(5)+1);
		lance.setV2(r.nextInt(5)+1);
		lance.setV3(r.nextInt(5)+1);
		LanceDao.salvar(lance);
		lance = new Lance();
		return null;
	}
	
	
	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}
	
	public List<Lance> getLances() {
		if(lances == null) {
			lances = LanceDao.listar();
		}		
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	
}

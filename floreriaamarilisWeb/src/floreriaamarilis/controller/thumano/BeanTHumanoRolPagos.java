package floreriaamarilis.controller.thumano;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import floreriaamarilis.controller.JSFUtil;
import floreriaamarilis.model.core.entities.SegUsuario;
import floreriaamarilis.model.core.entities.ThmCargo;
import floreriaamarilis.model.core.entities.ThmEmpleado;
import floreriaamarilis.model.core.entities.ThmRolCabecera;
import floreriaamarilis.model.seguridades.managers.ManagerSeguridades;
import floreriaamarilis.model.thumano.managers.ManagerTHumano;

@Named
@SessionScoped
public class BeanTHumanoRolPagos implements Serializable {
	@EJB
	private ManagerTHumano mTHumano;
	@EJB
	private ManagerSeguridades mSeguridades;
	private List<String> listaPeriodosRol;
	private List<ThmRolCabecera> listaRolCabeceras;
	private String periodoRolSeleccionado;
	
	
	@PostConstruct
	public void inicializar() {
		listaPeriodosRol=new ArrayList<String>();
		listaPeriodosRol.add("202001");
		listaPeriodosRol.add("202002");
		listaPeriodosRol.add("202003");
	}

	public BeanTHumanoRolPagos() {
		
	}
	
	public String actionCargarMenuRoles() {
		listaRolCabeceras=mTHumano.findAllThmRolCabecera();
		return "roles?faces-redirect=true";
	}
	
	public void actionListenerGenerarRolPagos() {
		try {
			mTHumano.generarRolPagos(periodoRolSeleccionado);
			listaRolCabeceras=mTHumano.findAllThmRolCabecera();
			JSFUtil.crearMensajeINFO("Rol generado exitosamente.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<String> getListaPeriodosRol() {
		return listaPeriodosRol;
	}

	public void setListaPeriodosRol(List<String> listaPeriodosRol) {
		this.listaPeriodosRol = listaPeriodosRol;
	}

	public List<ThmRolCabecera> getListaRolCabeceras() {
		return listaRolCabeceras;
	}

	public void setListaRolCabeceras(List<ThmRolCabecera> listaRolCabeceras) {
		this.listaRolCabeceras = listaRolCabeceras;
	}

	public String getPeriodoRolSeleccionado() {
		return periodoRolSeleccionado;
	}

	public void setPeriodoRolSeleccionado(String periodoRolSeleccionado) {
		this.periodoRolSeleccionado = periodoRolSeleccionado;
	}
	
	

}

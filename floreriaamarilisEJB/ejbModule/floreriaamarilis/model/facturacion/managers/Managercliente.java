package floreriaamarilis.model.facturacion.managers;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import floreriaamarilis.model.auditoria.managers.ManagerAuditoria;
import floreriaamarilis.model.core.entities.Cliente;
import floreriaamarilis.model.core.entities.SegAsignacion;
import floreriaamarilis.model.core.entities.SegModulo;
import floreriaamarilis.model.core.entities.SegUsuario;
import floreriaamarilis.model.core.managers.ManagerDAO;
import floreriaamarilis.model.core.utils.ModelUtil;
import floreriaamarilis.model.seguridades.dtos.LoginDTO;

/**
 * Implementa la logica de manejo de usuarios y autenticacion.
 * Funcionalidades principales:
 * <ul>
 * 	<li>Verificacion de credenciales de usuario.</li>
 *  <li>Asignacion de modulos a un usuario.</li>
 * </ul>
 * 
 */
@Stateless
@LocalBean
public class Managercliente {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
    /**
     * Default constructor. 
     */
    public Managercliente() {
        
    }
    /**
     * Funcion de inicializacion de datos de usuarios.
     */
    
    
    
    public List<Cliente> findAllCliente(){
    	return mDAO.findAll(Cliente.class, "apellidos");
    }
    
    public Cliente findByIdCliente(int idCliente) throws Exception {
    	return (Cliente) mDAO.findById(Cliente.class, idCliente);
    }
    
    public void insertarCliente(Cliente nuevoCliente) throws Exception {
    	nuevoCliente.setIdCliente("n/a");
    	mDAO.insertar(nuevoCliente);
    }
    
    public void actualizarCliente(Cliente edicionCliente) throws Exception {
    	Cliente cliente=(Cliente) mDAO.findById(Cliente.class, edicionCliente.getIdCliente());
    	cliente.setNombreCliente(edicionCliente.getNombreCliente());
    	cliente.setApellidoCliente(edicionCliente.getApellidoCliente());
    	cliente.setDireccion(edicionCliente.getDireccion());
    	cliente.setFechaNacimiento(edicionCliente.getFechaNacimiento());
    	cliente.setTelefono(edicionCliente.getTelefono());
    	cliente.setEmail(edicionCliente.getEmail());
    	mDAO.actualizar(cliente);
    }
    
    
    
    public List<SegModulo> findAllModulos(){
    	return mDAO.findAll(SegModulo.class, "nombreModulo");
    }
    
    public SegModulo insertarModulo(SegModulo nuevoModulo) throws Exception {
    	SegModulo modulo=new SegModulo();
    	modulo.setNombreModulo(nuevoModulo.getNombreModulo());
    	modulo.setRutaAcceso(nuevoModulo.getRutaAcceso());
    	mDAO.insertar(modulo);
    	return modulo;
    }
    
    public void eliminarModulo(int idSegModulo) throws Exception {
    	mDAO.eliminar(SegModulo.class, idSegModulo);
    }
    
    public void actualizarModulo(SegModulo edicionModulo) throws Exception {
    	SegModulo modulo=(SegModulo) mDAO.findById(SegModulo.class, edicionModulo.getIdSegModulo());
    	modulo.setNombreModulo(edicionModulo.getNombreModulo());
    	modulo.setRutaAcceso(edicionModulo.getRutaAcceso());
    	mDAO.actualizar(modulo);
    }
    
    public List<SegAsignacion> findAsignacionByUsuario(int idSegUsuario){
    	String consulta="o.segUsuario.idSegUsuario="+idSegUsuario;
		List<SegAsignacion> listaAsignaciones=mDAO.findWhere(SegAsignacion.class, consulta, null);
		return listaAsignaciones;
    }
    
    /**
     * Permite asignar el acceso a un modulo del inventario de sistemas.
     * @param idSegUsuario El codigo del usuario.
     * @param idSegModulo El codigo del modulo que se va a asignar.
     * @throws Exception
     */
    public void asignarModulo(int idSegUsuario,int idSegModulo) throws Exception{
    	//Buscar los objetos primarios:
    	SegUsuario usuario=(SegUsuario)mDAO.findById(SegUsuario.class, idSegUsuario);
    	SegModulo modulo=(SegModulo)mDAO.findById(SegModulo.class, idSegModulo);
    	//crear la relacion:
    	SegAsignacion asignacion=new SegAsignacion();
    	asignacion.setSegModulo(modulo);
    	asignacion.setSegUsuario(usuario);
    	//guardar la asignacion:
    	mDAO.insertar(asignacion);
    	mAuditoria.mostrarLog(getClass(), "asignarModulo", "Modulo "+idSegModulo+" asigando a usuario "+idSegUsuario);
    }
    
    public void eliminarAsignacion(int idSegAsignacion) throws Exception {
    	mDAO.eliminar(SegAsignacion.class, idSegAsignacion);
    }

}

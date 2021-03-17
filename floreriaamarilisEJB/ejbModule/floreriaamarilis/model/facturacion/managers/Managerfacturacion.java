package floreriaamarilis.model.facturacion.managers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import floreriaamarilis.model.core.entities.Cliente;
import floreriaamarilis.model.core.entities.Detalle;
import floreriaamarilis.model.core.entities.Producto;
import floreriaamarilis.model.core.entities.ThmCargo;
import floreriaamarilis.model.core.entities.ThmEmpleado;
import floreriaamarilis.model.core.entities.ThmRolCabecera;
import floreriaamarilis.model.core.entities.ThmRolDetalle;
import floreriaamarilis.model.core.managers.ManagerDAO;
import floreriaamarilis.model.seguridades.managers.ManagerSeguridades;
import floreriaamarilis.model.thumano.dtos.DTOThmCargo;

@Stateless
@LocalBean



public class Managerfacturacion {
	public final static double PORCENTAJE_iva=0.12;
	
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerSeguridades mSeguridades;
	private Managercliente clienteF;
	private Detalle DetalleF;
	
	private Producto productof;
	
    /**
     * Default constructor. 
     */
    public  Managerfacturacion() {
		// TODO Auto-generated constructor stub
	}
        
    
    
    //Productos:
    
    
    public List<Producto> findAllProductos(){
    	return mDAO.findAll(Producto.class);
    }
    
  
      
    
    public Producto insertarProducto(Detalle detallec,int idProducto,int numdetalle) throws Exception {
    	Producto nuevo=new Producto();
    	Random rnd=new Random();
    	nuevo.setCodigoProducto(detallec.getId());//prestamo entre 0 y 100
    	nuevo.setNombreProducto();;//maximo 20 horas extra
    	nuevo.setNombreProducto(null);//160 horas mensuales
    	nuevo.setPrecioProducto(null);//160 horas mensuales
    	nuevo.setproductof.f);.findByIdSegUsuario(idSegUsuario));
    	nuevo.setCodigoProducto(fi(idThmCargo));
    	mDAO.insertar(nuevo);
    	return nuevo;
    }
    
    //Prodcuto:
    public Producto findByIdProducto(int idProducto) throws Exception {
    	return (Producto) mDAO.findById(Producto.class, idProducto);
    }
    
    public List<ThmCargo> findAllThmCargo(){
    	return mDAO.findAll(ThmCargo.class, "nombreCargo");
    }
    
    public List<DTOThmCargo> findAllDTOThmCargo(){
    	List<DTOThmCargo> listaDTO=new ArrayList<DTOThmCargo>();
    	for(ThmCargo cargo:findAllThmCargo()) {
    		DTOThmCargo nuevoDTO=new DTOThmCargo(cargo.getIdThmCargo(), cargo.getNombreCargo(), 
    				cargo.getRemuneracionMensual().doubleValue());
    		listaDTO.add(nuevoDTO);
    	}
    	return listaDTO;
    }
    
    public void insertarCargo() throws Exception {
    	ThmCargo cargo= new ThmCargo();
    	cargo.setNombreCargo("Gissell");
    	cargo.setRemuneracionMensual(new BigDecimal(130458));
    	mDAO.insertar(cargo);
    }
    
    //ROL DE PAGOS:
    
    public List<ThmRolCabecera> findAllThmRolCabecera(){
    	return mDAO.findAll(ThmRolCabecera.class);
    }
    
    public void generarRolPagos(String periodoRol) throws Exception{
    	//Iteramos la lista de empleados:
    	List<ThmEmpleado> listaEmpleados=findAllThmEmpleado();
    	if(listaEmpleados.size()==0)
    		throw new Exception("No existen empleados registrados.");
    	for(ThmEmpleado empleado:listaEmpleados) {
    		//por cada empleado se genera la cabecera del rol:
    		ThmRolCabecera cab=new ThmRolCabecera();
    		cab.setHorasExtras(empleado.getHorasExtra());
    		cab.setHorasTrabajadas(empleado.getHorasTrabajadas());
    		cab.setNombreCargo(empleado.getThmCargo().getNombreCargo());
    		cab.setPeriodoRol(periodoRol);
    		cab.setThmEmpleado(empleado);
    		//generar el detalle de cada rol cabecera:
    		generarDetalleRolPagos(cab, empleado);
    		mDAO.insertar(cab);
    	}
    }
    
    private void generarDetalleRolPagos(ThmRolCabecera cab,ThmEmpleado emp) {
    	List<ThmRolDetalle> detalles= new ArrayList<ThmRolDetalle>();
    	double subtotal=0;
    	double total=0;
		
    	ThmRolDetalle det=new ThmRolDetalle();
		det.setDescripcion("Sueldo");
		det.setOrden(1);
		det.setThmRolCabecera(cab);
		det.setTipoDetalle("IN");
		det.setValor(emp.getThmCargo().getRemuneracionMensual());
		detalles.add(det);
		subtotal+=det.getValor().doubleValue();
		
		det=new ThmRolDetalle();
		det.setDescripcion("Horas extras");
		det.setOrden(2);
		det.setThmRolCabecera(cab);
		det.setTipoDetalle("IN");
		det.setValor(new BigDecimal(emp.getHorasExtra()*emp.getThmCargo().getRemuneracionMensual().doubleValue()/emp.getHorasTrabajadas()*INCREMENTO_HEXTRA));
		detalles.add(det);
		subtotal+=det.getValor().doubleValue();
		
		cab.setSubtotalIngresos(new BigDecimal(subtotal));
		subtotal=0;
		
		det=new ThmRolDetalle();
		det.setDescripcion("Décimo 3er sueldo");
		det.setOrden(3);
		det.setThmRolCabecera(cab);
		det.setTipoDetalle("IA");
		det.setValor(new BigDecimal(emp.getThmCargo().getRemuneracionMensual().doubleValue()/12));
		detalles.add(det);
		subtotal+=det.getValor().doubleValue();
		
		det=new ThmRolDetalle();
		det.setDescripcion("Fondos de reserva");
		det.setOrden(4);
		det.setThmRolCabecera(cab);
		det.setTipoDetalle("IA");
		det.setValor(new BigDecimal(emp.getThmCargo().getRemuneracionMensual().doubleValue()*PORCENTAJE_FONDOS_RESERVA));
		detalles.add(det);
		subtotal+=det.getValor().doubleValue();
		
		cab.setSubtotalIngresosAdicionales(new BigDecimal(subtotal));
		subtotal=0;
		
		det=new ThmRolDetalle();
		det.setDescripcion("Aporte IESS");
		det.setOrden(5);
		det.setThmRolCabecera(cab);
		det.setTipoDetalle("EG");
		det.setValor(new BigDecimal(cab.getSubtotalIngresos().doubleValue()*PORCENTAJE_IESS));
		detalles.add(det);
		subtotal+=det.getValor().doubleValue();
		
		det=new ThmRolDetalle();
		det.setDescripcion("Préstamos");
		det.setOrden(6);
		det.setThmRolCabecera(cab);
		det.setTipoDetalle("EG");
		det.setValor(emp.getCuotaPrestamo());
		detalles.add(det);
		subtotal+=det.getValor().doubleValue();
		
		cab.setSubtotalEgresos(new BigDecimal(subtotal));
		subtotal=0;
		
		total=cab.getSubtotalIngresos().doubleValue()+cab.getSubtotalIngresosAdicionales().doubleValue()-cab.getSubtotalEgresos().doubleValue();
		cab.setTotal(new BigDecimal(total));
		
		cab.setThmRolDetalles(detalles);
    }
    
	
}

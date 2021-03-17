package floreriaamarilis.model.thumano.dtos;

import java.math.BigDecimal;



public class DTOThmEmpleado {
	
	private String apellido;
	private String nombre;
	private String correo;
	private int idThmCargo;
	private String nombreCargo;
	private double remuneracionMensual;
	private String periodoRol; 
	private BigDecimal subtotalIngresos;
	private BigDecimal subtotalIngresosAdicionales;
	private BigDecimal subtotalEgresos;
	private BigDecimal total;
	
	
	
	
	
	public DTOThmEmpleado(String apellido, String nombre, String correo, int idThmCargo, String nombreCargo,
			double remuneracionMensual, String periodoRol, BigDecimal subtotalIngresos,
			BigDecimal subtotalIngresosAdicionales, BigDecimal subtotalEgresos, BigDecimal total) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.correo = correo;
		this.idThmCargo = idThmCargo;
		this.nombreCargo = nombreCargo;
		this.remuneracionMensual = remuneracionMensual;
		this.periodoRol = periodoRol;
		this.subtotalIngresos = subtotalIngresos;
		this.subtotalIngresosAdicionales = subtotalIngresosAdicionales;
		this.subtotalEgresos = subtotalEgresos;
		this.total = total;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getIdThmCargo() {
		return idThmCargo;
	}
	public void setIdThmCargo(int idThmCargo) {
		this.idThmCargo = idThmCargo;
	}
	public String getNombreCargo() {
		return nombreCargo;
	}
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	public double getRemuneracionMensual() {
		return remuneracionMensual;
	}
	public void setRemuneracionMensual(double remuneracionMensual) {
		this.remuneracionMensual = remuneracionMensual;
	}
	public String getPeriodoRol() {
		return periodoRol;
	}
	public void setPeriodoRol(String periodoRol) {
		this.periodoRol = periodoRol;
	}
	public BigDecimal getSubtotalIngresos() {
		return subtotalIngresos;
	}
	public void setSubtotalIngresos(BigDecimal subtotalIngresos) {
		this.subtotalIngresos = subtotalIngresos;
	}
	public BigDecimal getSubtotalIngresosAdicionales() {
		return subtotalIngresosAdicionales;
	}
	public void setSubtotalIngresosAdicionales(BigDecimal subtotalIngresosAdicionales) {
		this.subtotalIngresosAdicionales = subtotalIngresosAdicionales;
	}
	public BigDecimal getSubtotalEgresos() {
		return subtotalEgresos;
	}
	public void setSubtotalEgresos(BigDecimal subtotalEgresos) {
		this.subtotalEgresos = subtotalEgresos;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
	
	
	
	
	
	
}

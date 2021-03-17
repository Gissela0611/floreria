package floreriaamarilis.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the thm_rol_cabecera database table.
 * 
 */
@Entity
@Table(name="thm_rol_cabecera")
@NamedQuery(name="ThmRolCabecera.findAll", query="SELECT t FROM ThmRolCabecera t")
public class ThmRolCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_thm_rol_cabecera")
	private Integer idThmRolCabecera;

	@Column(name="horas_extras")
	private Integer horasExtras;

	@Column(name="horas_trabajadas")
	private Integer horasTrabajadas;

	@Column(name="nombre_cargo")
	private String nombreCargo;

	@Column(name="periodo_rol")
	private String periodoRol;

	@Column(name="subtotal_egresos")
	private BigDecimal subtotalEgresos;

	@Column(name="subtotal_ingresos")
	private BigDecimal subtotalIngresos;

	@Column(name="subtotal_ingresos_adicionales")
	private BigDecimal subtotalIngresosAdicionales;

	private BigDecimal total;

	//bi-directional many-to-one association to ThmEmpleado
	@ManyToOne
	@JoinColumn(name="id_thm_empleado")
	private ThmEmpleado thmEmpleado;

	//bi-directional many-to-one association to ThmRolDetalle
	@OneToMany(mappedBy="thmRolCabecera")
	private List<ThmRolDetalle> thmRolDetalles;

	public ThmRolCabecera() {
	}

	public Integer getIdThmRolCabecera() {
		return this.idThmRolCabecera;
	}

	public void setIdThmRolCabecera(Integer idThmRolCabecera) {
		this.idThmRolCabecera = idThmRolCabecera;
	}

	public Integer getHorasExtras() {
		return this.horasExtras;
	}

	public void setHorasExtras(Integer horasExtras) {
		this.horasExtras = horasExtras;
	}

	public Integer getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public String getPeriodoRol() {
		return this.periodoRol;
	}

	public void setPeriodoRol(String periodoRol) {
		this.periodoRol = periodoRol;
	}

	public BigDecimal getSubtotalEgresos() {
		return this.subtotalEgresos;
	}

	public void setSubtotalEgresos(BigDecimal subtotalEgresos) {
		this.subtotalEgresos = subtotalEgresos;
	}

	public BigDecimal getSubtotalIngresos() {
		return this.subtotalIngresos;
	}

	public void setSubtotalIngresos(BigDecimal subtotalIngresos) {
		this.subtotalIngresos = subtotalIngresos;
	}

	public BigDecimal getSubtotalIngresosAdicionales() {
		return this.subtotalIngresosAdicionales;
	}

	public void setSubtotalIngresosAdicionales(BigDecimal subtotalIngresosAdicionales) {
		this.subtotalIngresosAdicionales = subtotalIngresosAdicionales;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ThmEmpleado getThmEmpleado() {
		return this.thmEmpleado;
	}

	public void setThmEmpleado(ThmEmpleado thmEmpleado) {
		this.thmEmpleado = thmEmpleado;
	}

	public List<ThmRolDetalle> getThmRolDetalles() {
		return this.thmRolDetalles;
	}

	public void setThmRolDetalles(List<ThmRolDetalle> thmRolDetalles) {
		this.thmRolDetalles = thmRolDetalles;
	}

	public ThmRolDetalle addThmRolDetalle(ThmRolDetalle thmRolDetalle) {
		getThmRolDetalles().add(thmRolDetalle);
		thmRolDetalle.setThmRolCabecera(this);

		return thmRolDetalle;
	}

	public ThmRolDetalle removeThmRolDetalle(ThmRolDetalle thmRolDetalle) {
		getThmRolDetalles().remove(thmRolDetalle);
		thmRolDetalle.setThmRolCabecera(null);

		return thmRolDetalle;
	}

}
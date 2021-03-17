package floreriaamarilis.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the thm_empleado database table.
 * 
 */
@Entity
@Table(name="thm_empleado")
@NamedQuery(name="ThmEmpleado.findAll", query="SELECT t FROM ThmEmpleado t")
public class ThmEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_thm_empleado")
	private Integer idThmEmpleado;

	@Column(name="cuota_prestamo")
	private BigDecimal cuotaPrestamo;

	@Column(name="horas_extra")
	private Integer horasExtra;

	@Column(name="horas_trabajadas")
	private Integer horasTrabajadas;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="id_seg_usuario")
	private SegUsuario segUsuario;

	//bi-directional many-to-one association to ThmCargo
	@ManyToOne
	@JoinColumn(name="id_thm_cargo")
	private ThmCargo thmCargo;

	//bi-directional many-to-one association to ThmRolCabecera
	@OneToMany(mappedBy="thmEmpleado")
	private List<ThmRolCabecera> thmRolCabeceras;

	public ThmEmpleado() {
	}

	public Integer getIdThmEmpleado() {
		return this.idThmEmpleado;
	}

	public void setIdThmEmpleado(Integer idThmEmpleado) {
		this.idThmEmpleado = idThmEmpleado;
	}

	public BigDecimal getCuotaPrestamo() {
		return this.cuotaPrestamo;
	}

	public void setCuotaPrestamo(BigDecimal cuotaPrestamo) {
		this.cuotaPrestamo = cuotaPrestamo;
	}

	public Integer getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(Integer horasExtra) {
		this.horasExtra = horasExtra;
	}

	public Integer getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

	public ThmCargo getThmCargo() {
		return this.thmCargo;
	}

	public void setThmCargo(ThmCargo thmCargo) {
		this.thmCargo = thmCargo;
	}

	public List<ThmRolCabecera> getThmRolCabeceras() {
		return this.thmRolCabeceras;
	}

	public void setThmRolCabeceras(List<ThmRolCabecera> thmRolCabeceras) {
		this.thmRolCabeceras = thmRolCabeceras;
	}

	public ThmRolCabecera addThmRolCabecera(ThmRolCabecera thmRolCabecera) {
		getThmRolCabeceras().add(thmRolCabecera);
		thmRolCabecera.setThmEmpleado(this);

		return thmRolCabecera;
	}

	public ThmRolCabecera removeThmRolCabecera(ThmRolCabecera thmRolCabecera) {
		getThmRolCabeceras().remove(thmRolCabecera);
		thmRolCabecera.setThmEmpleado(null);

		return thmRolCabecera;
	}

}
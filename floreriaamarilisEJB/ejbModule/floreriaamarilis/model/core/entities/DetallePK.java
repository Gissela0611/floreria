package floreriaamarilis.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle database table.
 * 
 */
@Embeddable
public class DetallePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="num_detalle")
	private Integer numDetalle;

	@Column(name="num_factura", insertable=false, updatable=false)
	private Integer numFactura;

	public DetallePK() {
	}
	public Integer getNumDetalle() {
		return this.numDetalle;
	}
	public void setNumDetalle(Integer numDetalle) {
		this.numDetalle = numDetalle;
	}
	public Integer getNumFactura() {
		return this.numFactura;
	}
	public void setNumFactura(Integer numFactura) {
		this.numFactura = numFactura;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePK)) {
			return false;
		}
		DetallePK castOther = (DetallePK)other;
		return 
			this.numDetalle.equals(castOther.numDetalle)
			&& this.numFactura.equals(castOther.numFactura);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numDetalle.hashCode();
		hash = hash * prime + this.numFactura.hashCode();
		
		return hash;
	}
}
package floreriaamarilis.model.facturacion.dto;

public class DTOfacCliente {

	private String apellido;
	private String nombrecli;
	private String direccioncli;
	private String fechanacimientocli;
	private String telefonocli;
	private String emailcli;
	
	
	
	public DTOfacCliente(String apellido, String nombrecli, String direccioncli, String fechanacimientocli,
			String telefonocli, String emailcli) {
		super();
		this.apellido = apellido;
		this.nombrecli = nombrecli;
		this.direccioncli = direccioncli;
		this.fechanacimientocli = fechanacimientocli;
		this.telefonocli = telefonocli;
		this.emailcli = emailcli;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombrecli() {
		return nombrecli;
	}
	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}
	public String getDireccioncli() {
		return direccioncli;
	}
	public void setDireccioncli(String direccioncli) {
		this.direccioncli = direccioncli;
	}
	public String getFechanacimientocli() {
		return fechanacimientocli;
	}
	public void setFechanacimientocli(String fechanacimientocli) {
		this.fechanacimientocli = fechanacimientocli;
	}
	public String getTelefonocli() {
		return telefonocli;
	}
	public void setTelefonocli(String telefonocli) {
		this.telefonocli = telefonocli;
	}
	public String getEmailcli() {
		return emailcli;
	}
	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}
	
	
	
	
	
	
	
}

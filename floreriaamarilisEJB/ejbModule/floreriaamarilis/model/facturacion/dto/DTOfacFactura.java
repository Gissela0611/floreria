package floreriaamarilis.model.facturacion.dto;



public class DTOfacFactura {
	
	private String idCliente;
	private String apellido;
	private String nombrecli;
	private String direccioncli;
	private String telefonocli;
	private String emailcli;
	
	private String fechaFac;
	private int num_factura;
	
	private int num_detalle;
	private String codigo_producto;
	private int cantidad;
	private double precio;
	
	private String codigo_Producto;
	private String nombre_Producto;
	
	
	
	
	
	
	
	
	public DTOfacFactura(String idCliente, String apellido, String nombrecli, String direccioncli, String telefonocli,
			String emailcli, String fechaFac, int num_factura, int num_detalle, String codigo_producto, int cantidad,
			double precio, String codigo_Producto2, String nombre_Producto) {
		super();
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.nombrecli = nombrecli;
		this.direccioncli = direccioncli;
		this.telefonocli = telefonocli;
		this.emailcli = emailcli;
		this.fechaFac = fechaFac;
		this.num_factura = num_factura;
		this.num_detalle = num_detalle;
		this.codigo_producto = codigo_producto;
		this.cantidad = cantidad;
		this.precio = precio;
		codigo_Producto = codigo_Producto2;
		this.nombre_Producto = nombre_Producto;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
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
	public String getFechaFac() {
		return fechaFac;
	}
	public void setFechaFac(String fechaFac) {
		this.fechaFac = fechaFac;
	}
	public int getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(int num_factura) {
		this.num_factura = num_factura;
	}
	public int getNum_detalle() {
		return num_detalle;
	}
	public void setNum_detalle(int num_detalle) {
		this.num_detalle = num_detalle;
	}
	public String getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCodigo_Producto() {
		return codigo_Producto;
	}
	public void setCodigo_Producto(String codigo_Producto) {
		this.codigo_Producto = codigo_Producto;
	}
	public String getNombre_Producto() {
		return nombre_Producto;
	}
	public void setNombre_Producto(String nombre_Producto) {
		this.nombre_Producto = nombre_Producto;
	}
	
	

}

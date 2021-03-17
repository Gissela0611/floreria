package floreriaamarilis.model.thumano.dtos;

public class DTOfacProducto {

	private String codigo_Producto;
	private String nombre_Producto;
	private double precio_Prodcuto;
	
	
	
	
	
	public DTOfacProducto(String codigo_Producto, String nombre_Producto, double precio_Prodcuto) {
		super();
		this.codigo_Producto = codigo_Producto;
		this.nombre_Producto = nombre_Producto;
		this.precio_Prodcuto = precio_Prodcuto;
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
	public double getPrecio_Prodcuto() {
		return precio_Prodcuto;
	}
	public void setPrecio_Prodcuto(double precio_Prodcuto) {
		this.precio_Prodcuto = precio_Prodcuto;
	}
	
	
	
	
}

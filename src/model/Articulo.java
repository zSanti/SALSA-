package model;

public class Articulo {
	private Integer codArticulo;
	private float porcentajeDecuento, precio;
	private String color, temporada;

	// Getters y Setters
		public Integer getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(Integer codArticulo) {
		this.codArticulo = codArticulo;
	}
	public float getPorcentajeDecuento() {
		return porcentajeDecuento;
	}
	public void setPorcentajeDecuento(float porcentajeDecuento) {
		this.porcentajeDecuento = porcentajeDecuento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
}
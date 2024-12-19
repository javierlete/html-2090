package ipartube.modelos;

public class Video {
	private Integer id;
	private String titulo;
	private String descripcion;
	private String url;

	// Source / Generate Constructor using Fields...
	public Video(Integer id, String titulo, String descripcion, String url) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.url = url;
	}

	// Source / Generate Getters and Setters...
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Source / Generate toString()...
	@Override
	public String toString() {
		return "Video [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", url=" + url + "]";
	}
}

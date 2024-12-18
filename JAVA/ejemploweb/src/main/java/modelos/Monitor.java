package modelos;

// Clase
public class Monitor {
	// Variables de instancia
	// Campos
	// Fields
	private Integer id;
	private String marca;
	private String modelo;
	private int diagonalPulgadas;
	private int anchoPixels;
	private int altoPixels;

	// Constructores
	public Monitor(Integer id, String marca, String modelo, int diagonalPulgadas, int anchoPixels, int altoPixels) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setDiagonalPulgadas(diagonalPulgadas);
		setAnchoPixels(anchoPixels);
		setAltoPixels(altoPixels);
	}
	
	// Getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getDiagonalPulgadas() {
		return diagonalPulgadas;
	}

	public void setDiagonalPulgadas(int diagonalPulgadas) {
		if(diagonalPulgadas < 0) {
			throw new IllegalArgumentException("La diagonal debe ser positiva");
		}
		
		this.diagonalPulgadas = diagonalPulgadas;
	}

	public int getAnchoPixels() {
		return anchoPixels;
	}

	public void setAnchoPixels(int anchoPixels) {
		this.anchoPixels = anchoPixels;
	}

	public int getAltoPixels() {
		return altoPixels;
	}

	public void setAltoPixels(int altoPixels) {
		this.altoPixels = altoPixels;
	}

	@Override
	public String toString() {
		return "Monitor [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", diagonalPulgadas="
				+ diagonalPulgadas + ", anchoPixels=" + anchoPixels + ", altoPixels=" + altoPixels + "]";
	}

}

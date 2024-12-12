package pojos;

// Clase
public class Monitor {
	// Variables de instancia
	// Campos
	// Fields
	private String marca;
	private String modelo;
	private int diagonalPulgadas;
	private int anchoPixels;
	private int altoPixels;

	// Constructores
	public Monitor(String marca, String modelo, int diagonalPulgadas, int anchoPixels, int altoPixels) {
		setMarca(marca);
		setModelo(modelo);
		setDiagonalPulgadas(diagonalPulgadas);
		setAnchoPixels(anchoPixels);
		setAltoPixels(altoPixels);
	}
	
	public Monitor(Monitor monitor) {
		// Constructor de copia
		
		this(monitor.marca, monitor.modelo, monitor.diagonalPulgadas, monitor.anchoPixels, monitor.altoPixels);
	}
	
	public Monitor() {
		this("Anónima", "Anónimo", 20, 1920, 1080);
	}
	

	// Getters y setters
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

	// toString
	@Override
	public String toString() {
		return "Monitor [marca=" + marca + ", modelo=" + modelo + ", diagonalPulgadas=" + diagonalPulgadas
				+ ", anchoPixels=" + anchoPixels + ", altoPixels=" + altoPixels + "]";
	}

}

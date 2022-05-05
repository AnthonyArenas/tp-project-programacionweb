package pe.edu.upc.university.model.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clothing", indexes = {@Index(columnList = "id", name = "clothing_index_id")})
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "modelo", length = 100, nullable = false)
	private String modelo;
	
	@Column(name = "categoria", length = 100, nullable = false)
	private String categoria;
	
	
	@Column(name = "precio", length = 100, nullable = false)
	private float precio;


	
	@ManyToOne
	@JoinColumn(name = "list_clothing_id", nullable = true)
	private ListClothing list_clothing;	// career_id
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public float Precio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}

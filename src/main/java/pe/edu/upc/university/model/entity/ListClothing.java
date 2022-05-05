package pe.edu.upc.university.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "list_clothing", indexes = {@Index(columnList = "id", name = "list_clothing_index_id")})
public class ListClothing {
	
	public ListClothing() {
		users = new Users();
		categories = new Categories();
		clothing = new ArrayList<>();
	}
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Clothing> getClothing() {
		return clothing;
	}

	public void setClothing(List<Clothing> clothing) {
		this.clothing = clothing;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "description", length = 200, nullable = true)
	private String description;
	
	@Column(name = "urlToImage", length = 200, nullable = true)
	private String urlToImage;
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	@OneToMany(mappedBy = "list_clothing", cascade = CascadeType.ALL)
	private List<Clothing> clothing ;
	
	@ManyToOne
	@JoinColumn(name = "categories_id", nullable=true)
	private Categories categories;	// career_id
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users users;	// career_id
	

	

	
}

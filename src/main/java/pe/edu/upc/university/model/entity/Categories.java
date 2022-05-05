package pe.edu.upc.university.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name = "categories", indexes = {@Index(columnList = "id", name = "categories_index_id")})
public class Categories {
    public List<ListClothing> getList_clothing() {
		return list_clothing;
	}

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

	public String getTrendRanking() {
		return trendRanking;
	}

	public void setTrendRanking(String trendRanking) {
		this.trendRanking = trendRanking;
	}

	public void setList_clothing(List<ListClothing> list_clothing) {
		this.list_clothing = list_clothing;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	
	@Column(name = "urlToImage", length = 200, nullable = true)
	private String urlToImage;
	
	@Column(name = "trendRanking", nullable = true)
	private String trendRanking;
	
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	private List<ListClothing> list_clothing;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public Categories() {
		list_clothing = new ArrayList<>();
	}
}

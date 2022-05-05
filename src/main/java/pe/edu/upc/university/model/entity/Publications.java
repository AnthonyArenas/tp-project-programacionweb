package pe.edu.upc.university.model.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publications", indexes = {@Index(columnList = "id", name = "publications_index_id")})
public class Publications {
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public ListClothing getListClothing() {
		return listClothing;
	}

	public void setListClothing(ListClothing listClothing) {
		this.listClothing = listClothing;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "datetime", length = 35, nullable = false)
	private String datetime;
	
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id")
	private Users users;	// career_id

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "list_clothing_id", nullable = true)
	private ListClothing listClothing;	// career_id
}

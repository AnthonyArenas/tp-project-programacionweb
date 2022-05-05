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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users", indexes = {@Index(columnList = "id", name = "users_index_id")})
public class Users {
	
	public Users() {
		
		list_clothing = new ArrayList<>();
	}
	
    public List<Publications> getPublications() {
		return publications;
	}

	public void setPublications(List<Publications> publications) {
		this.publications = publications;
	}

	public List<ListClothing> getList_clothings() {
		return list_clothing;
	}

	public void setList_clothings(List<ListClothing> list_clothings) {
		this.list_clothing = list_clothings;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username", length = 40, nullable = false)
	private String username;
	
	@Column(name = "password", length = 40, nullable = false)
	private String password;
	
	@Column(name = "last_name", length = 40, nullable = false)
	private String lastName;
	
	@Column(name = "first_name", length = 40, nullable = false)	
	private String firstName;
	
	@Column(name = "email", length = 40, nullable = false)	
	private String email;
	
	@Column(name = "phone", length = 9, nullable = false)	
	private String phone;
	
	@Column(name = "dni", length = 8, nullable = false)	
	private String dni;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Publications> publications;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<ListClothing> list_clothing;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}

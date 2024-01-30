package copm.api.ECommerce.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String email;
    private String username;
    private String password;
    private FullName name;
    private Address address;
    private String phone;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int Long, String email, String username, String password, FullName name, Address address, String phone) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public FullName getName() {
		return name;
	}

	public void setName(FullName name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}    

	@Embeddable
	public class Address {
	    private String city;
	    private String street;
	    private Integer number;
	    private String zipcode;
	    
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Address(String city, String street, Integer number, String zipcode) {
			super();
			this.city = city;
			this.street = street;
			this.number = number;
			this.zipcode = zipcode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public Integer getNumber() {
			return number;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
	}
}

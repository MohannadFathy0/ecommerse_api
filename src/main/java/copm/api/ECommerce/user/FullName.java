package copm.api.ECommerce.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class FullName {
	private String firstname;
    private String lastname;
    
	public FullName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FullName(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

    
}

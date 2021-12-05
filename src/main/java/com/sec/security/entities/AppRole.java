package com.sec.security.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppRole {
@Id
	private String roleName;


public AppRole() {
}

public AppRole(String roleName) {
	this.roleName = roleName;
}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}

}

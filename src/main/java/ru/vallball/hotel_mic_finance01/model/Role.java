package ru.vallball.hotel_mic_finance01.model;

public enum Role {
	ROLE_MANAGER, ROLE_ADMIN, ROLE_CLIENT, ROLE_FINANCIER;
	
	public String getAuthority() {
		return name();
	}
}

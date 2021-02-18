package ru.vallball.hotel_mic_admin01.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	ROLE_MANAGER, ROLE_ADMIN, ROLE_CLIENT, ROLE_FINANCIER;

	@Override
	public String getAuthority() {
		return name();
	}
}

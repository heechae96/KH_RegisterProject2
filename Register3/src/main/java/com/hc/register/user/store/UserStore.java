package com.hc.register.user.store;

import com.hc.register.user.domain.User;

public interface UserStore {

	public int checkLogin(User user);

}

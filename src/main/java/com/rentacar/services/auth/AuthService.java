package com.rentacar.services.auth;

import com.rentacar.dto.SignupRequest;
import com.rentacar.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}

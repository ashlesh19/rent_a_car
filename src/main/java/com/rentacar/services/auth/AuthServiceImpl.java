package com.rentacar.services.auth;


import com.rentacar.dto.SignupRequest;
import com.rentacar.dto.UserDto;
import com.rentacar.entity.User;
import com.rentacar.repository.UserRepository;
import enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;


    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user = new User();

        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);

        User saveUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(saveUser.getId());

        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}

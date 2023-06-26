package com.example.tienda.auth.service;

import com.example.tienda.auth.dto.AuthenticationRequest;
import com.example.tienda.auth.dto.AuthenticationResponse;
import com.example.tienda.auth.dto.UserRequestDto;
import com.example.tienda.auth.dto.UserResponseDto;
import com.example.tienda.exception.ConflictException;
import com.example.tienda.exception.ForbiddenException;
import com.example.tienda.exception.NotFoundException;
import com.example.tienda.mapper.UserMapper;
import com.example.tienda.model.Role;
import com.example.tienda.model.UserEntity;
import com.example.tienda.repository.RoleRepository;
import com.example.tienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username)
                .orElseThrow(()-> new NotFoundException("User " + username + " not found."));
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role : userEntity.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                roles
        );
    }

    @Transactional()
    public UserResponseDto register(UserRequestDto userRequestDto) throws Exception {
        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new ConflictException("There is already an account with this email " + userRequestDto.getEmail());
        }
        UserEntity userEntity = userMapper.requestDto2UserEntity(userRequestDto);
        userEntity.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER").get();
        userEntity.setRoles(Arrays.asList(role));
        UserEntity result = userRepository.save(userEntity);
        UserResponseDto userResponseDto = userMapper.userEntity2ResponseDto(result);

        return userResponseDto;
    }

    public AuthenticationResponse login(AuthenticationRequest authRequest){
        UserDetails userDetails;
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
            userDetails = (UserDetails) auth.getPrincipal();
        }catch(BadCredentialsException e){
            throw new ForbiddenException("Incorrect username or password");
        }
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }
}

package com.example.ecommerce.mapper;

import com.example.ecommerce.domain.Review;
import com.example.ecommerce.domain.User;
import com.example.ecommerce.dto.RegistrationRequestDto;
import com.example.ecommerce.dto.perfume.PerfumeResponseDto;
import com.example.ecommerce.dto.review.ReviewRequestDto;
import com.example.ecommerce.dto.user.UserRequestDto;
import com.example.ecommerce.dto.user.UserResponseDto;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final PerfumeMapper perfumeMapper;
    private final UserService userService;

    private User convertToEntity(UserRequestDto userRequestDto) {
        return modelMapper.map(userRequestDto, User.class);
    }

    private User convertToEntity(RegistrationRequestDto registrationRequestDto) {
        return modelMapper.map(registrationRequestDto, User.class);
    }

    private Review convertToEntity(ReviewRequestDto reviewRequestDto) {
        return modelMapper.map(reviewRequestDto, Review.class);
    }

    public UserResponseDto convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto findUserById(Long userId) {
        return convertToResponseDto(userService.findUserById(userId));
    }

    public UserResponseDto findUserByEmail(String email) {
        return convertToResponseDto(userService.findUserByEmail(email));
    }

    public List<PerfumeResponseDto> getCart(List<Long> perfumesIds) {
        return perfumeMapper.convertListToResponseDto(userService.getCart(perfumesIds));
    }

    public List<UserResponseDto> findAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto findByPasswordResetCode(String code) {
        return convertToResponseDto(userService.findByPasswordResetCode(code));
    }

    public Map<String, Object> login(String email) {
        return userService.login(email);
    }

    public boolean registerUser(RegistrationRequestDto registrationRequestDto) {
        return userService.registerUser(convertToEntity(registrationRequestDto));
    }

    public boolean activateUser(String code) {
        return userService.activateUser(code);
    }

    public boolean sendPasswordResetCode(String email) {
        return userService.sendPasswordResetCode(email);
    }

    public String passwordReset(String email, String password) {
        return userService.passwordReset(email, password);
    }

    public UserResponseDto updateProfile(String email, UserRequestDto userRequestDto) {
        return convertToResponseDto(userService.updateProfile(email, convertToEntity(userRequestDto)));
    }

    public PerfumeResponseDto addReviewToPerfume(ReviewRequestDto reviewRequestDto, Long perfumeId) {
        return perfumeMapper.convertToResponseDto(userService.addReviewToPerfume(convertToEntity(reviewRequestDto), perfumeId));
    }
}

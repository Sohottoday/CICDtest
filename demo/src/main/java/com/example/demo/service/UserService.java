package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// 모든 사용자 조회
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// ID로 사용자 조회
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RuntimeException("User not found with id: " + id);
		}
	}

	// 새 사용자 저장
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	// 사용자 정보 업데이트
	public User updateUser(Long id, User userDetails) {
		User user = getUserById(id);
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		return userRepository.save(user);
	}

	// 사용자 삭제
	public void deleteUser(Long id) {
		User user = getUserById(id);
		userRepository.delete(user);
	}
}
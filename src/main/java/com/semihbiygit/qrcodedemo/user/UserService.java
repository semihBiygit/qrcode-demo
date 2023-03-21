package com.semihbiygit.qrcodedemo.user;

import com.semihbiygit.qrcodedemo.qrcode.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User student) {
        return userRepository.save(student);
    }

    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        if (userList.size() != 0)
            for (User user : userList) {
                try {
                    QRCodeGenerator.generateQRCode(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return userList;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
    }

}

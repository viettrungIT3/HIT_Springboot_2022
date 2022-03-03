package com.hit.buoi3.controllers;

import com.hit.buoi3.models.Res;
import com.hit.buoi3.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

//    @GetMapping()
////    @ResponseBody
//    public List<User> getListUser() {
////        User user = new User(1, "Trung123", "123");
//        List<User> userList = new ArrayList<>();
//        userList.add(new User(1, "Trung123", "123"));
//        userList.add(new User(2, "Trung123", "123"));
//        userList.add(new User(3, "Trung123", "123"));
//        userList.add(new User(4, "Trung123", "123"));
//        userList.add(new User(5, "Trung123", "123"));
//
//        return userList;
//    }

    @GetMapping()
//    @ResponseBody
    public ResponseEntity<Res> getListUser() {
//        User user = new User(1, "Trung123", "123");
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Trung123", "123"));
        userList.add(new User(2, "Trung123", "123"));
        userList.add(new User(3, "Trung123", "123"));
        userList.add(new User(4, "Trung123", "123"));
        userList.add(new User(5, "Trung123", "123"));

        Res res = new Res("success", userList);
        return ResponseEntity.status(200).body(res);
    }

    // Tạo dữ liệu - gửi dữ liệu quan trọng
    @PostMapping()
    public ResponseEntity<?> postMethod(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user.getUsername());
    }

    // Sửa dữ liệu
    @PatchMapping()
    public ResponseEntity<?> patchMethod() {
        return ResponseEntity.status(200).body("Đây là method patch");
    }

    // Sửa dữ liệu
    @PutMapping()
    public ResponseEntity<?> putMethod() {
        return ResponseEntity.status(200).body("Đây là method put");
    }

    // Sửa dữ liệu
    @DeleteMapping()
    public ResponseEntity<?> deleteMethod() {
        return ResponseEntity.status(200).body("Đây là method delete");
    }
}

package com.example.demo.dto;

import com.example.demo.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
  String uname;
  String email;
  String phone;
  String address;
  String pin;
  Role role;
  String password;

}

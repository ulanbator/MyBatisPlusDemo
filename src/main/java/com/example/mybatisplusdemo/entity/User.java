package com.example.mybatisplusdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;

    private String phoneNumber;

    private int gender;

}

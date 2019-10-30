package com.laoliang.springboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author laoliangliang
 * @date 2019/10/30 13:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;

    private String userName;

    private String phoneNumber;
}

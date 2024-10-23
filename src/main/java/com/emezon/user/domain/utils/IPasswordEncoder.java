package com.emezon.user.domain.utils;

public interface IPasswordEncoder {

    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);

}

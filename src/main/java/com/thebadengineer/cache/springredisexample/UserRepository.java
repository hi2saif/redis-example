package com.thebadengineer.cache.springredisexample;

import java.util.Map;

public interface UserRepository {
    void save(User user);
    Map<String,User> findall();
    User findbyid(String id);
    void update(User user);
    void delete(String id);
}

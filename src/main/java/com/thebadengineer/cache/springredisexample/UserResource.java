package com.thebadengineer.cache.springredisexample;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(id, name, 20000L));
        return userRepository.findbyid(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        userRepository.update(new User(id, name, 50000L));
        return userRepository.findbyid(id);
    }

    @GetMapping("/delete/{id}/{name}")
    public User delete(@PathVariable("id") final String id) {
        userRepository.delete(id);
        return userRepository.findbyid(id);
    }

    @GetMapping("/all/{id}/{name}")
    public User findbyid(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        return userRepository.findbyid(id);
    }

    @GetMapping("/all")
    public Map<String, User> all() {
        return userRepository.findall();
    }
}

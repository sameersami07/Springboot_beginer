package com.samishaik.WebProject.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.samishaik.WebProject.model.User;

@Service
public class UserService {

    private final Map<Integer, User> users = new LinkedHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserService() {
        addUser(new User(0, "Alicia", "Gray", "Female", "alicia.gray@example.com", "https://randomuser.me/api/portraits/women/68.jpg"));
        addUser(new User(0, "Marco", "Stone", "Male", "marco.stone@example.com", "https://randomuser.me/api/portraits/men/32.jpg"));
        addUser(new User(0, "Nina", "Shaw", "Female", "nina.shaw@example.com", "https://randomuser.me/api/portraits/women/44.jpg"));
        addUser(new User(0, "Luke", "Bryant", "Male", "luke.bryant@example.com", "https://randomuser.me/api/portraits/men/77.jpg"));
    }

    private void addUser(User user) {
        int id = nextId.getAndIncrement();
        user.setId(id);
        users.put(id, user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getRandomUser() {
        List<User> list = new ArrayList<>(users.values());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public User createUser(User user) {
        addUser(user);
        return user;
    }

    public User updateUser(int id, User user) {
        User existing = users.get(id);
        if (existing == null) {
            return null;
        }
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public void deleteUser(int id) {
        users.remove(id);
    }
}

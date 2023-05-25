package com.example.demo;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepoTest {
    @Autowired private UserRepo repo;

    @Test
    public void testAddNew(){
        User u = new User();
        u.setUsername("vuong");
        u.setPassword("asdf");
        u.setHobby("yessir");

        User savedUser = repo.save(u);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void TestListAll(){
        Iterable<User> userList = repo.findAll();
        Assertions.assertThat(userList).hasSizeGreaterThan(0);

        userList.forEach(System.out::println);
    }

    @Test
    public void TestUpdate(){
        Long id = 2L;
        Optional<User> u = repo.findById(id);
        User user = u.get();
        user.setHobby("HATE SWIMMING");
        repo.save(user);

        User updatedUser = repo.findById(id).get();
        Assertions.assertThat(updatedUser.getHobby()).isEqualTo("HATE SWIMMING");

    }

    @Test
    public void testGet(){
        Long id = 6L;
        Optional<User> u = repo.findById(id);

        Assertions.assertThat(u).isPresent();
        System.out.println(u.get());
    }

    @Test
    public void testDelete(){
        Long id = 6L;
        repo.deleteById(id);

        Optional<User> u = repo.findById(id);
        Assertions.assertThat(u).isNotPresent();

    }
}

package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends CrudRepository<User, Long> {


}

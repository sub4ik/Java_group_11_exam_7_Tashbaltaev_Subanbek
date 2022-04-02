package com.example.delivery.repository;

import com.example.delivery.entity.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, String> {
    List<Users> findByEmail(String email, Pageable pageable);

    Optional<Users> findByEmailAndId(String email, String subId);

    Optional<Users> findByEmailAndEventId(String email, String eventId);
}

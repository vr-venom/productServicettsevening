package dev.umang.productservicettsevening.inheritanceExample.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TCUserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(Long id);
}

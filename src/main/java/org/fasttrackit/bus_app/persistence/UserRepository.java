package org.fasttrackit.bus_app.persistence;

import org.fasttrackit.bus_app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

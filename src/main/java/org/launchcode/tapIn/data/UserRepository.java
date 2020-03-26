package org.launchcode.tapIn.data;

import org.launchcode.tapIn.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}

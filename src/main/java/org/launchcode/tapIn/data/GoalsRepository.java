package org.launchcode.tapIn.data;

import org.launchcode.tapIn.models.Goal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends CrudRepository<Goal, Integer> {
}

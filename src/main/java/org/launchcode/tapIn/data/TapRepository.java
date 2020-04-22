package org.launchcode.tapIn.data;

import org.launchcode.tapIn.models.Tap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TapRepository extends CrudRepository<Tap, Integer> {
}

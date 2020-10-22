package org.fasttrackit.bus_app.persistence;

import org.fasttrackit.bus_app.domain.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InformationRepository extends JpaRepository<Information, Long> {

    @Query(value = "SELECT information FROM Information information " +
            "WHERE (:partialRoute IS NULL OR information.route LIKE %:partialRoute%)")
    Page<Information>findByOptionalCriteria(String partialRoute, Pageable pageable);
}

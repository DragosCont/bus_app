package org.fasttrackit.bus_app.persistence;

import org.fasttrackit.bus_app.domain.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusLineRepository extends JpaRepository<BusLine, Long> {

}

package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personRoleRepository")
public interface IPersonRoleRepository extends JpaRepository<PersonRole, Long> {
}

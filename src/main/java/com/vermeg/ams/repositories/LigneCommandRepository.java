package com.vermeg.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.vermeg.ams.entities.Command;
import com.vermeg.ams.entities.LigneCommand;
@CrossOrigin(origins = "*")
public interface LigneCommandRepository extends CrudRepository<LigneCommand, Long> {

	@Query(value = "SELECT * FROM ligne_command a WHERE a.command_id = ?1", nativeQuery = true)
	List<LigneCommand> findLigneCommandByCommand(long id);
}

package com.vermeg.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vermeg.ams.entities.Command;
import com.vermeg.ams.entities.LigneCommand;
import com.vermeg.ams.exceptions.ResourceNotFoundException;
import com.vermeg.ams.repositories.BookRepository;
import com.vermeg.ams.repositories.CommandRepository;
import com.vermeg.ams.repositories.LigneCommandRepository;
import com.vermeg.ams.utilities.Calculate;
import com.vermeg.ams.utilities.CommandRequest;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping({ "/commands" })
@CrossOrigin(origins = "*")
public class CommandRestController {
	private final CommandRepository commandRepository;
	private final BookRepository bookRepository;
	private final LigneCommandRepository ligneCommandRepository;

	@Autowired
	public CommandRestController(CommandRepository commandRepository, BookRepository bookRepository,
			LigneCommandRepository ligneCommandRepository) {
		this.commandRepository = commandRepository;
		this.bookRepository = bookRepository;
		this.ligneCommandRepository = ligneCommandRepository;

	}

	@GetMapping("/list")
	public List<Command> getAllCommand() {
		return (List<Command>) commandRepository.findAll();
	}

	@PostMapping("/add")
	public LigneCommand createCommand(@Valid @RequestBody List<CommandRequest> LcommandR) {
		double tp = Calculate.totalPrice(LcommandR);
		Date d = new Date();
		Command cd = commandRepository.save(new Command(d, tp));
		for (CommandRequest bookInCart : LcommandR) {
			bookRepository.findById(bookInCart.getId()).map(book -> {
				LigneCommand LC = new LigneCommand(cd, book, book.getPrice(), bookInCart.getCartQuantity());
				book.setQuantity(book.getQuantity()-bookInCart.getCartQuantity());
				bookRepository.save(book);
				return ligneCommandRepository.save(LC);
			}).orElseThrow(() -> new ResourceNotFoundException("Book Id " + bookInCart.getId() + " not found"));
		}
		return null;
	}

	@PutMapping("/{commandId}")
	public Command updateCommand(@PathVariable Long commandId, @Valid @RequestBody Command commandRequest) {
		return commandRepository.findById(commandId).map(command -> {
			command.setDate(commandRequest.getDate());
			command.setTotalPrice(commandRequest.getTotalPrice());
			return commandRepository.save(command);
		}).orElseThrow(() -> new ResourceNotFoundException("Command Id " + commandId + " not found"));
	}

	@DeleteMapping("/{commandId}")
	public ResponseEntity<?> deleteCommand(@PathVariable Long commandId) {
		return commandRepository.findById(commandId).map(command -> {
			commandRepository.delete(command);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Command Id " + commandId + " not found"));
	}

}

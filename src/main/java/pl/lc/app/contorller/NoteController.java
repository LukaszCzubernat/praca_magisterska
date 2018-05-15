package pl.lc.app.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lc.app.model.Note;
import pl.lc.app.service.NoteService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(method = GET, produces = "application/json")
    public ResponseEntity<List<Note>> listNotes() {
       return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = PUT, consumes = "application/json")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.OK);
    }

}

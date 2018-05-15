package pl.lc.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.lc.app.model.Note;

public interface NoteRepository extends MongoRepository<Note, String> {

}

package pl.lc.app.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Note {

    @Id
    private String id;
    private String userName;
    private String message;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

}

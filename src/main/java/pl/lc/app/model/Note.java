package pl.lc.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note {

    @Id
    @ApiModelProperty(hidden = true)
    private String id;

    @ApiModelProperty(example = "John", position = 1)
    private String userName;

    @ApiModelProperty(example = "Test message", position = 2)
    private String message;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @ApiModelProperty(example = "2018-05-01T10:00:00", position = 3)
    private LocalDateTime creationDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @ApiModelProperty(example = "2018-05-01T10:00:00", position = 4)
    private LocalDateTime updateDate;

    @ApiModelProperty(hidden = true)
    private String additionalInfo;
}

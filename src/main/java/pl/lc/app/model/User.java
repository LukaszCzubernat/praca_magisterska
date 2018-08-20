package pl.lc.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(position = 0)
    @Column(name = "nameName")
    private String userName;

    @Column(name = "fullName")
    @ApiModelProperty(position = 1)
    private String fullName;

}

package com.ToDo.TODO.Entity;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    @Id
    private String id;
@NotBlank(message = "title cannot be null")

    private String title;

private Boolean completed;
private Date InsertAt;

   

}

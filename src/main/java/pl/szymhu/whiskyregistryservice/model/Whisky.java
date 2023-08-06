package pl.szymhu.whiskyregistryservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Document("whisky")
@Getter
@AllArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class Whisky {
    @Id
    private String id;
    private String name;
    private String type;
    private Integer aged;
    private List<String> nose;
    private List<String> taste;
    private List<String> finish;
}

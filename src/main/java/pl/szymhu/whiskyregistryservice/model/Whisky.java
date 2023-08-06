package pl.szymhu.whiskyregistryservice.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("whisky")
@Getter
@AllArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class Whisky {
  @Id private String id;
  private String name;
  private String type;
  private Integer aged;
  private List<String> nose;
  private List<String> taste;
  private List<String> finish;
}

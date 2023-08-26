package pl.szymhu.whiskyregistryservice.controllers;

import java.util.Map;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymhu.whiskyregistryservice.model.Whisky;
import pl.szymhu.whiskyregistryservice.services.WhiskyService;

@RestController
@RequestMapping("/whiskies")
@AllArgsConstructor
public class WhiskyController {

  private WhiskyService whiskyService;

  @GetMapping
  public ResponseEntity<?> getListOfWhiskies() {
    return ResponseEntity.ok(Map.of("items", whiskyService.getAll()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getWhiskyWithId(@PathVariable UUID id) {
    var foundWhisky = whiskyService.getWhiskyWithId(id);
    if (foundWhisky.isPresent())
      return ResponseEntity.ok(foundWhisky.get());
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<?> postWhisky(@RequestBody Whisky requestWhisky) {
    Whisky whisky = requestWhisky.withId(UUID.randomUUID().toString());
    whiskyService.add(whisky);
    return ResponseEntity.status(HttpStatus.CREATED).body(whisky);
  }

  @PostMapping("/generate")
  public ResponseEntity<?> generateWhiskies() {
    whiskyService.generateSomeWhiskies();
    return ResponseEntity.ok().build();
  }
}

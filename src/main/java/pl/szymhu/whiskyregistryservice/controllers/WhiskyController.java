package pl.szymhu.whiskyregistryservice.controllers;

import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymhu.whiskyregistryservice.services.WhiskyService;

@RestController
@RequestMapping("/whisky")
@AllArgsConstructor
public class WhiskyController {

  private WhiskyService whiskyService;

  @GetMapping
  public ResponseEntity<?> getListOfWhiskies() {
    return ResponseEntity.ok(Map.of("items", whiskyService.getAll()));
  }

  @PostMapping
  public ResponseEntity<?> generateWhiskies() {
    whiskyService.generateSomeWhiskies();
    return ResponseEntity.ok().build();
  }
}

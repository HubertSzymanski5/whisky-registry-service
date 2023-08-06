package pl.szymhu.whiskyregistryservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymhu.whiskyregistryservice.model.Whisky;
import pl.szymhu.whiskyregistryservice.repository.WhiskyRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WhiskyService {

    private WhiskyRepository whiskyRepository;

    public List<Whisky> getAll() {
        return whiskyRepository.findAll();
    }

    public void generateSomeWhiskies() {
        whiskyRepository.save(Whisky.builder()
                .id(UUID.randomUUID().toString())
                .name("Redbreast")
                .type("pot-still")
                .aged(12).build());
        whiskyRepository.save(Whisky.builder()
                .id(UUID.randomUUID().toString())
                .name("Green Spot")
                .type("pot-still").build());
        whiskyRepository.save(Whisky.builder()
                .id(UUID.randomUUID().toString())
                .name("Connemara")
                .type("single malt")
                .nose(List.of("peat"))
                .taste(List.of("peat"))
                .finish(List.of("peat")).build());
    }

}

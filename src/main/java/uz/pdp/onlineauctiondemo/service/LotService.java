package uz.pdp.onlineauctiondemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.onlineauctiondemo.entity.Lot;
import uz.pdp.onlineauctiondemo.repository.LotRepsitory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LotService {
    private final LotRepsitory lotRepsitory;
    public Lot getLot(UUID id) {
        Optional<Lot> byId = lotRepsitory.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public List<Lot> getAll() {
        List<Lot> all = lotRepsitory.findAll();
        return all;
    }
}

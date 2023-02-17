package pluralsight.flights.web;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pluralsight.flights.dal.FlightPlanRepository;
import pluralsight.flights.domain.FlightPlan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flights")
public class FlightPlanController {
    private FlightPlanRepository repository;

    public FlightPlanController(FlightPlanRepository repository) {
        this.repository = repository;
    }

    // flights/all
    @GetMapping("all")
    public Flux<FlightPlan> getAll() {
        return repository.findAll();
    }

    // flights/durationBetween?minDuration=60&maxDuration=180
    @GetMapping("durationBetween")
    public Flux<FlightPlan> get(@RequestParam int minDuration, @RequestParam int maxDuration){
        return repository.findFlightPlansByFlightDurationBetween(
                minDuration,
                maxDuration,
                PageRequest.ofSize(100));
    }

    @PostMapping("")
    public Mono<String> insert(@RequestBody FlightPlan flightPlan){
        return this.repository.save(flightPlan).map(FlightPlan::getId);
    }
}

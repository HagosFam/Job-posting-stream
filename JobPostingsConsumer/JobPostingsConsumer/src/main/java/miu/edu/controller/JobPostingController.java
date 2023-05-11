package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.domain.JobPosting;
import miu.edu.service.JobPostingServiceImpl;
import miu.edu.service.messaging.kafkalistener.KafkaMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;


@RestController
@RequestMapping("/jobpostings")
@CrossOrigin("*")
public class JobPostingController {
    @Autowired
    private JobPostingServiceImpl jobPostingService;

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<JobPosting> getLatestJobPostings(){
        return jobPostingService.getLatestJobPosting();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<JobPosting> save(@RequestBody JobPosting jobPosting){
        return jobPostingService.save(jobPosting);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<JobPosting> findAll(){
        //return Flux.zip(Flux.interval(Duration.ofSeconds(1)), jobPostingService.findAll().repeat()).map(Tuple2::getT2);
        return jobPostingService.findAll();//.delayElements(Duration.ofSeconds(5));
    }

    @DeleteMapping
    public Mono<ResponseEntity<Void>> deleteAll(){
        return jobPostingService.deleteAll()
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
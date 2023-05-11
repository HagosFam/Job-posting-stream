package miu.edu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.domain.JobPosting;
import miu.edu.repository.IJobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Date;

@Service
public class JobPostingServiceImpl implements IJobPostingService {
    @Autowired
    private IJobPostingRepository jobPostingRepository;
    private final Sinks.Many<JobPosting> jobPostingSinks = Sinks.many().replay().latest();
    @Transactional
    @Override
    public Mono<JobPosting> save(JobPosting jobPosting) {
        jobPostingSinks.emitNext(jobPosting, Sinks.EmitFailureHandler.FAIL_FAST);
        return jobPostingRepository.save(jobPosting);
    }
    public Flux<JobPosting> getLatestJobPosting() {
        return jobPostingSinks.asFlux();
    }
    @Override
    public Mono<JobPosting> findById(String id) {
        return jobPostingRepository.findById(id);
    }

    @Override
    public Flux<JobPosting> findAll() {
        return jobPostingRepository.findAll();
    }

    @Override
    public Flux<JobPosting> findByDate(Date date) {
        return jobPostingRepository.findByOpenFromGreaterThanEqual(date);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return jobPostingRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return jobPostingRepository.deleteAll();
    }
}

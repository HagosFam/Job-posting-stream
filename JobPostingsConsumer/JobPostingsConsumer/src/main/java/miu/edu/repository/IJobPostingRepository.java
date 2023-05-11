package miu.edu.repository;

import miu.edu.domain.JobPosting;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;

@Repository
public interface IJobPostingRepository extends ReactiveMongoRepository<JobPosting, String> {
    Flux<JobPosting> findByOpenFromGreaterThanEqual(Date date);
}

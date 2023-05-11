package miu.edu.service.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobStatistics {
    private List<JobsByTitle> jobsByTitles;
    private List<JobsBySkill> jobsBySkills;
    private List<JobsBySalaryDistribution> jobsBySalaryDistributions;
    private List<JobsByLocation> jobsByLocations;
    private List<JobsByIndustry> jobsByIndustries;
    private List<JobsByExperience> jobsByExperiences;

    public static class JobStatisticsBuilder {
        private List<JobsByTitle> jobsByTitles;
        private List<JobsBySkill> jobsBySkills;
        private List<JobsBySalaryDistribution> jobsBySalaryDistributions;
        private List<JobsByLocation> jobsByLocations;
        private List<JobsByIndustry> jobsByIndustries;
        private List<JobsByExperience> jobsByExperiences;

        public JobStatisticsBuilder() {
            this.jobsByTitles = new ArrayList<>();
            this.jobsBySkills = new ArrayList<>();
            this.jobsBySalaryDistributions = new ArrayList<>();
            this.jobsByLocations = new ArrayList<>();
            this.jobsByIndustries = new ArrayList<>();
            this.jobsByExperiences = new ArrayList<>();
        }

        public JobStatisticsBuilder withJobsByTitles(List<JobsByTitle> jobsByTitles) {
            this.jobsByTitles = jobsByTitles;
            return this;
        }

        public JobStatisticsBuilder withJobsBySkills(List<JobsBySkill> jobsBySkills) {
            this.jobsBySkills = jobsBySkills;
            return this;
        }

        public JobStatisticsBuilder withJobsBySalaryDistributions(List<JobsBySalaryDistribution> jobsBySalaryDistributions) {
            this.jobsBySalaryDistributions = jobsBySalaryDistributions;
            return this;
        }

        public JobStatisticsBuilder withJobsByLocations(List<JobsByLocation> jobsByLocations) {
            this.jobsByLocations = jobsByLocations;
            return this;
        }

        public JobStatisticsBuilder withJobsByIndustries(List<JobsByIndustry> jobsByIndustries) {
            this.jobsByIndustries = jobsByIndustries;
            return this;
        }

        public JobStatisticsBuilder withJobsByExperiences(List<JobsByExperience> jobsByExperiences) {
            this.jobsByExperiences = jobsByExperiences;
            return this;
        }

        public JobStatistics build() {
            JobStatistics jobStatistics = new JobStatistics();
            jobStatistics.jobsByTitles = this.jobsByTitles;
            jobStatistics.jobsBySkills = this.jobsBySkills;
            jobStatistics.jobsBySalaryDistributions = this.jobsBySalaryDistributions;
            jobStatistics.jobsByLocations = this.jobsByLocations;
            jobStatistics.jobsByIndustries = this.jobsByIndustries;
            jobStatistics.jobsByExperiences = this.jobsByExperiences;
            return jobStatistics;
        }
    }
}
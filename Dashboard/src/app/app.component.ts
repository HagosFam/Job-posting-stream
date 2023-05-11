import { Component, ViewChild, AfterViewInit } from '@angular/core';
import { JobPostingsService } from './job-postings.service';
import { Subscription, merge } from 'rxjs';
import { JobPosting } from './job-postings';
import { JobPostingSummary } from './jobPostingSummary';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements AfterViewInit {
  title = 'Job Postings Dashboard';

  detailTableColumns: string[] = ['company', 'experience', 'industry', 'location', 'skill', 'jobTitle', 'count'];
  groupedTableColumns: string[] = ['key', 'count'];

  resultsLength = 0;
  isFlashing = false;

  groupedViewOpenState = true;
  detailViewOpenState = false;

  sub: Subscription;

  jobPostings = new MatTableDataSource<JobPosting>();
  jobsByCompany = new MatTableDataSource<JobPostingSummary>();
  jobsByExperience = new MatTableDataSource<JobPostingSummary>();
  jobsByIndustry = new MatTableDataSource<JobPostingSummary>();
  jobsByLocation = new MatTableDataSource<JobPostingSummary>();
  jobsBySalaryDistribution = new MatTableDataSource<JobPostingSummary>();
  jobsBySkill = new MatTableDataSource<JobPostingSummary>();
  jobsByJobTitle = new MatTableDataSource<JobPostingSummary>();
  jobsByJobType = new MatTableDataSource<JobPostingSummary>();

  @ViewChild('jobPostingsPaginator') jobPostingsPaginator!: MatPaginator;
  @ViewChild('byExperiencePaginator') byExperiencePaginator!: MatPaginator;
  @ViewChild('byIndustryPaginator') byIndustryPaginator!: MatPaginator;
  @ViewChild('byLocationPaginator') byLocationPaginator!: MatPaginator;
  @ViewChild('bySalaryPaginator') bySalaryPaginator!: MatPaginator;
  @ViewChild('bySkillPaginator') bySkillPaginator!: MatPaginator;
  @ViewChild('byJobTitlePaginator') byJobTitlePaginator!: MatPaginator;
  @ViewChild('byJobTypePaginator') byJobTypePaginator!: MatPaginator;

  constructor(private jobPostingsService: JobPostingsService) {
    this.jobPostings.data = [];
    this.jobsByExperience.data = [];
    this.jobsByIndustry.data = [];
    this.jobsByLocation.data = [];
    this.jobsBySalaryDistribution.data = [];
    this.jobsBySkill.data = [];
    this.jobsByJobTitle.data = [];
    this.jobsByJobType.data = [];

    this.sub = this.jobPostingsService.streamMessages().subscribe({
      next: data => {
        const jobPosting = typeof data === 'string' ? JSON.parse(data) : null;

        this.jobPostings.data = [...this.jobPostings.data, jobPosting].filter(Boolean);

        this.jobsByExperience.data = this.groupByExperience();
        this.jobsByIndustry.data = this.groupByIndustry();
        this.jobsByLocation.data = this.groupByLocation();
        this.jobsBySalaryDistribution.data = this.groupBySalaryDistribution();
        this.jobsBySkill.data = this.groupBySkill();
        this.jobsByJobTitle.data = this.groupByJobTitle();
        this.jobsByJobType.data = this.groupByJobType();

        this.isFlashing = true;
        setTimeout(() => {
          this.isFlashing = false;
        }, 1000);
      },
      error: err => console.error(err)
    });
  }

  ngAfterViewInit() {
    this.jobPostings.paginator = this.jobPostingsPaginator;
    this.jobsByExperience.paginator = this.byExperiencePaginator;
    this.jobsByIndustry.paginator = this.byIndustryPaginator;
    this.jobsByLocation.paginator = this.byLocationPaginator;
    this.jobsBySalaryDistribution.paginator = this.bySalaryPaginator;
    this.jobsBySkill.paginator = this.bySkillPaginator;
    this.jobsByJobTitle.paginator = this.byJobTitlePaginator;
    this.jobsByJobType.paginator = this.byJobTypePaginator;
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.sub && this.sub.unsubscribe();
  }

  groupByExperience(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.experience);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.experience, count: curr.count });
      }
      return acc;
    }, []);
  }

  groupByIndustry(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.industry);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.industry, count: curr.count });
      }
      return acc;
    }, []);
  }

  groupByLocation(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.location);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.location, count: curr.count });
      }
      return acc;
    }, []);
  }

  groupBySalaryDistribution(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.salaryRange);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.salaryRange, count: curr.count });
      }
      return acc;
    }, []);
  }

  groupBySkill(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.skill);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.skill, count: curr.count });
      }
      return acc;
    }, []);
  }

  groupByJobTitle(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.jobTitle);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.jobTitle, count: curr.count });
      }
      return acc;
    }, []);
  }

  groupByJobType(): JobPostingSummary[] {
    return this.jobPostings.data.reduce((acc: JobPostingSummary[], curr: JobPosting) => {
      const existingIndex = acc.findIndex((item: JobPostingSummary) => item.key === curr.jobType);
      if (existingIndex !== -1) {
        acc[existingIndex].count += curr.count;
      } else {
        acc.push({ key: curr.jobType, count: curr.count });
      }
      return acc;
    }, []);
  }
}
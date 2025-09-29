package StaticData;

import java.util.HashMap;
import java.util.Map;

public class ItemsInDropDownListCandidateFlter {

    public static final Map<Integer, String> jobTitlesMap = new HashMap<>();

    static {
        jobTitlesMap.put(0, "-- Select --");
        jobTitlesMap.put(1, "Account Assistant");
        jobTitlesMap.put(2, "Automaton Tester");
        jobTitlesMap.put(3, "Chief Executive Officer");
        jobTitlesMap.put(4, "Chief Financial Officer");
        jobTitlesMap.put(5, "Chief Technical Officer");
        jobTitlesMap.put(6, "Content Specialist");
        jobTitlesMap.put(7, "Customer Success Manager");
        jobTitlesMap.put(8, "Database Administrator");
        jobTitlesMap.put(9, "Finance Manager");
        jobTitlesMap.put(10, "Financial Analyst");
        jobTitlesMap.put(11, "Head of Support");
        jobTitlesMap.put(12, "HR Associate");
        jobTitlesMap.put(13, "HR Manager");
        jobTitlesMap.put(14, "IT Manager");
        jobTitlesMap.put(15, "Network Administrator");
        jobTitlesMap.put(16, "Payroll Administrator");
        jobTitlesMap.put(17, "Pre-Sales Coordinator");
        jobTitlesMap.put(18, "QA Engineer");
        jobTitlesMap.put(19, "QA Lead");
        jobTitlesMap.put(20, "qwer");
        jobTitlesMap.put(21, "rsjsrii");
        jobTitlesMap.put(22, "Sales Representative");
        jobTitlesMap.put(23, "Social Media Marketer");
        jobTitlesMap.put(24, "Software Architect");
        jobTitlesMap.put(25, "Software Engineer");
        jobTitlesMap.put(26, "Support Specialist");
        jobTitlesMap.put(27, "VP - Client Services");
        jobTitlesMap.put(28, "VP - Sales & Marketing");
    }

    public static final Map<Integer, String> VacancyMap = new HashMap<>();

    static {
        VacancyMap.put(0, "-- Select --");
        VacancyMap.put(1, "-- @@@ --");
        VacancyMap.put(2, "-- Junior Account Assistant --");
        VacancyMap.put(3, "-- Payroll Administrator --");
        VacancyMap.put(4, "-- Sales Representative --");
        VacancyMap.put(5, "-- Senior QA Lead --");
        VacancyMap.put(6, "-- Senior Support Specialist --");
        VacancyMap.put(7, "-- Software Engineer --");
        VacancyMap.put(8, "-- test --");
    }
    public static final Map<Integer, String> HiringManagerMap = new HashMap<>();

    static {
        HiringManagerMap.put(0, "-- Select --");
        HiringManagerMap.put(1, "-- Jon@$$$ Jon@$$$ --");
        HiringManagerMap.put(2, "-- Rahul Patil --");
    }

    public static final Map<Integer, String> StatusMap = new HashMap<>();

    static {
        StatusMap.put(0, "-- Select --");
        StatusMap.put(1, "-- Application Initiated --");
        StatusMap.put(2, "-- Shortlisted --");
        StatusMap.put(3, "-- Rejected --");
        StatusMap.put(4, "-- Interview --");
        StatusMap.put(5, "-- Interview Passed --");
        StatusMap.put(6, "-- Interview Failed --");
        StatusMap.put(7, "-- Job Offered --");
        StatusMap.put(8, "-- Offer Declined --");
        StatusMap.put(9, "-- Hired --");

    }

}

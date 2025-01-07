import java.util.Scanner;

public class JobQualificationChecker {

    // this is used to store all the data types
    static class Job {
        private String jobTitle;
        private String requiredSkills;
        private int requiredExperience;
        private String requiredEducationLevel;

        // Constructors
        public Job(String jobTitle, String requiredSkills, int requiredExperience, String requiredEducationLevel) {
            this.jobTitle = jobTitle;
            this.requiredSkills = requiredSkills;
            this.requiredExperience = requiredExperience;
            this.requiredEducationLevel = requiredEducationLevel;
        }

        // Getters and setters
        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getRequiredSkills() {
            return requiredSkills;
        }
        public void setRequiredSkills(String requiredSkills) {
            this.requiredSkills = requiredSkills;
        }

        public int getRequiredExperience() {
            return requiredExperience;
        }

        public void setRequiredExperience(int requiredExperience) {
            this.requiredExperience = requiredExperience;
        }


        public String getRequiredEducationLevel() {
            return requiredEducationLevel;
        }
        public void setRequiredEducationLevel(String requiredEducationLevel) {
            this.requiredEducationLevel = requiredEducationLevel;
        }
    }

    // candidate details
    static class Candidate {
        private String name;
        private String skills;
        private int yearsOfExperience;
        private String educationLevel;

        // Constructor
        public Candidate(String name, String skills, int yearsOfExperience, String educationLevel) {
            this.name = name;
            this.skills = skills;
            this.yearsOfExperience = yearsOfExperience;
            this.educationLevel = educationLevel;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSkills() {
            return skills;
        }

        public void setSkills(String skills) {
            this.skills = skills;
        }

        public int getYearsOfExperience() {
            return yearsOfExperience;
        }

        public void setYearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
        }

        public String getEducationLevel() {
            return educationLevel;
        }

        public void setEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
        }
    }

    // checking if the canditate qualify for the job
    public static boolean checkQualification(Candidate candidate, Job job) {
        boolean hasRequiredSkills = candidate.getSkills().contains(job.getRequiredSkills());
        boolean hasRequiredExperience = candidate.getYearsOfExperience() >= job.getRequiredExperience();
        boolean hasRequiredEducation = candidate.getEducationLevel().equalsIgnoreCase(job.getRequiredEducationLevel());

        return hasRequiredSkills && hasRequiredExperience && hasRequiredEducation;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // here i created a sample job
        Job job = new Job("Software Engineer", "Java, SQL, Spring", 2, "Bachelor's Degree");

        // now user provides me the imput
        System.out.println("Enter your name:");
        String name = scanner.nextLine();


        System.out.println("Enter your skills (comma-separated):");
        String skills = scanner.nextLine();

        System.out.println("Enter your years of experience:");
        int yearsOfExperience = scanner.nextInt();

        scanner.nextLine();  // Consume newline

        System.out.println("Enter your education level:");
        String educationLevel = scanner.nextLine();
        Candidate candidate = new Candidate(name, skills, yearsOfExperience, educationLevel);
        boolean isQualified = checkQualification(candidate, job);

        // Output the result
        if (isQualified) {
            System.out.println(candidate.getName() + " qualifies for the job: " + job.getJobTitle());
        } else {
            System.out.println(candidate.getName() + " does not qualify for the job: " + job.getJobTitle());
        }

        scanner.close();
    }
}
//thank you!!!
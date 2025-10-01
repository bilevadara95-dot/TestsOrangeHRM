package Models;

public class CandidatesTable {

    // Название вакансии
    public String Vacancy;

    // Имя кандидата
    public String Candidate;

    // Имя менеджера по найму персонала
    public String HiringManager;

    // Дата подачи заявления
    public String DateOfApplication;

    // Статус заявки
    public String Status;

    public CandidatesTable(String vacancy,String candidate, String hiringManager, String dateOfApplication, String status){
        Vacancy = vacancy;
        Candidate = candidate;
        HiringManager = hiringManager;
        DateOfApplication = dateOfApplication;
        Status = status;

    }
}

/**
 * Created by Hanouf on 3/23/17.
 */

public class reportCard {

    //store a student’s grades (A,B,C,D,F) for a particular year
    private String StudentName;
    private int ReportYear;
    private char ArtGrade;
    private char HistoryGrade;
    private char EnglishGrade;
    private char ComputerScienceGrade;


    public reportCard(String studentName, int reportYear, char artGrade, char historyGrade, char englishGrade, char computerScienceGrade) {
        StudentName = studentName;
        ReportYear = reportYear;
        ArtGrade = artGrade;
        HistoryGrade = historyGrade;
        EnglishGrade = englishGrade;
        ComputerScienceGrade = computerScienceGrade;
    }

    public static void main(String[] args) throws java.lang.Exception {
        reportCard report = new reportCard("Mohammad", 2017, 'A', 'B', 'C', 'A');
        report.toString();
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getReportYear() {
        return ReportYear;
    }

    public void setReportYear(int reportYear) {
        ReportYear = reportYear;
    }

    public char getArtGrade() {
        return ArtGrade;
    }

    public void setArtGrade(char artGrade) {
        ArtGrade = artGrade;
    }

    public char getHistoryGrade() {
        return HistoryGrade;
    }

    public void setHistoryGrade(char historyGrade) {
        HistoryGrade = historyGrade;
    }

    public char getEnglishGrade() {
        return EnglishGrade;
    }

    public void setEnglishGrade(char englishGrade) {
        EnglishGrade = englishGrade;
    }

    public char getComputerScienceGrade() {
        return ComputerScienceGrade;
    }

    public void setComputerScienceGrade(char computerScienceGrade) {
        ComputerScienceGrade = computerScienceGrade;
    }

    @Override
    public String toString() {
        return "reportCard{" +
                "StudentName='" + StudentName + '\'' +
                ", ReportYear=" + ReportYear +
                ", ArtGrade=" + ArtGrade +
                ", HistoryGrade=" + HistoryGrade +
                ", EnglishGrade=" + EnglishGrade +
                ", ComputerScienceGrade=" + ComputerScienceGrade +
                '}';
    }
}
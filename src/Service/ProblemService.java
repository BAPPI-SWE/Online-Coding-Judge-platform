package services;

import models.Problem;
import java.util.ArrayList;
import java.util.List;

public class ProblemService {
    private List<Problem> problems = new ArrayList<>();

    public void addProblem(String title, String description, String difficulty) {
        problems.add(new Problem(title, description, difficulty));
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public List<Problem> getProblemsByDifficulty(String difficulty) {
        List<Problem> filteredProblems = new ArrayList<>();
        for (Problem problem : problems) {
            if (problem.getDifficulty().equalsIgnoreCase(difficulty)) {
                filteredProblems.add(problem);
            }
        }
        return filteredProblems;
    }

    public void rateProblem(String title, double rating) {
        for (Problem problem : problems) {
            if (problem.getTitle().equalsIgnoreCase(title)) {
                problem.rateProblem(rating);
                break;
            }
        }
    }
}

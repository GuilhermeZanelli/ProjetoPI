package controller;

import dao.ProfessorDAO;
import model.Professor;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ProfessorController {

    private final ProfessorDAO professorDAO;

    public ProfessorController(ProfessorDAO professorDAO) {
        this.professorDAO = Objects.requireNonNull(professorDAO);
    }

    public List<Professor> listarProfessores() throws SQLException {
        return professorDAO.listar();
    }
}
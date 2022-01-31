package lt.codeacademy.Service;

import lt.codeacademy.model.Employee;

public interface GiveLike {
    /**
     * Gives like to employee
     * @param employee to be liked
     */
    public void like(Employee employee);
}

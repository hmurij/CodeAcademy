package lt.codeacademy.Interface;

import lt.codeacademy.model.Employee;

public interface TakeLike {
    /**
     * Takes like from employee and increments local object field
     * and class static field
     */
    public void takeLike(Employee employee);
}

package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Address address = new Address("address1", "city1");
    Employee employee = new Employee("nipuni", 1, 2000, address);

    @Test
    public void testCapitalizeName() {
        String actualName = employee.getCapitalizedName();
        assertEquals("Nipuni", actualName);

    }

}
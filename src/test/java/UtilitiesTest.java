import models.Address;
import org.junit.jupiter.api.Test;
import services.AddressService;
import services.SalaryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtilitiesTest {

    AddressService addressService = mock(AddressService.class);
    SalaryService salaryService = mock(SalaryService.class);

    @Test
    public void testGetAddresses() {

        List< Address > addressList = new ArrayList<>();
        addressList.add(new Address("address1", "city1"));
        addressList.add(new Address("address2", "city2"));
        addressList.add(new Address("address3", "city1"));
        addressList.add(new Address("address4", "city4"));
        addressList.add(new Address("address5", "city5"));

        when(addressService.getAllAddresses()).thenReturn(addressList);

        List < Address > expectedAddress = new ArrayList<>();
        expectedAddress.add(new Address("address1", "city1"));
        expectedAddress.add(new Address("address3", "city1"));
        Utilities utilities = new Utilities();
        List < Address >  actualAddresses = utilities.getAddressByCity(addressService, "city1");
        assertEquals(expectedAddress.size(), actualAddresses.size());

        for (int i = 0; i < actualAddresses.size(); i++) {
            assertEquals(expectedAddress.get(i).getCity(), actualAddresses.get(i).getCity());
        }
    }

    @Test
    public void testGetSalaries() {
        List < Integer > salaries = new ArrayList<>();
        salaries.add(40000);
        salaries.add(45000);
        salaries.add(50000);
        salaries.add(55000);
        salaries.add(60000);
        salaries.add(65000);

        when(salaryService.getSalaries()).thenReturn(salaries);

        Utilities utilities = new Utilities();
        List < Integer > actualSalaries = utilities.getSalariesAbove(salaryService, 50000);

        List < Integer > expectedSalaries = new ArrayList<>();
        expectedSalaries.add(55000);
        expectedSalaries.add(60000);
        expectedSalaries.add(65000);

        assertEquals(expectedSalaries.size(), actualSalaries.size());

        for (int i = 0; i < actualSalaries.size(); i++) {
            assertEquals(expectedSalaries.get(i), actualSalaries.get(i));
        }
    }
}

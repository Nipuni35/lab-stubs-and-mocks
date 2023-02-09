import models.Address;
import services.AddressService;
import services.SalaryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {

    public List<Address> getAddressByCity(AddressService addressService, String city) {
        List < Address > addressList = addressService.getAllAddresses();
        return addressList.stream().filter(address -> address.getCity().equals(city)).collect(Collectors.toList());
    }

    public List<Integer> getSalariesAbove(SalaryService salaryService, int limit) {
        List < Integer > salaryList = salaryService.getSalaries();
        return salaryList.stream().filter(salary -> salary > limit).collect(Collectors.toList());
    }
}

package service;

import dao.PersonDao;
import entity.Address;
import entity.Person;

public class PersonService {
    private final PersonDao personDao = new PersonDao();
    private final AddressService addressService = new AddressService();

    public void save(Person person, Address address) throws Exception {

        if (person.getId() == null) { 
            if (personDao.existsByCpf(person.getCpf())) {
                throw new Exception("CPF já cadastrado.");
            }

            Integer addrId = addressService.insert(address);
            person.setAddressId(addrId);

            personDao.insert(person);

        } else { 
            if (personDao.existsByCpfAndNotId(person.getCpf(), person.getId())) {
                throw new Exception("CPF já cadastrado.");
            }
            
            if (address.getId() == null) {
                address.setId(person.getAddressId());
            }

            addressService.update(address);
            personDao.update(person);
        }
    }
}
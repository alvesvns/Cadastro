package service;

import dao.PersonDao;
import entity.Address;
import entity.Person;

public class PersonService {
    private final PersonDao personDao = new PersonDao();
    private final AddressService addressService = new AddressService();

    public void save(Person person) throws Exception {
        Address address = person.getAddress();

        if (person.isInsert()) { 
            if (existsByCpf(person.getCpf())) {
                throw new Exception("CPF já cadastrado.");
            }

            Integer addrId = addressService.save(address);
            person.setAddress(new Address(addrId));

            personDao.insert(person);

        } else { 
            if (existsByCpfAndNotId(person.getCpf(), person.getId())) {
                throw new Exception("CPF já cadastrado.");
            }
            
            if (address.getId() == null) {
                address.setId(person.getAddress().getId());
            }

            addressService.save(address);
            personDao.update(person);
        }
    }
    public boolean existsByCpf (String cpf) throws Exception {
        return personDao.existsByCpf(cpf);
    }
    public boolean existsByCpfAndNotId(String cpf, Integer id) throws Exception {
        return personDao.existsByCpfAndNotId(cpf, id);
    }
}
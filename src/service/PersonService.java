package service;

import dao.PersonDao;
import entity.Address;
import entity.Person;

public class PersonService {
    private final PersonDao personDao = new PersonDao();
    private final AddressService addressService = new AddressService();

    public void save(Person person) throws Exception {
        
        if (person.isInsert()) {
            processInsertPerson(person);
        } else {
            processEdit(person);
        }
    }
    private boolean existsByCpf (String cpf) throws Exception {
        return personDao.existsByCpf(cpf);
    }
    private boolean existsByCpfAndNotId(String cpf, Integer id) throws Exception {
        return personDao.existsByCpfAndNotId(cpf, id);
    }
    private void processEdit(Person person) throws Exception {
        Address address = person.getAddress();
        
        if (existsByCpfAndNotId(person.getCpf(), person.getId())) {
            throw new Exception("CPF já cadastrado.");
        }

        addressService.save(address);
        personDao.update(person);
    }
    private void processInsertPerson (Person person) throws Exception {
        Address address = person.getAddress();
            
        if (existsByCpf(person.getCpf())){ 
            throw new Exception("CPF já cadastrado.");
        } 

        Integer addrId = addressService.save(address);
        person.setAddress(new Address(addrId));

        personDao.insert(person);
    }
}
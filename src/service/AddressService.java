package service;

import dao.AddressDao;
import entity.Address;

public class AddressService {
    private final AddressDao addressDao = new AddressDao();

    public Integer save(Address address) throws Exception {
        if (address.getId() == null) {
        return addressDao.insert(address);
        }
        addressDao.update(address);
        return address.getId();
    }

    public Address findById(int id) throws Exception {
        return addressDao.findById(id);
    }
}
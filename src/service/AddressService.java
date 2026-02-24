package service;

import dao.AddressDao;
import entity.Address;

public class AddressService {
    private final AddressDao addressDao = new AddressDao();

    public Integer insert(Address address) throws Exception {
        return addressDao.insert(address);
    }

    public void update(Address address) throws Exception {
        addressDao.update(address);
    }

    public Address findById(int id) throws Exception {
        return addressDao.findById(id);
    }
}
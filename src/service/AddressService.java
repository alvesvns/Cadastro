package service;

import dao.AddressDao;
import entity.Address;

public class AddressService {
    private final AddressDao addressDao = new AddressDao();

    public Integer save(Address address) throws Exception {
        if (address.isInsert()) {
        return addressDao.insert(address);
        }
        addressDao.update(address);
        return address.getId();
    }
}
//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._05_customer.CitySelectBean;
//import j16.t03.springboot.m.entity._05_customer.CustomerBean;
//import j16.t03.springboot.m.repository.CustomerDao;
//import j16.t03.springboot.m.service.CustomerService;
//
//
//@Transactional
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//	CustomerDao custDao;
//	
//	@Autowired
//	public void setCustDao(CustomerDao custDao) {
//		this.custDao = custDao;
//	}
//
//	@Override
//	public CustomerBean getCustomerById(int id) {
//	
//		return custDao.getCustomerById(id);
//	}
//
//	@Override
//	public List<CustomerBean> getCustomers() {
//		return custDao.getCustomers();
//	}
//
//	@Override
//	public Object save(CustomerBean bean) {
//		return custDao.save(bean);
//	}
//
//	@Override
//	public void updateCustomer(CustomerBean bean) {
//		custDao.updateCustomer(bean);
//	}
//
//	@Override
//	public void deleteCustomerByPrimaryKey(int key) {
//		custDao.deleteCustomerByPrimaryKey(key);
//	}
//
//	@Override
//	public CustomerBean checkIDPassword(String account, String password) {
//		return custDao.checkIDPassword(account, password);
//
//	}
//
//	@Override
//	public boolean idExists(String account) {
//		return custDao.idExists(account);
//	}
//
//	@Override
//	public CustomerBean get(Integer id) {
//		return custDao.get(id);
//	}
//
//	@Override
//	public void evictMember(CustomerBean customer) {
//		custDao.evictMember(customer);
//	}
//
//	@Override
//	public List<CitySelectBean> querySelect(String groupCity) {
//		return custDao.querySelect(groupCity);
//	}
//}

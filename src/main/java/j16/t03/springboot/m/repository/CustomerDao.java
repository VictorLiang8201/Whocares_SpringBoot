//package j16.t03.springboot.m.repository;
//
//import java.util.List;
//
//import j16.t03.springboot.m.entity._05_customer.CitySelectBean;
//import j16.t03.springboot.m.entity._05_customer.CustomerBean;
//
//
//
//public interface CustomerDao {
//	CustomerBean getCustomerById(int id); 	//依主鍵查詢會員編號
//	List<CustomerBean> getCustomers();		//讀取多筆會員記錄
//	Object save(CustomerBean bean);			//新增一筆會員記錄
//	void updateCustomer(CustomerBean bean); //更新一筆會員記錄
//	void deleteCustomerByPrimaryKey(int key);	 //刪除外鍵"會員購買"、"訂購記錄"
//	public CustomerBean checkIDPassword(String account,String password);	//依主鍵 檢查會員帳號密碼
//	boolean idExists(String account);				//檢查帳號是否存在
//	CustomerBean get(Integer id);				//讀取一筆會員記錄
//	void evictMember(CustomerBean customer);
//	List<CitySelectBean> querySelect(String groupCity);
//}

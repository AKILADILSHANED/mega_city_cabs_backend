package com.mega_city_cabs.mega_city_cabs.Service;
import com.mega_city_cabs.mega_city_cabs.DTO.customerLoginDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.customerRegisterDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.pendingCustomerRegistrationsDTO;
import com.mega_city_cabs.mega_city_cabs.Entity.CustomerRegistrationRequest;
import com.mega_city_cabs.mega_city_cabs.Entity.customer;
import com.mega_city_cabs.mega_city_cabs.ExceptionsHandling.customerNotSavingException;
import com.mega_city_cabs.mega_city_cabs.ExceptionsHandling.userNotFoundException;
import com.mega_city_cabs.mega_city_cabs.ExceptionsHandling.userRegistrationPendingException;
import com.mega_city_cabs.mega_city_cabs.Repository.customerRepo;
import com.mega_city_cabs.mega_city_cabs.Repository.pendingRegistration;
import com.mega_city_cabs.mega_city_cabs.Repository.registrationRequestRepo;
import com.mega_city_cabs.mega_city_cabs.SqlMappers.customerLoginMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class customerServiceIMPL implements customerService{
    @Autowired
    customerRepo customerRepository;
    @Autowired
    registrationRequestRepo request;
    @Autowired
    pendingRegistration registration;
    @Autowired
    HttpSession session;
    @Autowired
    JdbcTemplate template;

    @Override
    public String customerLogin(String email, String password) {
        try{
            String Sql = "SELECT CUS.customer_id, REQ.is_confirmed FROM customer CUS LEFT JOIN registration_requests REQ ON CUS.customer_id = REQ.customer_id WHERE CUS.email = ? AND CUS.password = ?";
            List<customerLoginDTO> customerAvailability = template.query(Sql, new customerLoginMapper(),new Object[]{email, password});
            if(customerAvailability.isEmpty()){
                throw new userNotFoundException("Invalid User Name or Password!");
            }else{
                if(customerAvailability.get(0).getIsConfirmed() == 0){
                    throw new userRegistrationPendingException("Your sign up request still not confirmed. Please wait until it confirmed by admin!");
                }else{
                    session.setAttribute("customer_id", customerAvailability.get(0).getCustomerId());
                    return "1";
                }
            }
        }catch (userNotFoundException | userRegistrationPendingException e){
            return e.getMessage();
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @Transactional
    @Override
    public String customerRegister(customerRegisterDTO registerCustomer) {
        String lastCustomerId;
        String newCustomerId;
        //Generate a new Customer ID.
        try{
            lastCustomerId = customerRepository.getLastCustomerId();
            if(lastCustomerId == null){
                newCustomerId = "CUS0001";
            }else{
                int numericId = Integer.parseInt(lastCustomerId.replace("CUS", ""))+ 1;
                newCustomerId = String.format("CUS%04d", numericId);
            }
        }catch (Exception e){
            return e.getMessage();
        }

        //Register new Customer to the Database.
        try{
            customer registeredCustomer;
            //Checking Null values.
            if(registerCustomer.getFirstName() == null || registerCustomer.getLastName() == null ||
                    registerCustomer.getContact() == null || registerCustomer.getEmail() == null ||
                    registerCustomer.getNic() == null || registerCustomer.getAddress() == null ||
                    registerCustomer.getPassword() == null){
                throw new customerNotSavingException("Unable to save Customer. Please check provided data has null values or try again later!");
            }else{
                registeredCustomer= new customer(
                        newCustomerId,
                        registerCustomer.getFirstName(),
                        registerCustomer.getLastName(),
                        registerCustomer.getContact(),
                        registerCustomer.getEmail(),
                        registerCustomer.getNic(),
                        registerCustomer.getAddress(),
                        registerCustomer.getPassword()
                );
                customerRepository.save(registeredCustomer);
            }

            //Create New Registration Request.
            String lastRequestID;
            String newRequestId;
            lastRequestID = request.lastRequestId();
            if(lastRequestID == null){
                lastRequestID = "REQ000001";
                newRequestId = "REQ000001";
            }else{
                int newNumericId = Integer.parseInt(lastRequestID.replace("REQ", "")) + 1;
                newRequestId = String.format("REQ%06d", newNumericId);
            }
            //Update Registration Request table.
            CustomerRegistrationRequest requestObject = new CustomerRegistrationRequest(
                    newRequestId,
                    LocalDateTime.now(),
                    0,
                    null,
                    registeredCustomer
            );
            request.save(requestObject);
            return "You are successfully registered to our services. You will receive a confirmation message to your registered Email address!";
        }catch (customerNotSavingException e){
            return e.getMessage();
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @Override
    public List<pendingCustomerRegistrationsDTO> pendingRegistrations() {
        return registration.pendingRegistrations();
    }
}

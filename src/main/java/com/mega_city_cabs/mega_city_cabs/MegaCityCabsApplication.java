package com.mega_city_cabs.mega_city_cabs;

import com.mega_city_cabs.mega_city_cabs.Test.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class MegaCityCabsApplication implements CommandLineRunner {

	@Autowired
	customerRegistrationTesting testingObject;
	@Autowired
	customerLoginTesting testCustomerLogin;
	@Autowired
	bookingInitiationTesting testBookingInitiate;
	@Autowired
	cancelBookingTesting testCancelBooking;
	@Autowired
	bookingHistoryTesting bookingHistory;
	@Autowired
	adminLoginTesting adminTesting;
	@Autowired
	displayPendingBookingTesting pendingBooking;
	@Autowired
	bookingApprovalTesting bookingApproveTest;
	@Autowired
	vehicleRegisterTesting testDriverRegister;
	@Autowired
	driverInquiryTesting driverInquiryTest;
	@Autowired
	driverUpdateTesting driverUpdateTest;
	@Autowired
	driverDeleteTesting driverRemoveTest;
	@Autowired
	vehicleAddTesting vehicleAddTest;
	@Autowired
	vehicleInquiryTesting vehicleSearchTest;
	@Autowired
	vehicleUpdateTesting vehicleUpdateTest;
	@Autowired
	deleteVehicleTesting vehicleDeleteTest;
	@Autowired
	billIssueTesting billIssueTest;
	@Autowired
	rePrintBillTesting rePrintTest;
	@Autowired
	deleteBillTesting deleteReceiptTest;
	@Autowired
	customerDetailsReportTesting customerDetailsTest;
	@Autowired
	bookingDetailsReportTesting bookingDetailsTest;
	@Autowired
	receiptDetailsReportTesting receiptDetailsTest;

	public static void main(String[] args) {
		SpringApplication.run(MegaCityCabsApplication.class, args);
	}
	public void testing(){
		System.out.println(testingObject.customerTesting());
	}
	public void testingCustomerLogin(){
		System.out.println(testCustomerLogin.customerLoginTesting());
	}
	public void testingBookingInitiate(){
		System.out.println(testBookingInitiate.bookingInitiateTesting());
	}
	public void testingCancelBooking(){
		System.out.println(testCancelBooking.cancelBookingTesting());
	}
	public void testBookingHistory(){
		bookingHistory.bookingHistoryTest();
	}
	public void testAdminLogin(){
		System.out.println(adminTesting.testAdminLogin());
	}
	public void pendingBookingTest(){
		pendingBooking.bookingHistory();
	}
	public void approveBookingTest(){
		System.out.println(bookingApproveTest.bookingApproval());
	}
	public void driverRegisterTest(){
		System.out.println(testDriverRegister.driverRegisterTesting());
	}
	public void driverInquiryTest(){
		System.out.println(driverInquiryTest.driverInquiry());
	}
	public void driverUpdateTest(){
		System.out.println(driverUpdateTest.driverUpdateTesting());
	}
	public void driverRemoveTest(){
		System.out.println(driverRemoveTest.driverRemovalTest());
	}
	public void vehicleAddTest(){
		System.out.println(vehicleAddTest.registerVehicleTest());
	}
	public void vehicleSearchTest(){
		System.out.println(vehicleSearchTest.inquiryVehicle());
	}
	public void vehicleUpdateTest(){
		System.out.println(vehicleUpdateTest.vehicleUpdateTesting());
	}
	public void deleteUpdateTest(){
		System.out.println(vehicleDeleteTest.vehicleDeleteTesting());
	}
	public void IssueBillTesting(){
		System.out.println(billIssueTest.receiptIssueTesting());
	}
	public void rePrintBillTesting(){
		System.out.println(rePrintTest.rePrintBillTesting());
	}
	public void deleteReceiptTesting(){
		System.out.println(deleteReceiptTest.receiptDeleteTesting());
	}
	public void cutomerDetailsTesting(){
		customerDetailsTest.customerList();
	}
	public void bookingDetailsTesting(){
		bookingDetailsTest.testingBookingDetails();
	}
	public void receiptDetailsTesting(){
		receiptDetailsTest.receiptDetails();
	}
	@Override
	public void run(String... args) throws Exception {
		receiptDetailsTesting();
	}
}

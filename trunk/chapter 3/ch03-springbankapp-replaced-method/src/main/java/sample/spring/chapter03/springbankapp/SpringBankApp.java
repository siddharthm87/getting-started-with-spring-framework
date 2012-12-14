package sample.spring.chapter03.springbankapp;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.spring.chapter03.springbankapp.domain.FixedDepositDetails;
import sample.spring.chapter03.springbankapp.service.CustomerRequestService;
import sample.spring.chapter03.springbankapp.service.FixedDepositService;

public class SpringBankApp {
	private static Logger logger = Logger.getLogger(SpringBankApp.class);

	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");

		FixedDepositService fixedDepositService = (FixedDepositService) context
				.getBean("service");

		fixedDepositService.createFixedDeposit(new FixedDepositDetails(101,
				10000, 60, "someemail@somedomain.com"));

		logger.info("Beginning with accessing CustomerRequestService");
		CustomerRequestService customerRequestService_1 = context
				.getBean(CustomerRequestService.class);
		customerRequestService_1.submitRequest("checkBookRequest",
				"Request to send a 50-leaf check book");
		customerRequestService_1.submitRequest("checkBookRequest",
				"Request to send a 100-leaf check book");
		customerRequestService_1.submitRequest("checkBookRequest",
				"Request to send a 150-leaf check book");
		customerRequestService_1.submitRequest("checkBookRequest",
				"Request to send a 200-leaf check book");
		logger.info("Done with accessing CustomerRequestService");
	}
}
package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();
        displayCountry();
    }

    public static void displayDate() throws Exception {

        LOGGER.info("START");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat", SimpleDateFormat.class);

        Date date = format.parse("31/12/2018");

        LOGGER.debug("Date : {}", date);

        context.close();

        LOGGER.info("END");
    }

    public static void displayCountry() {


    	    LOGGER.info("START");

    	    ClassPathXmlApplicationContext context =
    	            new ClassPathXmlApplicationContext("country.xml");

    	    Country country1 =
    	            context.getBean("country", Country.class);

    	    Country country2 =
    	            context.getBean("country", Country.class);

    	    LOGGER.debug("Country 1 : {}", country1);
    	    LOGGER.debug("Country 2 : {}", country2);

    	    context.close();

    	    LOGGER.info("END");
    	}
    }
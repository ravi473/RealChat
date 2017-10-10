//package com.ea.entity;
//
///**
// * Created by ravikumarpothuganti on 2017-08-27.
// */
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
//
//
//public class MarshallerUnmar {
//
//    private JAXBContext jaxbContext;
//    private Unmarshaller unmarshaller;
//    private Marshaller marshaller;
//
//    @Before
//    public void init(Class c) throws JAXBException {
//        this.jaxbContext = JAXBContext.newInstance(c);
//        this.marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty("eclipselink.media-type", "application/json");
//        this.unmarshaller = jaxbContext.createUnmarshaller();
//        unmarshaller.setProperty("eclipselink.media-type", "application/json");
//    }
//}
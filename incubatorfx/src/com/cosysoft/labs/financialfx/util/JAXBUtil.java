package com.cosysoft.labs.financialfx.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil {

	@SuppressWarnings("unchecked")
	public static <T> T XML2Bean(Class<T> beanClass, String xmlPath)
			throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(beanClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T bean = (T) unmarshaller.unmarshal(Thread.currentThread()
				.getContextClassLoader().getResource(xmlPath));

		return bean;
	}
}

package com.jsp.pharmacy.config;

import java.time.Year;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		String uuid = UUID.randomUUID().toString();
		return Year.now().toString()+uuid;
	}


}

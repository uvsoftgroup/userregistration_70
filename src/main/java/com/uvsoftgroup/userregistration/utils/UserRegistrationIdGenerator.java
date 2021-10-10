package com.uvsoftgroup.userregistration.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistrationIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		Connection connection = sharedSessionContractImplementor.connection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT nextval ('seq_useregistration') as seqId");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getLong("seqId");
			}

		} catch (SQLException e) {
			throw new HibernateException("Unable to generate User Role Id Sequence");
		}
		return null;
	}

}
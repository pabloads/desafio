package br.com.pablo.desafio.utils;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JPAUtilTest {
	
	@Test
    public void getEntityManager() {
		
		EntityManager manager = JPAUtil.getEntityManager();

        assertNotNull(manager);
    }
}

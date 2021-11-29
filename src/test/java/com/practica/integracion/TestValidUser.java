package com.practica.integracion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practica.integracion.DAO.*;
import com.practica.integracion.manager.SystemManager;

@ExtendWith(MockitoExtension.class)
public class TestValidUser {
	@Mock
	private static AuthDAO mockAuthDao;
	@Mock
	private static GenericDAO mockGenericDao;
	
/*	@Test //test de StartRemoteSystem() valido
	public void testStartRemoteSystemWithValidUserAndSystem() throws Exception {
	  User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
	  when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

	  String validId = "12345"; // id valido de sistema
	  ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
	  when(mockGenericDao.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
	  // primero debe ejecutarse la llamada al dao de autenticación
	  // despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
	  InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
	  // instanciamos el manager con los mock creados
	  SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
	  // llamada al api a probar
	  Collection<Object> retorno = manager.startRemoteSystem(validUser.getId(), validId);
	  assertEquals(retorno.toString(), "[uno, dos]");
	  // vemos si se ejecutan las llamadas a los dao, y en el orden correcto
	  ordered.verify(mockAuthDao).getAuthData(validUser.getId());
	  ordered.verify(mockGenericDao).getSomeData(validUser, "where id=" + validId);
	}*/
	
/*	@Test //test de StopRemoteSystem() valido
	public void testStopRemoteSystemWithValidUserAndSystem() throws Exception {
	  User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
	  when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

	  String validId = "12345"; // id valido de sistema
	  ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
	  when(mockGenericDao.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
	  // primero debe ejecutarse la llamada al dao de autenticación
	  // despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
	  InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
	  // instanciamos el manager con los mock creados
	  SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
	  // llamada al api a probar
	  Collection<Object> retorno = manager.stopRemoteSystem(validUser.getId(), validId);
	  assertEquals(retorno.toString(), "[uno, dos]");
	  // vemos si se ejecutan las llamadas a los dao, y en el orden correcto
	  ordered.verify(mockAuthDao).getAuthData(validUser.getId());
	  ordered.verify(mockGenericDao).getSomeData(validUser, "where id=" + validId);
	}
*/

}

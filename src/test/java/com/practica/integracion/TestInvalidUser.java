package com.practica.integracion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practica.integracion.DAO.AuthDAO;
import com.practica.integracion.DAO.GenericDAO;
import com.practica.integracion.DAO.User;
import com.practica.integracion.manager.SystemManager;
import com.practica.integracion.manager.SystemManagerException;
@ExtendWith(MockitoExtension.class)
public class TestInvalidUser {
	@Mock
	private static AuthDAO mockAuthDao;
	@Mock
	private static GenericDAO mockGenericDao;
	
	@Test //test de StartRemoteSystem() invalido
	public void testStartRemoteSystemWithValidUserAndSystem() throws Exception {
	  User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
	  when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(null);

	  String validId = "12345"; // id valido de sistema
	  OperationNotSupportedException Invalido = new OperationNotSupportedException();
	  when(mockGenericDao.getSomeData(null, "where id=" + validId)).thenThrow(Invalido);
	  // primero debe ejecutarse la llamada al dao de autenticación
	  // despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
	  InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
	  // instanciamos el manager con los mock creados
	  SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
	  // llamada al api a probar
	  assertThrows(SystemManagerException.class, ()->{manager.startRemoteSystem(validUser.getId(), validId);});
	  // vemos si se ejecutan las llamadas a los dao, y en el orden correcto
	  ordered.verify(mockAuthDao).getAuthData(validUser.getId());
	  ordered.verify(mockGenericDao).getSomeData(null, "where id=" + validId);
	}
	
	@Test //test de StopRemoteSystem() invalido
	public void testStopRemoteSystemWithValidUserAndSystem() throws Exception {
	  User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
	  when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(null);

	  String validId = "12345"; // id valido de sistema
	  OperationNotSupportedException Invalido = new OperationNotSupportedException();
	  when(mockGenericDao.getSomeData(null, "where id=" + validId)).thenThrow(Invalido);
	  // primero debe ejecutarse la llamada al dao de autenticación
	  // despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
	  InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
	  // instanciamos el manager con los mock creados
	  SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
	  // llamada al api a probar
	  assertThrows(SystemManagerException.class, ()->{manager.stopRemoteSystem(validUser.getId(), validId);});
	  // vemos si se ejecutan las llamadas a los dao, y en el orden correcto
	  ordered.verify(mockAuthDao).getAuthData(validUser.getId());
	  ordered.verify(mockGenericDao).getSomeData(null, "where id=" + validId);
	}
	
@Test public void testAddRemoteSystem() throws Exception {
		
		
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(null);
		String newname = "Luis";
		OperationNotSupportedException Invalido = new OperationNotSupportedException();
		
		 when(mockGenericDao.updateSomeData(null, newname)).thenThrow(Invalido);
		 InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
		 SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
		
		 
		 assertThrows(SystemManagerException.class, ()->{manager.addRemoteSystem(validUser.getId(), newname);});
	}


@Test
public void testDeleteRemoteSystemWithInvalidUserAndSystem() throws Exception {
    User invalidUser = new User("1","Ana","Lopez","Madrid", null);
    when(mockAuthDao.getAuthData(invalidUser.getId())).thenReturn(invalidUser);

    String validId = "12345"; // id valido de sistema
   Mockito.lenient().when(mockGenericDao.deleteSomeData(invalidUser, validId)).thenReturn(false);
    // primero debe ejecutarse la llamada al dao de autenticación
    // despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
    InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
    // instanciamos el manager con los mock creados
    SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
    // llamada al api a probar
    manager.deleteRemoteSystem(invalidUser.getId(), validId);
    // vemos si se ejecutan las llamadas a los dao, y en el orden correcto
    ordered.verify(mockAuthDao).getAuthData(invalidUser.getId());
    ordered.verify(mockGenericDao).deleteSomeData(invalidUser,validId);

    verify(mockGenericDao, times(1)).deleteSomeData(invalidUser,validId);
}


	
}

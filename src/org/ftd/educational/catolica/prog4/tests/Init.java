package org.ftd.educational.catolica.prog4.tests;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.catolica.prog4.daos.ClienteDAO;
import org.ftd.educational.catolica.prog4.daos.UserDAO;
import org.ftd.educational.catolica.prog4.entities.User;
import org.ftd.educational.catolica.prog4.entities.Cliente;

/**
 *
 * @author ftd
 */
public class Init {
    private static final String PERSISTENCE_UNIT_NAME = "persistenciaPU";
    
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        ClienteDAO daoCliente = new ClienteDAO(factory);
//        
//        User user = new User();
//        user.setName("Vincius Miiller");
//        user.setLogin("miiller@gmail.com");
//        user.setPasswd("213yeezygang");
//        dao.create(user);

//        User user = dao.findUser(1L);
//        if (user != null) {
//            user.setName(user.getName() + ".");
//            try {
//                dao.edit(user);
//            } catch (Exception ex) {
//                System.out.println("Não consegui o update do objeto!");
//            }
//        }else{
//            System.out.println("Não encontrei o objeto no banco!");
//        }

//        Cliente cliente = new Cliente();
//        cliente.setName("Vinicius Miiller");
//        cliente.setCpf("111111111111111");
//        daoCliente.create(cliente);

//        Cliente cliente = daoCliente.findCliente(51L);
//        if (cliente != null) {
//            cliente.setName(cliente.getName() + ".");
//            try {
//                daoCliente.edit(cliente);
//            } catch (Exception ex) {
//                System.out.println("Não consegui o update do objeto!");
//            }
//        }else{
//            System.out.println("Não encontrei o objeto no banco!");
//        }
        
        userAuthenticateTest("miiller@gmail.com", "213yeezygang");

//        System.out.println("Contei " + dao.getUserCount() + " User(s).");
//        findAllUser();
//        
//        System.out.println("Contei " + daoCliente.getClienteCount() + " Cliente(s).");
//        findAllCliente();
    }
    
    
    private static void userAuthenticateTest(String login, String passwd){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        
        try{
            User user = dao.findUser(login, passwd);
            System.out.println("Sucesso fella: " + user);
        }catch(Exception e){
            System.out.println("Autenticação falhou: " + login);
        }
    }
    
    private static void findAllUser() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        List<User> lst = dao.findUserEntities();
        for (User o:lst) {
            System.out.println(o);
        }
        
    }
    
    private static void findAllCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClienteDAO dao = new ClienteDAO(factory);
        List<Cliente> lst = dao.findClienteEntities();
        for (Cliente o:lst) {
            System.out.println(o);
        }
        
    }
}

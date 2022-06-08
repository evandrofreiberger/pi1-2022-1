package ifmt.cba.pi1.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaEntityManager {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("UnidadeTccJPA");
    }

    private FabricaEntityManager() {

    }

    public static EntityManager getEntityManager() {
        if(emf == null){
            throw new RuntimeException("Não foi possivel criar o Entity Manager");
        }
        return emf.createEntityManager();
    }
}

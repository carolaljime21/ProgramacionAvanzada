package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class VehiculoController {
    private static EntityManager em = null;
    public VehiculoController() {
        getEm("pu-pa");
    }
    private void getEm(String puName) {
        if(em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(puName);
            em = emf.createEntityManager();
        }
    }
    public boolean addRegistration(vehiculoDTO register) {
        Vehiculo newRegistration = new Vehiculo(register.id(),
                register.placa(),
                register.anioFabricacion(),
                register.nroChasis(),
                register.nroMotor(),
                register.color1(),
                register.color2(),
                register.avaluo(),
                register.prendado());
        em.getTransaction().begin();
        em.persist(newRegistration);
        em.flush();
        em.getTransaction().commit();
        return true;
    }
    public List<vehiculoDTO> getAllVehicles() {
        TypedQuery<vehiculoDTO> qryAll = em.createQuery("""
                SELECT new org.example.vehiculoDTO(v.id, v.placa, v.anioFabricacion, v.nroChasis, v.nroMotor, 
                v.color1, v.color2, v.avaluo, v.prendado)
                FROM Vehiculo v
                """, vehiculoDTO.class);
        return qryAll.getResultList();

    }
    public void close() {
        em.close();
    }

}

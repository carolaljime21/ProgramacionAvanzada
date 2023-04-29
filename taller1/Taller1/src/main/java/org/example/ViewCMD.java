package org.example;

public class ViewCMD {
    public static void main(String[] args) throws Exception {
        VehiculoController db = new VehiculoController();
        for(var data : db.getAllVehicles()) {
            System.out.printf(
                            "%d - %s - %d - %s - %s - %s - %s - %f - %s\n",
                    data.id(),
                    data.placa(),
                    data.anioFabricacion(),
                    data.nroChasis(),
                    data.nroMotor(),
                    data.color1(),
                    data.color2(),
                    data.avaluo(),
                    data.prendado());
        }
        db.close();

    }

}
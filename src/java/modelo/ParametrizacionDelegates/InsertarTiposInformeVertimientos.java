package modelo.ParametrizacionDelegates;

import configuracion.Queries;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.DbManager;

public class InsertarTiposInformeVertimientos {

    //Atributos
    private String descripcion;
    private DbManager db;


    /**
     *
     * Constructor
     *
     * @param descripcion
     */
    public InsertarTiposInformeVertimientos(String descripcion) {

        this.descripcion = descripcion;
        db = new DbManager();
        
    }




    /**
     *
     * Ejecuta el procedimiento almacenado SpInsertarTiposContactos.
     *
     * @throws Exception
     */
    public void ejecutar() throws Exception{

        CallableStatement callableStatement = null;
        
        //Conectamos con la bd.
        Connection conn = db.conectar();
        
        try{

            //Preparamos y ejecutamos el procedimiento.
            callableStatement = conn.prepareCall(Queries
                    .getString("SpInsertarTipoInforVertimiento"));

            //Preparamos los parametros
            callableStatement.setString(1, descripcion);

            //Ejecutamos el procedimiento
            callableStatement.execute();

            //Cerramos la conexion
            db.desconectar(conn);

        }catch(Exception e){

            db.desconectar(conn);
            throw e;

        }finally{

             if(callableStatement != null){

                callableStatement.clearParameters();
                callableStatement.close();

            }

        }

    }
    //-----------------------------------------------------------------------------



}
